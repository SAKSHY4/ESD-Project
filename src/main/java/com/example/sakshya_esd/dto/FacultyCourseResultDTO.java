package com.example.sakshya_esd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacultyCourseResultDTO {
    private Long facultyId;
    private String facultyName;
    private String courseName;
    private String courseCode;
}