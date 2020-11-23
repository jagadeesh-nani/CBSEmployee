package com.pack.cbs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.cbs.model.CBSEmployee;

/** This is a repository class for CBSEmployee module 
 * 
 * @author Reshma's
 *
 */


@Repository
public interface CBSEmployeeRepository extends JpaRepository<CBSEmployee, Integer>  {

}
