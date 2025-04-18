package com.verinite.StudentKafha.repo;

import com.verinite.StudentKafha.dto.StudentDto;
import com.verinite.StudentKafha.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {
}
