package com.ra.ojt.modules.jobs.entity;

import com.ra.ojt.modules.location.entity.Location;
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
public class Job {
    @Id
    String id;
    String title;
    String description;
    String salary;
    LocalDate expireAt;
    LocalDate createdAt;
    LocalDate updatedAt;
    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    Location location;
}
