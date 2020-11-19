package com.pack.cbs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.cbs.model.CBSEmployee;

@Repository
public interface CBSEmployeeRepository extends JpaRepository<CBSEmployee, Integer>  {

}
