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

import com.app.Dto.StaffDto;
import com.app.Service.StaffService;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping("/{id}")
	public StaffDto getStaffById(@PathVariable long id)
	{
		return staffService.getStaffById(id);
	}
	
	@PostMapping
	public StaffDto createStaff(@RequestBody StaffDto staffdto) {
		return staffService.createStaff(staffdto);
	}
	
	@GetMapping
	public List<StaffDto> getAllStaff() {
	    return staffService.getAllStaff();
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<StaffDto> updateStaff(@PathVariable long id, @RequestBody StaffDto staffDto){
		StaffDto updateStaff = staffService.updateStaff(id, staffDto);
		return ResponseEntity.ok(updateStaff);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStaff(@PathVariable long id){
		staffService.deleteStaff(id);
		return ResponseEntity.noContent().build();
	}
}
