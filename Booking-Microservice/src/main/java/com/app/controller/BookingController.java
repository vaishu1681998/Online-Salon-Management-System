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

import com.app.dto.BookingDto;
import com.app.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	// Create a new booking
	@PostMapping
	public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {
		BookingDto createdBooking = bookingService.createBooking(bookingDto);
		return ResponseEntity.ok(createdBooking);
	}

	// Get booking by ID
	@GetMapping("/{id}")
	public ResponseEntity<BookingDto> getBookingById(@PathVariable Long id) {
		BookingDto bookingDto = bookingService.getBookingById(id);
		return ResponseEntity.ok(bookingDto);
	}

	// Update an existing booking
	@PutMapping("/{id}")
	public ResponseEntity<BookingDto> updateBooking(@PathVariable Long id, @RequestBody BookingDto bookingDto) {
		BookingDto updatedBooking = bookingService.updateBooking(id, bookingDto);
		return ResponseEntity.ok(updatedBooking);
	}

	// Delete a booking by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
		bookingService.deleteBooking(id);
		return ResponseEntity.noContent().build();
	}

	// Get all bookings
	@GetMapping
	public ResponseEntity<List<BookingDto>> getAllBookings() {
		List<BookingDto> bookings = bookingService.getAllBookings();
		return ResponseEntity.ok(bookings);
	}
}
