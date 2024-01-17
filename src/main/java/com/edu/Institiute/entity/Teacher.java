package com.edu.Institiute.entity;

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
@Table(name = "teacher")
public class Teacher {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="teachercode")
    private String teacherCode;

    @Column(name="teachername")
    private String teacherName;

    @ManyToOne
    @JoinColumn(name="course_id", referencedColumnName = "id")
    private Course course;

    @ManyToOne
    @JoinColumn(name="qualification_id", referencedColumnName = "id")
    private Qualification qualification;
}
