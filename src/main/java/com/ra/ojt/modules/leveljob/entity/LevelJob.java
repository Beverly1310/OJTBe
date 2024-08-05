//package com.ra.ojt.modules.leveljob.entity;
//
//import com.ra.ojt.modules.jobs.entity.Job;
//import jakarta.persistence.*;
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//import java.time.LocalDate;
//import java.util.Set;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Builder
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity
//public class LevelJob {
//    @Id
//    String id;
//    String name;
//    LocalDate createAt;
//    LocalDate updateAt;
//    @ManyToMany
//    @JoinTable(name = "leveljob",
//            joinColumns = @JoinColumn(name = "level_id"),
//            inverseJoinColumns = @JoinColumn(name = "id"))
//    Set<Job> jobs;
//}
