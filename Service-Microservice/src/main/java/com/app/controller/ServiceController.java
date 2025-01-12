package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.ServicesDto;
import com.app.service.ServicesService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

	@Autowired
	private ServicesService servicesService;

	@GetMapping("/{id}")
	public ServicesDto getServiceByid(@PathVariable("id") long id) {
		return servicesService.getServiceById(id);
	}

	@PostMapping
	public ServicesDto createServices(@RequestBody ServicesDto servicesDto) {
		return servicesService.createServices(servicesDto);
	}

	@GetMapping
	public List<ServicesDto> getAllServices() {
		return servicesService.getAllServices();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteServices(@PathVariable long id) {
		servicesService.deleteServices(id);
		return ResponseEntity.noContent().build(); // Return 204 No Content response
	}

	@PutMapping("/{id}")
	public ResponseEntity<ServicesDto> updateServices(@PathVariable long id, @RequestBody ServicesDto servicesDto) {
		ServicesDto updateServices = servicesService.updateServices(id, servicesDto);
		return ResponseEntity.ok(updateServices);
	}

}
