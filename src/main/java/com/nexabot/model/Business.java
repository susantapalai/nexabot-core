package com.nexabot.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "businesses")
@Data
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String ownerEmail;
    private String whatsappNumber;
    private String location;
    private String timings;

    @Column(columnDefinition = "TEXT")
    private String menu;

    @Column(columnDefinition = "TEXT")
    private String faqs;

    private String deliveryInfo;
    private String contactNumber;
    private boolean active;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        active = true;
    }
}