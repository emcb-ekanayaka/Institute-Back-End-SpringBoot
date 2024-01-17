package com.edu.Institiute.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "qualification")
public class Qualification {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="qualificationname")
    private String qualificationName;

    @OneToMany(mappedBy = "qualification", cascade = CascadeType.ALL)
    private List<Teacher> teachers;
}
