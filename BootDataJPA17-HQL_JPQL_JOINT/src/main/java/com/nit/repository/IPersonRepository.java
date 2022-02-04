package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

//	@Query("SELECT p.pid,p.pname,p.address,ph.redg,ph.Number,ph.type,ph.ProviderName from Person p inner join p.phoneNo ph")
	
//	@Query("SELECT p.pid,p.pname,p.address,ph.redg,ph.Number,ph.type,ph.ProviderName from Person p left join p.phoneNo ph")
	
	@Query("SELECT p.pid,p.pname,p.address,ph.redg,ph.Number,ph.type,ph.ProviderName from Person p right join p.phoneNo ph")
	
	//@Query("SELECT p.pid,p.pname,p.address,ph.redg,ph.Number,ph.type,ph.ProviderName from Person p full join p.phoneNo ph")
	//(for MySql full outer join is not available but in oracle it is available)
	
	List<Object[]> getDataByJoins();
}
