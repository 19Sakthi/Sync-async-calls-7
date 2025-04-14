package com.Verinite.StudentProducer.repo;

import com.Verinite.StudentProducer.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {
}
