package com.uic.demo.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.uic.demo.dao.AuthorRepoInterface;
import com.uic.demo.dao.CustomNativeRepository;
import com.uic.demo.dao.ReviewerRepoInterface;
import com.uic.demo.dao.UserRepoInterface;
import com.uic.demo.entity.Author;
import com.uic.demo.entity.Reviewer;
import com.uic.demo.entity.User;
import com.uic.demo.services.Services;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {
	@Autowired
	UserRepoInterface userRepo;

	@Autowired
	AuthorRepoInterface authRepo;

	@Autowired
	ReviewerRepoInterface revRepo;

	@Autowired
	Services service;
	
	@Autowired
	CustomNativeRepository cust;

	@GetMapping(path = { "/user", "/user/{name}" })
	public Iterable<User> getUser(@PathVariable(name = "name", required = false) String name)
			throws JsonProcessingException {
		if (name == null) {
			return userRepo.findAll();
		} else {
			return userRepo.findByName(name);
		}
	}

	@GetMapping("/user/delete/{id}")
	public void deleteUser(@PathVariable(name = "id") String id) throws JsonProcessingException {
		userRepo.deleteById(Integer.parseInt(id));
	}

	@PostMapping("/user")
	public void updateUser(@RequestBody User user) throws JsonProcessingException {
		userRepo.save(user);
	}

	@GetMapping(path = { "/author", "/author/{name}" })
	public Iterable<Author> getAuthor(@PathVariable(name = "name", required = false) Optional<String> name)
			throws JsonProcessingException {
		if (!name.isPresent()) {
			return authRepo.findAll();
		} else {
			return authRepo.findByName(name.get());
		}
	}

	@GetMapping("/author/delete/{id}")
	public void deleteAuthor(@PathVariable(name = "id") String id) throws JsonProcessingException {
		authRepo.deleteById(Integer.parseInt(id));
	}

	@PostMapping("/author")
	public void updateAuthor(@RequestBody Author author) throws JsonProcessingException {
		authRepo.save(author);
	}

	@GetMapping(path = { "/reviewer", "/reviewer/{name}" })
	public Iterable<Reviewer> getReviewer(@PathVariable(name = "name", required = false) Optional<String> name)
			throws JsonProcessingException {
		if (!name.isPresent()) {
			return revRepo.findAll();
		} else {
			return revRepo.findByName(name.get());
		}
	}

	@GetMapping("/reviewer/delete/{id}")
	public void deleteReviewer(@PathVariable(name = "id") String id) throws JsonProcessingException {
		revRepo.deleteById(Integer.parseInt(id));
	}

	@PostMapping("/reviewer")
	public void updateReviewer(@RequestBody Reviewer reviewer) throws JsonProcessingException {
		revRepo.save(reviewer);
	}

	@GetMapping("/trivial")
	public Map<String, Object> getTrivialQueries() throws JsonProcessingException {
		return service.getTrivialQueries();
	}

	@GetMapping("/complex")
	public Map<String, Object> getComplexQueries() throws JsonProcessingException {
		return service.getNonTrivialQueries();
	}
	
	@GetMapping("/init")
	public void init() throws JsonProcessingException {
		cust.init();
	}
}  
