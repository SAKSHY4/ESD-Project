package com.example.sakshya_esd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseScheduleDTO {
    private Long courseId;
    private String courseName;
    private String courseCode;
    private Integer time;
    private Integer day;
    private String room;
    private String building;
}