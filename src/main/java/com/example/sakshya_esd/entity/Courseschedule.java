package com.example.sakshya_esd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courseschedules")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Courseschedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")  // Ensures consistent column name across all references
    private Course course;

    @Column
    private Integer time;

    @Column
    private Integer day;

    @Column
    private String room;

    @Column
    private String building;
}
