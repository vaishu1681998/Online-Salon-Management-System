package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import com.app.entity.BookingStatus;
import com.app.exception.BookingException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.BookingDto;
import com.app.entity.Booking;
import com.app.repository.BookingRepo;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepo bookingRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BookingDto createBooking(BookingDto bookingDto) {
		Booking booking = modelMapper.map(bookingDto, Booking.class);
		booking.setStatus(BookingStatus.PENDING);
		// check if staff is available at that time
		List<Booking> staffBooking = bookingRepository.findByStaffId(booking.getStaffId());
		if (staffBooking != null) {
			for (Booking booking1 : staffBooking) {
				if (booking1.getTime().equalsIgnoreCase(booking.getTime())) {
					throw new BookingException("Staff not available");
				}
			}
		}
		Booking savedBooking = bookingRepository.save(booking);
		return modelMapper.map(savedBooking, BookingDto.class);
	}

	@Override
	public BookingDto getBookingById(Long id) {
		Booking booking = bookingRepository.findById(id)
				.orElseThrow(() -> new BookingException("Booking not found with id: " + id));
		return modelMapper.map(booking, BookingDto.class);
	}

	
	@Override
	public BookingDto updateBooking(Long id, BookingDto bookingDto) {
		Booking existingBooking = bookingRepository.findById(id)
				.orElseThrow(() -> new BookingException("Booking not found with id: " + id));

		// Update fields
		Booking booking = modelMapper.map(bookingDto, Booking.class);
		booking.setPrice(existingBooking.getPrice());
		booking.setStatus(bookingDto.getStatus());
		// Ensure this is part of Booking entity

		Booking updatedBooking = bookingRepository.save(booking);
		return modelMapper.map(updatedBooking, BookingDto.class);
	}

	@Override
	public String deleteBooking(Long id) {
		Booking booking = bookingRepository.findById(id)
				.orElseThrow(() -> new BookingException("Booking not found with id: " + id));
		bookingRepository.delete(booking);
		return "Deleted Successfully";
	}

	@Override
	public List<BookingDto> getAllBookings() {
		List<Booking> bookings = bookingRepository.findAll();
		return bookings.stream().map(booking -> modelMapper.map(booking, BookingDto.class))
				.collect(Collectors.toList());
	}
}
