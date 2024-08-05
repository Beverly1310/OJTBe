//package com.ra.ojt.modules.skillcandidate.entity;
//import com.ra.ojt.modules.candidate.entity.Candidate;
//import com.ra.ojt.modules.leveljob.entity.LevelJob;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Builder
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity
//public class SkillCandidate {
//    @Id
//    String id;
//    String name;
//    @ManyToOne
//    @JoinColumn(name = "level_job_id", referencedColumnName = "id")
//    LevelJob levelJob;
//    @ManyToOne
//    @JoinColumn(name = "candidate_id",referencedColumnName = "id")
//    Candidate candidate;
//
//}
