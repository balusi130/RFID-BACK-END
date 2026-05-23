package com.rfid.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "access_logs")
public class AccessLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardUid;
    private String ownerName;
    private boolean accessGranted;
    private LocalDateTime timestamp;

    public AccessLog() {}

    public AccessLog(String cardUid, String ownerName, boolean accessGranted) {
        this.cardUid = cardUid;
        this.ownerName = ownerName;
        this.accessGranted = accessGranted;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getCardUid() { return cardUid; }
    public String getOwnerName() { return ownerName; }
    public boolean isAccessGranted() { return accessGranted; }
    public LocalDateTime getTimestamp() { return timestamp; }
}