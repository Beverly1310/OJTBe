package com.ra.ojt.modules.typecompany.entity;
import com.ra.ojt.modules.candidate.entity.Candidate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class TypeCompany {
    @Id
    String id;
    String name;
    LocalDate createdAt;
    LocalDate updatedAt;
}
