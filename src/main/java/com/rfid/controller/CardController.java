package com.rfid.controller;

import com.rfid.model.Card;
import com.rfid.model.AccessLog;
import com.rfid.repository.CardRepository;
import com.rfid.repository.AccessLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AccessLogRepository accessLogRepository;

    @GetMapping("/cards")
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @PostMapping("/cards/register")
    public ResponseEntity<Card> registerCard(@RequestBody Card card) {
        Card saved = cardRepository.save(card);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/cards/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/access/verify")
    public ResponseEntity<AccessLog> verifyAccess(@RequestParam String cardUid) {
        Optional<Card> card = cardRepository.findByCardUid(cardUid);
        boolean granted = card.isPresent() && card.get().isActive();
        String owner = card.map(Card::getOwnerName).orElse("Unknown");
        AccessLog log = accessLogRepository.save(new AccessLog(cardUid, owner, granted));
        return ResponseEntity.ok(log);
    }

    @GetMapping("/access/logs")
    public List<AccessLog> getAccessLogs() {
        return accessLogRepository.findAll();
    }
}