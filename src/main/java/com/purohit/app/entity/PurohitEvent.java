package com.purohit.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "purohit_event")
public class PurohitEvent {
    
    @Id
    private int id;
    private String eventName;
    private LocalDate eventDate;
    private String street;
    private String city;
    private String state;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "purohit")
    private User user;
}
