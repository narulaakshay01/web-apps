package com.uic.demo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uic.demo.dao.CustomRepoInterface;

@Service
public class ServicesImpl implements Services {

	@Autowired
	CustomRepoInterface cust;
	
	@Override
	public Map<String, Object> getTrivialQueries() {
		Map<String,Object> ret=new HashMap<String, Object>();
		ret.put("Query1", cust.getTrivial(0));
		ret.put("Query2", cust.getTrivial(1));
		ret.put("Query3", cust.getTrivial(2));
		return ret;
	}

	@Override
	public Map<String, Object> getNonTrivialQueries() {
		Map<String,Object> ret=new HashMap<String, Object>();
		ret.put("Query1", cust.getComplex(0));
		ret.put("Query2", cust.getComplex(1));
		ret.put("Query3", cust.getComplex(2));
		ret.put("Query4", cust.getComplex(3));
		ret.put("Query5", cust.getComplex(4));
		return ret;
	}
}