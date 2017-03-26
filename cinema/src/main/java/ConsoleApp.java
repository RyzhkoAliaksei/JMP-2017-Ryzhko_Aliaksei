import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import cinema.model.Booking;
import cinema.model.Person;
import cinema.service.BookingService;

public class ConsoleApp {

	public static void main(String[] args) throws Exception {

		final String confFile = "Beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);
		ConfigurableEnvironment env = context.getEnvironment();
		env.setActiveProfiles("logan");
		context.refresh();

		BookingService bookingService = (BookingService) context.getBean("bookingService");
		MenuResolver menu = (MenuResolver) context.getBean("menuResolver");
		// scope singleton
		Person person = (Person) context.getBean("person");
		System.out.println("Director-");
		System.out.println(person);
		// scope prototype
		Booking logan = (Booking) context.getBean("film");
		Booking logan1 = (Booking) context.getBean("film");
		Booking logan2 = (Booking) context.getBean("film");
		Booking logan3 = (Booking) context.getBean("film");

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = dateFormat.parse("2017/03/25 09:00");
		Date date1 = dateFormat.parse("2017/03/25 11:00");

		logan.setSeat(1);
		logan.setDate(date);
		logan1.setSeat(2);
		logan1.setDate(date);
		logan2.setSeat(3);
		logan2.setDate(date);
		logan3.setSeat(1);
		logan3.setDate(date1);
		bookingService.createBooking(logan);
		bookingService.createBooking(logan1);
		bookingService.createBooking(logan2);
		bookingService.createBooking(logan3);

		menu.start(context);

	}

}
