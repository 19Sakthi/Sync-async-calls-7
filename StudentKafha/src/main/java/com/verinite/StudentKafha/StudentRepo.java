package com.verinite.StudentKafha;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentDto,Integer> {
}
