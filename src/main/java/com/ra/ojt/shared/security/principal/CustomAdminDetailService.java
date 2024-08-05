package com.ra.ojt.shared.security.principal;

import com.ra.ojt.modules.admin.entity.Admin;
import com.ra.ojt.modules.admin.repository.AdminRepository;
import com.ra.ojt.modules.candidate.entity.Candidate;
import com.ra.ojt.modules.candidate.repository.CandidateRepository;
import com.ra.ojt.modules.role.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
@Service
public class CustomAdminDetailService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmail(email).orElse(null);
        if (admin == null) {
            CustomAdminDetail customAdminDetail = CustomAdminDetail.builder()
                    .id(admin.getId())
                    .name(admin.getName())
                    .password(admin.getPassword())
                    .email(admin.getEmail())
                    .authorities(functionConvertRoleToGrandAuthorities(admin.getRole()))
                    .build();

            return customAdminDetail;
        }
       else return null;
    }

    private Collection<? extends GrantedAuthority> functionConvertRoleToGrandAuthorities(Role role) {
        return Collections.singleton(new SimpleGrantedAuthority(role.getRoleName().toString()));
    }
}
