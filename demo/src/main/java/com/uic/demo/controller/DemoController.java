package com.uic.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uic.demo.dao.AuthorRepoInterface;
import com.uic.demo.dao.ContentRepoInterface;
import com.uic.demo.dao.CustomNativeRepository;
import com.uic.demo.dao.CustomRepoInterface;
import com.uic.demo.dao.ReviewerRepoInterface;
import com.uic.demo.dao.UserRepoInterface;
import com.uic.demo.entity.Author;
import com.uic.demo.entity.Reviewer;
import com.uic.demo.entity.User;

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
	ContentRepoInterface contentRepo;

	@Autowired
	CustomRepoInterface custRepo;

	@Autowired
	CustomNativeRepository custNatRepo;

	@GetMapping("/user/{param}")
	public Iterable<User> getUser(@PathVariable(name = "param") String param) throws JsonProcessingException {
		if (param.equals("all")) {
			return userRepo.findAll();
		} else {
			return userRepo.findByName(param);
		}
	}

	@GetMapping("/user/delete/{param}")
	public void deleteUser(@PathVariable(name = "param") int param) throws JsonProcessingException {
		userRepo.deleteById(param);
	}

	@PostMapping("/user/create")
	public void updateUser(@RequestBody User user) throws JsonProcessingException {
		userRepo.save(user);
	}

	@GetMapping("/author/{param}")
	public Iterable<Author> getAuthor(@PathVariable(name = "param") String param) throws JsonProcessingException {
		if (param.equals("all")) {
			return authRepo.findAll();
		} else {
			return authRepo.findByName(param);
		}
	}

	@GetMapping("/author/delete/{param}")
	public void deleteAuthor(@PathVariable(name = "param") int param) throws JsonProcessingException {
		authRepo.deleteById(param);
	}

	@PostMapping("/author/create")
	public void updateAuthor(@RequestBody Author author) throws JsonProcessingException {
		authRepo.save(author);
	}

	@GetMapping("/reviewer/{param}")
	public Iterable<Reviewer> getReviewer(@PathVariable(name = "param") String param) throws JsonProcessingException {
		if (param.equals("all")) {
			return revRepo.findAll();
		} else {
			return revRepo.findByName(param);
		}
	}

	@GetMapping("/reviewer/delete/{param}")
	public void deleteReviewer(@PathVariable(name = "param") int param) throws JsonProcessingException {
		revRepo.deleteById(param);
	}

	@PostMapping("/reviewer/create")
	public void updateReviewer(@RequestBody Reviewer reviewer) throws JsonProcessingException {
		revRepo.save(reviewer);
	}

	@PostMapping("/data")
	public void putSomething(@RequestBody Author body) throws JsonProcessingException {
		System.out.println(new ObjectMapper().writeValueAsString(body));

	}
}
