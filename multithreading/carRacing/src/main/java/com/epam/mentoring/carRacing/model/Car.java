package com.epam.mentoring.carRacing.model;

import org.apache.log4j.Logger;

public class Car implements Runnable {
    
    private static final long MAX_DISTANCE = 10000;

    Logger log = Logger.getLogger(getClass());
    
    private long friction; 
    private long distance; 
    
    private String name;
    
    public Car(String name, long friction) {
        this.name = name;
        this.friction = 100;
    }

    public void run() {
        try {
            while ((distance < MAX_DISTANCE)&&(!Thread.interrupted())) {
                Thread.sleep(friction);
                distance += 100;
                log.info(name + " " + distance);
            }
        } catch (InterruptedException e) {
        	log.info("!!!!!!!!!! is disqulified!!!!!!!!!!!!!");
		}
	}

}