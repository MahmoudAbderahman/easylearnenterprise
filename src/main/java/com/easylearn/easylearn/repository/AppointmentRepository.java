/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Appointment Repository Interface is where storage, retrieval and search behavior is declared.
 */
package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Appointment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AppointmentRepository extends BaseRepository<Appointment, Long> {
    Set<Appointment> findAllByCourseIdNull(Sort sort);

    Set<Appointment> findAllByCourseId(Long courseId, Sort sort);

    Set<Appointment> findAll(Sort sort);

    @Query(value = "SELECT * FROM appointment a WHERE a.course_id in (select c.id from course c WHERE(c.id in (Select course_id from course_student where course_student.student_id = :student_id)))", nativeQuery = true)
    Set<Appointment> findAllAppointmentsOfStudentCourses(@Param("student_id") Long studentId);
}
