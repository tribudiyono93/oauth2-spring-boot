package com.tribudiyono93.ws.api.ResourceServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tribudiyono93.ws.api.ResourceServer.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private Environment env;
	
	@GetMapping("/status/check")
	public String status() {
		return "working ... " + env.getProperty("local.server.port");
	}
	
	//@PreAuthorize("hasRole('developer')")
	@PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
	//@PreAuthorize("hasAuthority('ROLE_developer')")
	//@Secured("ROLE_developer")
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id ,@AuthenticationPrincipal Jwt jwt) {
		return "Deleted user with id " + id + " and subject " + jwt.getSubject();
	}
	
	@PostAuthorize("returnObject.userId == #jwt.subject")
	@GetMapping("/{id}")
	public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return new UserRest("Tri", "Budiyono", "45732be4-716c-4fe8-abc0-ec3ab5b21be4");
	}
	
}
