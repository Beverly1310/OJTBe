package com.ra.ojt.shared.security.principal;


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
public class CustomCompanyDetailService implements UserDetailsService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Company company = companyRepository.findByEmail(email).orElse(null);
        if (company == null) {
            CustomCompanyDetail companyDetail = CustomCompanyDetail.builder()
                    .id(company.getId())
                    .name(company.getName())
                    .password(company.getPassword())
                    .email(company.getEmail())
                    .linkFb(company.getLinkFb())
                    .linkLinked(company.getLinkLinked())
                    .linkFb(company.getLinkFb())
                    .follower(company.getFollower())
                    .logo(company.getLogo())
                    .website(company.getWebsite())
                    .size(company.getSize())
                    .typeCompanyId(company.getTypeCompanyId())
                    .description(company.getDescription())
                    .isDeleted(company.getIsDeleted())
                    .createdAt(company.getCreatedAt())
                    .updatedAt(company.getUpdatedAt())
                    .authorities(functionConvertRoleToGrandAuthorities(company.getRole()))
                    .build();
            return companyDetail;
        } else return null;

    }

    private Collection<? extends GrantedAuthority> functionConvertRoleToGrandAuthorities(Role role) {
        return Collections.singleton(new SimpleGrantedAuthority(role.getRoleName().toString()));
    }
}
