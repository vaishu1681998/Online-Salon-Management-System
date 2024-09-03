package com.app.Service;

import java.util.List;

import com.app.Dto.StaffDto;

public interface StaffService {
	
	StaffDto getStaffById(long id);
	
	List<StaffDto> getAllStaff();
	
	StaffDto createStaff(StaffDto staffDto);
	
	StaffDto updateStaff(long id, StaffDto staffDto);
	
	void deleteStaff(long id);
	
	

}
