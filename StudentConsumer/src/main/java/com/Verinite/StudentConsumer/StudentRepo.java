package com.Verinite.StudentConsumer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo  extends JpaRepository<StudentEntity,Integer> {

}
