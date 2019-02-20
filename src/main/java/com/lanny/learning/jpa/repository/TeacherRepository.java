package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.both12n.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lanny Yao
 * @date 7/8/2018 12:39 PM
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
