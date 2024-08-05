package com.ra.ojt.shared.security.jwt;


import com.ra.ojt.shared.security.principal.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JWTProvider jwtProvider;
    @Autowired
    private CustomCandidateDetailService userDetailsService;
    @Autowired
    private CustomCompanyDetailService customCompanyDetailService;
    @Autowired
    private CustomAdminDetailService customAdminDetailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenFormRequest(request);
        if(token!=null && !token.isEmpty()){
            //xac thuc chuoi token
            boolean valid = jwtProvider.validateToken(token);
            if(valid){
                //phai tach username tu token
                String username = jwtProvider.getUsernameFromToken(token);
                //lay thong tin tai khoan trong database (lien quan CustomDetailService)
                Authentication auth = null;
                CustomCandidateDetail customCandidateDetail = (CustomCandidateDetail) userDetailsService.loadUserByUsername(username);
                CustomCompanyDetail customCompanyDetail = (CustomCompanyDetail) customCompanyDetailService.loadUserByUsername(username);
                CustomAdminDetail customAdminDetail = (CustomAdminDetail) customAdminDetailService.loadUserByUsername(username);
                 if(customCandidateDetail!=null){
                     auth = new UsernamePasswordAuthenticationToken(customCandidateDetail,null,customCandidateDetail.getAuthorities());
                 }
                if(customCompanyDetail!=null){
                    auth = new UsernamePasswordAuthenticationToken(customCompanyDetail,null,customCompanyDetail.getAuthorities());
                }
                if(customAdminDetail!=null){
                    auth = new UsernamePasswordAuthenticationToken(customAdminDetail,null,customAdminDetail.getAuthorities());
                }
                //set vao SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request,response);
    }

    private String getTokenFormRequest(HttpServletRequest request) {
        String header_au = request.getHeader("Authorization");
        if(header_au!=null && header_au.startsWith("Bearer ")){
            return header_au.substring("Bearer ".length());
        }
        return null;
    }

}