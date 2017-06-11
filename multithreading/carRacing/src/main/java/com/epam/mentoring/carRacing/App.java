package com.epam.mentoring.carRacing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Future<?> fThread1 = executorService.submit(mcqueen);
		Future<?> fThread2 = executorService.submit(ferrari);
		Future<?> fThread3 = executorService.submit(lambordgini);
		Future<?> fThread4 = executorService.submit(zafira);

		ScheduledExecutorService disqualification = Executors.newSingleThreadScheduledExecutor();
		disqualification.schedule(() -> {
			fThread2.cancel(true);
			disqualification.shutdown();
			LOG.info("!!!!!!!!!!!!Ferrari!!!!!!!!!! ");
		}, 5, TimeUnit.SECONDS);

		while (true) {
			if (fThread1.isDone()) {
				LOG.info("Mcqueen is winner");
				break;
			} else if (fThread3.isDone()) {
				LOG.info("Lambordgini is winner");
				break;
			} else if (fThread4.isDone()) {
				LOG.info("Zafira is winner");
				break;
			}
			executorService.shutdown();

		}

	}

}
