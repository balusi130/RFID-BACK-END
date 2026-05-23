package com.rfid.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cardUid;

    private String ownerName;
    private String role;
    private boolean active;
    private LocalDateTime registeredAt;

    public Card() {}

    public Card(String cardUid, String ownerName, String role) {
        this.cardUid = cardUid;
        this.ownerName = ownerName;
        this.role = role;
        this.active = true;
        this.registeredAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getCardUid() { return cardUid; }
    public String getOwnerName() { return ownerName; }
    public String getRole() { return role; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public LocalDateTime getRegisteredAt() { return registeredAt; }
}