package org.hillel.service;

import lombok.SneakyThrows;
import org.hillel.Journey;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

@Component("inDataBaseJourneyService")
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
        return findInDB("SELECT * FROM journey WHERE station_from = '" + stationFrom +
                "' AND station_to = '" + stationTo + "';");
    }

    @SneakyThrows
    @Override
    public Collection<Journey> find(String stationFrom, String stationTo, LocalDate departure, LocalDate arrival) {
        return findInDB("SELECT * FROM journey WHERE station_from = '" + stationFrom +
                "' AND station_to = '" + stationTo + "' AND departure = '" + departure + "' AND arrival = '" + arrival +"';");
    }

    @SneakyThrows
    public Collection<Journey> findInDB(String str) {
        List<Journey> journeys = new ArrayList<>();
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(str);
        while (resultSet.next()) {
            journeys.add(new Journey(resultSet.getString("station_from"), resultSet.getString("station_to"),
                    resultSet.getDate("departure").toLocalDate(), resultSet.getDate("arrival").toLocalDate(),
                    resultSet.getString("route")));
        }
        statement.close();
        resultSet.close();
        return Collections.unmodifiableList(journeys);
    }
}
