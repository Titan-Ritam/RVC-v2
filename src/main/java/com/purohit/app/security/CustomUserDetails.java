package com.purohit.app.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.purohit.app.entity.User;

public class CustomUserDetails implements UserDetails {

    private User user;

    

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       SimpleGrantedAuthority authority = new SimpleGrantedAuthority("User");
       SimpleGrantedAuthority authority1 = new SimpleGrantedAuthority("Purohit");
        return  List.of(authority, authority1);
    }

    @Override
    public String getPassword() {
        
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;
    }

    @Override
    public boolean isEnabled() {
    
        return true;
    }
    
}
