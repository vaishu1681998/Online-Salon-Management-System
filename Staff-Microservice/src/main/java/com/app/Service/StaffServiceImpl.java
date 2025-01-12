package com.app.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.StaffDto;
import com.app.entity.Gender;
import com.app.entity.Staff;
import com.app.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StaffDto getStaffById(long id) {
		// Retrieve staff by ID, or throw an exception if not found
		Staff staff = staffRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Staff not found with id: " + id));

		// Map the Staff entity to StaffDto using ModelMapper
		return modelMapper.map(staff, StaffDto.class);
	}

	@Override
	public List<StaffDto> getAllStaff() {
		// Retrieve all staff from the repository
		Iterable<Staff> staffIterable = staffRepository.findAll();

		// Convert Iterable to Stream, map each Staff to StaffDto, and collect to a List
		return StreamSupport.stream(staffIterable.spliterator(), false)
				.map(staff -> modelMapper.map(staff, StaffDto.class)).collect(Collectors.toList());
	}

	@Override
	public StaffDto createStaff(StaffDto staffDto) {
		// TODO Auto-generated method stub
		Staff staff = modelMapper.map(staffDto, Staff.class);
		Staff saveStaff = staffRepository.save(staff);
		return modelMapper.map(saveStaff, StaffDto.class);
	}

	@Override
	public StaffDto updateStaff(long id, StaffDto staffDto) {
	    Staff existingStaff = staffRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Staff not found by ID: " + id));
	    
	    // Set other fields
	    existingStaff.setName(staffDto.getName());
	    existingStaff.setRole(staffDto.getRole());

	    // Convert String to Gender enum
	    existingStaff.setGender(Gender.valueOf(staffDto.getGender().toUpperCase()));

	    Staff updatedStaff = staffRepository.save(existingStaff);
	    return modelMapper.map(updatedStaff, StaffDto.class);
	}



	@Override
	public void deleteStaff(long id) {
		// TODO Auto-generated method stub
		Staff staff = staffRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Staff not found with id: " + id));
		staffRepository.delete(staff);
	}

}
