package com.easylearn.easylearn.entity;

import com.easylearn.easylearn.model.enums.ParentType;
import com.easylearn.easylearn.model.enums.UserType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder

public class Parent extends User {

    @Enumerated(value = EnumType.STRING)
    private ParentType type;

    @Enumerated(value = EnumType.STRING)
    private UserType userType = UserType.TEACHER;

    @JoinColumn(name = "parent_id")
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Student> students;

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStudents(Set<Student> students) {this.students.addAll(students);}
}

