package com.ra.ojt.shared.security.principal;

import lombok.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomCompanyDetail implements UserDetails {

    String id;
    Long accountCompanyId;
    String name;
    String logo;
    String website;
    String linkFb;
    String linkLinked;
    Long follower;
    Long size;
    String typeCompanyId;
    String description;
    LocalDate createdAt;
    LocalDate updatedAt;
    String email;
    String password;
    Boolean isDeleted = false;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
        return isDeleted ;
    }
}