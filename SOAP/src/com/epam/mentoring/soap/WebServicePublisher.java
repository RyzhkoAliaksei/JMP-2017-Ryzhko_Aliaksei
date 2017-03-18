package com.epam.mentoring.soap;

import javax.xml.ws.Endpoint;

public class WebServicePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/service/ticket", new TicketServiceImpl());
    }

}