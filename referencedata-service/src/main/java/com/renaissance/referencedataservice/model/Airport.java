package com.renaissance.referencedataservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Airport {
    @Id
    private String id;
    private String code;
    private String lat;
    private String lon;
    private String name;
    private String city;
    private String state;
    private String country;
    private String woeid;
    private String tz;
    private String phone;
    private String type;
    private String email;
    private String url;
    private String runway_length;
    private String elev;
    private String icao;
    private String direct_flights;
    private String carriers;

    public Airport(String code, String lat, String lon,
                   String name, String city, String state,
                   String country, String woeid, String tz,
                   String phone, String type, String email,
                   String url, String runway_length, String elev,
                   String icao, String direct_flights, String carriers) {
        this.code = code;
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
        this.woeid = woeid;
        this.tz = tz;
        this.phone = phone;
        this.type = type;
        this.email = email;
        this.url = url;
        this.runway_length = runway_length;
        this.elev = elev;
        this.icao = icao;
        this.direct_flights = direct_flights;
        this.carriers = carriers;
    }
}
