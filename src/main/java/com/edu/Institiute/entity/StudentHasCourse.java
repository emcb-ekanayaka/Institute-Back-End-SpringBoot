package com.edu.Institiute.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "student_has_course")
public class StudentHasCourse {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="student_id", referencedColumnName = "id")
    private Student studentId;

    @ManyToOne
    @JoinColumn(name="course_id", referencedColumnName = "id")
    private Course courseId;
}
