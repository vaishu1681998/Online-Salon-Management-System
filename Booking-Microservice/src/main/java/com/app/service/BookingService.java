package com.app.service;

import java.util.List;

import com.app.dto.BookingDto;

public interface BookingService {
	BookingDto createBooking(BookingDto bookingDto);

	BookingDto getBookingById(Long id);

	BookingDto updateBooking(Long id, BookingDto bookingDto);

	/**
	 * !It take the user id and delete it from the db
	 * @param id
	 * @return
	 */
	String deleteBooking(Long id);

	List<BookingDto> getAllBookings();
}
