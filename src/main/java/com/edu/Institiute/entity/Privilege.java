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
@Table(name = "privilege")
public class Privilege {

    @Id
    @Column(name="id")
    private String id;

    @ManyToOne
    @JoinColumn(name="roles_id", referencedColumnName = "roleName")
    private Role roleId;

    @ManyToOne
    @JoinColumn(name="module_id", referencedColumnName = "id")
    private Module moduleId;

    @Column(name="sel")
    private String sel;

    @Column(name="ins")
    private String ins;

    @Column(name="upd")
    private String upd;

    @Column(name="del")
    private String del;
}
