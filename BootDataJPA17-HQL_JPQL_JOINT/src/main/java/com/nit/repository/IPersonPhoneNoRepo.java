package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.PersonPhoneNo;

public interface IPersonPhoneNoRepo extends JpaRepository<PersonPhoneNo ,Integer> {

}
