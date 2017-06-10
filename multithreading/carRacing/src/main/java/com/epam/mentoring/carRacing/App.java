package com.epam.mentoring.carRacing;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.epam.mentoring.carRacing.model.Car;

public class App {
	static Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) {
		Runnable mcqueen = new Car("mcqueen", 200);
		Runnable ferrari = new Car("Ferrari", 210);
		Runnable lambordgini = new Car("Lambordgini", 220);
		Runnable zafira = new Car("Zafira", 230);

		Thread thread1 = new Thread(mcqueen);
		Thread thread2 = new Thread(ferrari);
		Thread thread3 = new Thread(lambordgini);
		Thread thread4 = new Thread(zafira);
		ScheduledExecutorService disqualification = Executors.newSingleThreadScheduledExecutor();
		disqualification.schedule(() -> {
			thread2.interrupt();
			LOG.info("!!!!!!!!!!!!Ferrari!!!!!!!!!! ");
		}, 5, TimeUnit.SECONDS);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

		while (true) {
			if (thread1.getState() == Thread.State.TERMINATED) {
				LOG.info("Mcqueen is winner");
				break;
			} else if (thread3.getState() == Thread.State.TERMINATED) {
				LOG.info("Lambordgini is winner");
				break;
			} else if (thread4.getState() == Thread.State.TERMINATED) {
				LOG.info("Zafira is winner");
				break;
			}

		}

	}

}
