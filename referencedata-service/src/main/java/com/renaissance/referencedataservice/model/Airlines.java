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
public class Airlines {
    @Id
    private String id;
    private int field1;
    private double fleet_average_age;
    private String callsign;
    private String hub_code;
    private String iata_code;
    private String icao_code;
    private String country_iso2;
    private int date_founded;
    private int iata_prefix_accounting;
    private String airline_name;
    private String country_name;
    private int fleet_size;
    private String status;
    private String type;

    public Airlines(int field1, double fleet_average_age, String callsign, String hub_code,
                    String iata_code, String icao_code, String country_iso2, int date_founded,
                    int iata_prefix_accounting, String airline_name, String country_name,
                    int fleet_size, String status, String type) {
        this.field1 = field1;
        this.fleet_average_age = fleet_average_age;
        this.callsign = callsign;
        this.hub_code = hub_code;
        this.iata_code = iata_code;
        this.icao_code = icao_code;
        this.country_iso2 = country_iso2;
        this.date_founded = date_founded;
        this.iata_prefix_accounting = iata_prefix_accounting;
        this.airline_name = airline_name;
        this.country_name = country_name;
        this.fleet_size = fleet_size;
        this.status = status;
        this.type = type;
    }
}
