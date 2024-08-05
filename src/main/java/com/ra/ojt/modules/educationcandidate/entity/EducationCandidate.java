package com.ra.ojt.modules.educationcandidate.entity;

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
public class EducationCandidate {
    @Id
    String id;
    String name;
    String major;
    LocalDate startAt;
    LocalDate endAt;
    String info;
    LocalDate createdAt;
    LocalDate updatedAt;
    @ManyToOne
    @JoinColumn(name = "candidate_id",referencedColumnName = "id")
    Candidate candidate;
}
