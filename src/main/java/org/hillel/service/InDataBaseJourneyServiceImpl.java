package org.hillel.service;

import lombok.SneakyThrows;
import org.hillel.Journey;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class InDataBaseJourneyServiceImpl implements JourneyService{
    private Connection connect;

    {
        try {
            connect = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/tickets",
                    "postgres","root");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @SneakyThrows
    @Override
    public Collection<Journey> find(String stationFrom, String stationTo) {
        List<Journey> journeys = new ArrayList<>();
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM journey WHERE stationfrom = '" + stationFrom +
                "' AND stationto = '" + stationTo + "';");
        while (resultSet.next()) {
            journeys.add(new Journey(resultSet.getString("stationfrom"), resultSet.getString("stationto"),
                    resultSet.getDate("departure").toLocalDate(), resultSet.getDate("arrival").toLocalDate(),
                    resultSet.getString("route")));
        }
        statement.close();
        resultSet.close();
        return Collections.unmodifiableList(journeys);
    }

    @SneakyThrows
    @Override
    public Collection<Journey> find(String stationFrom, String stationTo, LocalDate departure, LocalDate arrival) {
        List<Journey> journeys = new ArrayList<>();
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM journey WHERE stationfrom = '" + stationFrom +
                "' AND stationto = '" + stationTo + "' AND departure = '" + departure + "' AND arrival = '" + arrival +"';");
        while (resultSet.next()) {
            journeys.add(new Journey(resultSet.getString("stationfrom"), resultSet.getString("stationto"),
                    resultSet.getDate("departure").toLocalDate(), resultSet.getDate("arrival").toLocalDate(),
                    resultSet.getString("route")));
        }
        statement.close();
        resultSet.close();
        return Collections.unmodifiableList(journeys);
    }
}
