package com.epam.cinema.service.impl;

import static org.mockito.Mockito.when;

import java.util.Set;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.epam.cinema.DAO.BookingDAO;
import com.epam.cinema.model.Booking;
import com.epam.cinema.model.Person;

import org.mockito.Mock;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(DefaultBookingService.class)
public class DefaultBookingServiceTest {

	@InjectMocks
	private DefaultBookingService bookingService = new DefaultBookingService();
	@Mock
	private BookingDAO mockBookingDao;
	@Mock
	private Person mockPerson;
	@Mock
	private Booking mockBooking;

	@Mock
	private Set<Booking> mockBookings;
	private Long id = 1L;

	@Before
	public void init() {
		mockBookings.add(mockBooking);
	}

	@Test
	public void shouldSetBookingWhenBookingIsAvailable() {
		when(mockBookingDao.setBooking(id, mockPerson)).thenReturn(Boolean.TRUE);
		assertTrue(bookingService.setBooking(id, mockPerson));
	}

	@Test
	public void shouldNotSetBookingWhenBookingIsUnavailable() {
		when(mockBookingDao.setBooking(id, mockPerson)).thenReturn(Boolean.FALSE);
		assertFalse(bookingService.setBooking(id, mockPerson));
	}

	@Test
	public void shouldReturnBookingByIdWhenBookingIsAvailable() {
		when(mockBookingDao.getBookingById(id)).thenReturn(mockBooking);
		assertEquals(bookingService.getBookingById(id), mockBooking);
	}

	@Test
	public void shouldReturnTicketWhenBookingIsAvailable() {
		when(mockBookingDao.returnBooking(id)).thenReturn(Boolean.TRUE);
		assertTrue(bookingService.returnBooking(id));
	}

	@Test
	public void shouldNotReturnTicketWhenBookingIsUnavailable() {
		when(mockBookingDao.returnBooking(id)).thenReturn(Boolean.FALSE);
		assertFalse(bookingService.returnBooking(id));
	}

	@Test
	public void shouldReturnAllBookingsWhenBookingIsAvailable() {
		when(mockBookingDao.findBookings()).thenReturn(mockBookings);
		assertNotNull(bookingService.findBookings());
	}

	@Test
	public void shouldReturnAllBookedTicketsWhenBookedTicketsIsAvailable() {
		when(mockBookingDao.findBookedTickets()).thenReturn(mockBookings);
		assertNotNull(bookingService.findBookedTickets());
	}
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnExceptionWhenVariableEqualsZero() {
		bookingService.calculateMethodForUnitTest(5, 0);
	}
	 @Test(timeout = 6000)
	public void shouldFailedWhenTimeoutExpired() throws InterruptedException {
		bookingService.simulateProcessingTimeoutForUnitTest();
	}

}