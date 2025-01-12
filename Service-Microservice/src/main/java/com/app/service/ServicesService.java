package com.app.service;

import java.util.List;

import com.app.Dto.ServicesDto;

public interface ServicesService {
	
	ServicesDto createServices(ServicesDto servicesDto);

	ServicesDto getServiceById(long id);

	List<ServicesDto> getAllServices();
	
	void deleteServices(Long id);
	
	ServicesDto updateServices(long id, ServicesDto servicesDto);

}
