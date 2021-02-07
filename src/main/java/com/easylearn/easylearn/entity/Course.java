/**
 * @Author: Mahmoud Abdelrahman
 * Course Entity is where all Course specifications are declared.
 */
package com.easylearn.easylearn.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increament
    private Long id;

    @Column(unique = true, nullable = false)
    private String courseCode;

    @Column(nullable = false)
    private String name;

    private int grade;

    private String content;

    @Column(nullable = false)
    private String description;

    // LAZY is used in OneToMany relationships, because we get only the existed relationships.
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Teacher teacher;

    @JoinColumn(name = "course_id")
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Appointment> appointments;


    // EAGER is used in ManyToMany relationships, because we get all the relationships.
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "course_student",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private Set<Student> students;


    public void addAppointments(Set<Appointment> appointments) {
        this.appointments.addAll(appointments);
    }


    public void addStudents(Set<Student> students) {
        this.students.addAll(students);
    }

}
