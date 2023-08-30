package com.renaissance.referencedataservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Flights {
    @Id
    private String id;
    private int field1;
    private String flight_date;
    private String flight_status;
    private String departure_airport;
    private String departure_timezone;
    private String departure_iata;
    private String departure_icao;
    private String departure_terminal;
    private String departure_gate;
    private String departure_delay;
    private String departure_scheduled;
    private String departure_estimated;
    private String departure_actual;
    private String departure_estimated_runway;
    private String departure_actual_runway;
    private String arrival_airport;
    private String arrival_timezone;
    private String arrival_iata;
    private String arrival_icao;
    private String arrival_terminal;
    private String arrival_gate;
    private String arrival_baggage;
    private String arrival_delay;
    private String arrival_scheduled;
    private String arrival_estimated;
    private String arrival_actual;
    private String arrival_estimated_runway;
    private String arrival_actual_runway;
    private String airline_name;
    private String airline_iata;
    private String airline_icao;
    private String flight_number;
    private String flight_iata;
    private String flight_icao;

    public Flights(int field1, String flight_date, String flight_status, String departure_airport,
                   String departure_timezone, String departure_iata, String departure_icao,
                   String departure_terminal, String departure_gate, String departure_delay,
                   String departure_scheduled, String departure_estimated, String departure_actual,
                   String departure_estimated_runway, String departure_actual_runway, String arrival_airport,
                   String arrival_timezone, String arrival_iata, String arrival_icao, String arrival_terminal,
                   String arrival_gate, String arrival_baggage, String arrival_delay, String arrival_scheduled,
                   String arrival_estimated, String arrival_actual, String arrival_estimated_runway,
                   String arrival_actual_runway, String airline_name, String airline_iata, String airline_icao,
                   String flight_number, String flight_iata, String flight_icao) {
        this.field1 = field1;
        this.flight_date = flight_date;
        this.flight_status = flight_status;
        this.departure_airport = departure_airport;
        this.departure_timezone = departure_timezone;
        this.departure_iata = departure_iata;
        this.departure_icao = departure_icao;
        this.departure_terminal = departure_terminal;
        this.departure_gate = departure_gate;
        this.departure_delay = departure_delay;
        this.departure_scheduled = departure_scheduled;
        this.departure_estimated = departure_estimated;
        this.departure_actual = departure_actual;
        this.departure_estimated_runway = departure_estimated_runway;
        this.departure_actual_runway = departure_actual_runway;
        this.arrival_airport = arrival_airport;
        this.arrival_timezone = arrival_timezone;
        this.arrival_iata = arrival_iata;
        this.arrival_icao = arrival_icao;
        this.arrival_terminal = arrival_terminal;
        this.arrival_gate = arrival_gate;
        this.arrival_baggage = arrival_baggage;
        this.arrival_delay = arrival_delay;
        this.arrival_scheduled = arrival_scheduled;
        this.arrival_estimated = arrival_estimated;
        this.arrival_actual = arrival_actual;
        this.arrival_estimated_runway = arrival_estimated_runway;
        this.arrival_actual_runway = arrival_actual_runway;
        this.airline_name = airline_name;
        this.airline_iata = airline_iata;
        this.airline_icao = airline_icao;
        this.flight_number = flight_number;
        this.flight_iata = flight_iata;
        this.flight_icao = flight_icao;
    }
}
