package com.purohit.app.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String eventName;
    private LocalDate eventDate;
    private String street;
    private String city;
    private String state;
    private String notes;

    @ManyToOne
    @JsonBackReference
    private User user;

    @Override
    public String toString() {
        return "Event [id=" + id + ", eventName=" + eventName + ", eventDate=" + eventDate + ", street=" + street
                + ", city=" + city + ", state=" + state + ", notes=" + notes + ", user_id=" + user.getId() + "]";
    }

    

}
