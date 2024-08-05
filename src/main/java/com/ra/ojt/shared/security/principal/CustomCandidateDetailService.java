package com.ra.ojt.shared.security.principal;


import com.ra.ojt.modules.admin.entity.Admin;
import com.ra.ojt.modules.admin.repository.AdminRepository;
import com.ra.ojt.modules.candidate.entity.Candidate;
import com.ra.ojt.modules.candidate.repository.CandidateRepository;
import com.ra.ojt.modules.company.entity.Company;
import com.ra.ojt.modules.company.repository.CompanyRepository;
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
public class CustomCandidateDetailService implements UserDetailsService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Candidate candidate = candidateRepository.findCandidateByEmail(email).orElse(null);
        if (candidate == null) {
            CustomCandidateDetail candidateDetail = CustomCandidateDetail.builder()
                    .id(candidate.getId())
                    .name(candidate.getName())
                    .password(candidate.getPassword())
                    .email(candidate.getEmail())
                    .phone(candidate.getPhone())
                    .isOpen(candidate.getIsOpen())
                    .dob(candidate.getDob())
                    .gender(candidate.getGender())
                    .linkFb(candidate.getLinkFb())
                    .linkLinkedin(candidate.getLinkLinkedin())
                    .linkGit(candidate.getLinkGit())
                    .createdAt(candidate.getCreatedAt())
                    .updatedAt(candidate.getUpdatedAt())
                    .authorities(functionConvertRoleToGrandAuthorities(candidate.getRole()))
                    .build();
            return candidateDetail;
        }
        else return null;
    }

    private Collection<? extends GrantedAuthority> functionConvertRoleToGrandAuthorities(Role role) {
        return Collections.singleton(new SimpleGrantedAuthority(role.getRoleName().toString()));
    }}