package com.renaissance.referencedataservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class States {

    @Id
    private int id;
    private String name;
    private String state_code;
    private String latitude;
    private String longitude;
    private List<City> cities;

    public States(String name, String state_code, String latitude, String longitude, List<City> cities) {
        this.name = name;
        this.state_code = state_code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cities = cities;
    }
}
