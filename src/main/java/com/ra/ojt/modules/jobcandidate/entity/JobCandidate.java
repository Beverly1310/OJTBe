package com.ra.ojt.modules.jobcandidate.entity;

import com.ra.ojt.modules.candidate.entity.Candidate;
import com.ra.ojt.modules.jobs.entity.Job;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class JobCandidate {
    @Id
    String id;
    String cvUrl;
    String content;
    Integer status;
    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "job_id",referencedColumnName = "id")
    Job job;
}
