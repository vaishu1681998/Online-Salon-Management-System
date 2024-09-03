package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.ServicesDto;
import com.app.entity.Services;
import com.app.repository.ServiceRepository;

@Service
public class ServicesServiceImpl implements ServicesService{

	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ServicesDto createServices(ServicesDto servicesDto) {
		// TODO Auto-generated method stub
		Services services = modelMapper.map(servicesDto, Services.class);
		Services saveservice = serviceRepository.save(services);
		return modelMapper.map(saveservice, ServicesDto.class);
	}

	@Override
	public ServicesDto getServiceById(long id) {
		// TODO Auto-generated method stub
		Services services = serviceRepository.findById(id).get();
		return modelMapper.map(services, ServicesDto.class);
	}

	@Override
	public List<ServicesDto> getAllServices() {
		List<Services> services = serviceRepository.findAll();
	    return services.stream()
	                   .map(service -> modelMapper.map(service, ServicesDto.class))
	                   .collect(Collectors.toList());
	}

	@Override
	public void deleteServices(Long id) {
		// TODO Auto-generated method stub
		Services existingServices = serviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Services not find by id: "+id));
		serviceRepository.delete(existingServices);
	}

	@Override
	public ServicesDto updateServices(long id, ServicesDto servicesDto) {
		// TODO Auto-generated method stub
		Services existingServices = serviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Services not find by id: "+id));
		
		existingServices.setName(servicesDto.getName());
		existingServices.setAbout(servicesDto.getAbout());
		existingServices.setType(servicesDto.getType());
		existingServices.setPrice(servicesDto.getPrice());
		
		
		Services updateServices = serviceRepository.save(existingServices);
		return modelMapper.map(updateServices, ServicesDto.class);
	}


}
