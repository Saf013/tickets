package org.hillel;

import org.hillel.service.TicketClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class Starter {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("common-beans.xml");
        TicketClient ticketClient = applicationContext.getBean(TicketClient.class);
        System.out.println(ticketClient.find("Kiev", "Odessa"));
        System.out.println(ticketClient.find("Kiev", "Odessa", LocalDate.of(2021,03,12), LocalDate.of(2021,03,13)));
    }
}
