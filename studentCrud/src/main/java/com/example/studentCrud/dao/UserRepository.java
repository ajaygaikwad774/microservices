package com.example.studentCrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.studentCrud.model.User;


public interface UserRepository extends JpaRepository<User, Long>  {

}

/* both 
  public interface UserRepository extends CrudRepository<User, Long>  {
  
  }
 */

