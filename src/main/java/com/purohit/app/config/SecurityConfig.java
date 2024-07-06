package com.purohit.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.purohit.app.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    UserDetailsService getUserDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
            
        }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity security) throws Exception{
        
        security.csrf(cus->{
            cus.disable();
         }); 
    
         security.authorizeHttpRequests(customizer->{
                // customizer.requestMatchers("/user/save").permitAll();
                // customizer.requestMatchers("/user/**").permitAll();
                // customizer.requestMatchers("/purohit/**").permitAll();

                // .requestMatchers("/purohit/**").hasAuthority("Purohit")
                // .anyRequest().authenticated();
                
                customizer.anyRequest().permitAll();
                
               
         });

          
        security.formLogin(t ->{
                // t.loginPage("/signin")
                // .loginProcessingUrl("/login")
                // .defaultSuccessUrl("/home")
                // .permitAll();
                t.loginProcessingUrl("/login")
                .defaultSuccessUrl("/home")
                .permitAll();
        });

         return security.build();
    

}

}
