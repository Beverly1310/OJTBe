//package com.ra.ojt.modules.typejob.entity;
//
//import com.ra.ojt.modules.jobs.entity.Job;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//
//import java.time.LocalDate;
//import java.util.Set;
//import com.ra.ojt.modules.candidate.entity.Candidate;
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
//public class TypeJob {
//    @Id
//    String id;
//    String name;
//    LocalDate createAt;
//    LocalDate updateAt;
//    @ManyToMany
//    @JoinTable(name = "typejob",
//            joinColumns = @JoinColumn(name="id"),
//            inverseJoinColumns = @JoinColumn(name = "type_id"))
//    Set<Job> jobs;
//}
