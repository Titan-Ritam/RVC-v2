package com.purohit.app.dto;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventDto {
    
    private int id;
    @NotEmpty(message = "Please enter a needful purpose")
    private String eventName;
    @Future(message = "Date must be in future")
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate eventDate;
    @NotEmpty(message="Please provide Street name")
    private String street;
    @NotEmpty(message="Please enter city name")
    private String city;
    @NotEmpty(message="please Select State")
    private String state;
    private String notes;


    
}
