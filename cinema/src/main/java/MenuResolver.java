import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;

import cinema.model.Person;
import cinema.service.BookingService;

public class MenuResolver {
	Menu menu = new Menu();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

	public void start(ConfigurableApplicationContext context) throws Exception {
		BookingService bookingService = (BookingService) context.getBean("bookingService");
		Scanner scanner = new Scanner(System.in);
		boolean isChoose = true;
		while (isChoose) {
			menu.getMenu();
			switch (scanner.nextInt()) {
			case 0: {
				System.out.println("End programm");
				scanner.close();
				isChoose = false;
				System.exit(0);
				break;
			}
			case 1: {
				bookBooking(bookingService);
				break;
			}
			case 2: {
				returnBooking(scanner, bookingService);
				break;
			}
			case 3: {
				reviewBooking(scanner, bookingService);
				break;
			}
			default: {
				System.out.println("Try again");
			}
			}
		}
	}

	private void returnBooking(Scanner scanner, BookingService bookingService) {
		System.out.println("enter returning ticket id:");
		Long ticketId = scanner.nextLong();
		bookingService.returnBooking(ticketId);
	}

	private void reviewBooking(Scanner scanner, BookingService bookingService) {
		System.out.println("enter ticket id:");
		Long reviewTicketId = scanner.nextLong();
		System.out.println(bookingService.getBookingById(reviewTicketId));
	}

	private void bookBooking(BookingService bookingService) {
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("For booking");
		System.out.println("Your Name");
		String name = scanner1.nextLine();
		System.out.println("Your Last Name");
		String lastName = scanner1.nextLine();
		Person person = new Person();
		person.setFirstName(name);
		person.setLastName(lastName);
		System.out.println("Your Date for example 2017/03/25 09:00");
		Date customDate;
		try {
			customDate = dateFormat.parse(scanner1.nextLine());
			System.out.println(bookingService.findBookingsByDate(customDate));
			System.out.println("Enter ticket id");
			Long bookingTicketId = scanner1.nextLong();
			bookingService.setBooking(bookingTicketId, person, customDate);
			System.out.println(bookingService.getBookingById(bookingTicketId));
		} catch (ParseException e) {
			System.out.println("Try again");
		}
	}
}
