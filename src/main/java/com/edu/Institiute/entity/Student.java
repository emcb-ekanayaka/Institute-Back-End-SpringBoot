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
@Table(name = "student")
public class Student {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="studentcode")
    private String studentCode;

    @Column(name="studentname")
    private String studentName;

    @Column(name="studentage")
    private String studentAge;

    @Column(name="studentnic")
    private String studentNic;

    @ManyToOne
    @JoinColumn(name="status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL)
    private List<StudentHasCourse> studentHasCourses;

}
