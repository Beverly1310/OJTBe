package com.ra.ojt.modules.company.entity;

import com.ra.ojt.constant.RoleName;
import com.ra.ojt.modules.role.entity.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Company {
    @Id
    String id;
    Long accountCompanyId;
    String email;
    String password;
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
    Boolean isDeleted = false;
    @OneToOne
    Role role=new Role(2L, RoleName.COMPANY);
}
