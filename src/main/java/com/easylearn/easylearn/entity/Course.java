package com.easylearn.easylearn.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Course {

    @Id
    @Column(unique = true, nullable = false)
    private String courseCode;

    @Column(nullable = false)
    private String name;

    private int grade;

    private String content;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    private Set<Appointment> appointments;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "course_student",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private Set<Student> students = new HashSet<>();
}
