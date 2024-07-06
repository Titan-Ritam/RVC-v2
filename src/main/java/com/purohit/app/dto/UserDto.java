package com.purohit.app.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {
    
    private int  id;
    @NotEmpty
    private String name;
    @Email(message = "Enter a Valid Email")
    private String email;
    @NotEmpty(message = "Enter a Password")
    private String password;
    @NotEmpty(message = "Select a Role")
    private String role;
    @NotEmpty
    @Size(max = 10, min = 10,message = "Enter a Valid Phone Number")
    private String phone;


}
 