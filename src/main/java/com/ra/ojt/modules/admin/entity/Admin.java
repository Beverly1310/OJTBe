package com.ra.ojt.modules.admin.entity;

import com.ra.ojt.constant.RoleName;
import com.ra.ojt.modules.role.entity.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Admin {
    @Id
    String id;
    String email;
    String password;
    String name;
    @OneToOne
    Role role=new Role(3L, RoleName.ADMIN);
}
