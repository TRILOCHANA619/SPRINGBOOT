package com.nit.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Person;
import com.nit.entity.PersonPhoneNo;
import com.nit.repository.IPersonPhoneNoRepo;
import com.nit.repository.IPersonRepository;

@Service("PrsonInfoService")
public class PersomInfoMgmtImpl implements IPersonInfoService {

	@Autowired
	private IPersonRepository repo;

	@Autowired
	private IPersonPhoneNoRepo phoneRepo;

	@Override
	public List<Object[]> fechDataByJoin() {

		return repo.getDataByJoins();
	}





}
