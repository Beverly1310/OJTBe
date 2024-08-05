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
public class CustomCandidateDetail implements UserDetails {

    private  String id;
    private  String name;
    private Integer isOpen;
    private LocalDate dob;
    private  String email;
    private  String phone;
    private  String password;
    private Integer gender;
    private String linkFb;
    private String linkLinkedin;
    private String linkGit;
    private LocalDate createdAt;
    private LocalDate updatedAt;

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
        return isOpen==1 ;
    }
}