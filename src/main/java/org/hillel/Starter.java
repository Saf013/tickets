package org.hillel;

import org.hillel.service.JourneyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class Starter {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("common-beans.xml");
        JourneyService journeyService = applicationContext.getBean("dataBase", JourneyService.class);
        System.out.println(journeyService.find("Kiev", "Odessa"));
        System.out.println(journeyService.find("Kiev", "Odessa", LocalDate.of(2021,03,12), LocalDate.of(2021,03,13)));
    }
}
