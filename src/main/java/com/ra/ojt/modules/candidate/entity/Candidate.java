package com.ra.ojt.modules.candidate.entity;

import com.ra.ojt.constant.RoleName;
import com.ra.ojt.modules.role.entity.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Candidate {
    @Id
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
    @OneToOne
    private Role role=new Role(1L, RoleName.CANDIDATE);
}
