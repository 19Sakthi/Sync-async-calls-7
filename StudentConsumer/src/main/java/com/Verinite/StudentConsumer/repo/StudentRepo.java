package com.Verinite.StudentConsumer.repo;

import com.Verinite.StudentConsumer.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo  extends JpaRepository<StudentEntity,Integer> {

}
