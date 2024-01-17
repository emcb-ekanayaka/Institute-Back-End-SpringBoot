package com.edu.Institiute.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="coursecode")
    private String courseCode;

    @Column(name="coursename")
    private String courseName;

    @OneToMany(mappedBy = "courseId", cascade = CascadeType.ALL)
    private List<StudentHasCourse> studentHasCourses;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Teacher> teachers;
}
