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
public class Timezones {
    @Id
    private String id;
    private String zoneName;
    private String gmtOffset;
    private String gmtOffsetName;
    private String abbrevation;
    private String tzName;

    public Timezones(String zoneName, String gmtOffset, String gmtOffsetName, String abbrevation, String tzName) {
        this.zoneName = zoneName;
        this.gmtOffset = gmtOffset;
        this.gmtOffsetName = gmtOffsetName;
        this.abbrevation = abbrevation;
        this.tzName = tzName;
    }
}
