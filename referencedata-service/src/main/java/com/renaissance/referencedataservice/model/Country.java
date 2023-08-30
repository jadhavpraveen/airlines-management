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
public class Country {
    @Id
    private int id ;
    private String name;
    private String iso3;
    private String iso2;
    private String phone_code;
    private String capital;
    private String currency;
    private String currency_symbol;
    private String tld;
    private String country_native;
    private String region;
    private String subregion;
    private List<Timezones> timezones;
    private Translations translations;
    private String latitude;
    private String longitude;
    private String emoji;
    private String emojiU;
    private List<States> states;

    public Country(String name, String iso3, String iso2,
                   String phone_code, String capital, String currency,
                   String currency_symbol, String tld, String country_native,
                   String region, String subregion, List<Timezones> timezones,
                   Translations translations, String latitude, String longitude,
                   String emoji, String emojiU, List<States> states) {
        this.name = name;
        this.iso3 = iso3;
        this.iso2 = iso2;
        this.phone_code = phone_code;
        this.capital = capital;
        this.currency = currency;
        this.currency_symbol = currency_symbol;
        this.tld = tld;
        this.country_native = country_native;
        this.region = region;
        this.subregion = subregion;
        this.timezones = timezones;
        this.translations = translations;
        this.latitude = latitude;
        this.longitude = longitude;
        this.emoji = emoji;
        this.emojiU = emojiU;
        this.states = states;
    }

//    @Override
//    public String toString() {
//        return "Country{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", iso3='" + iso3 + '\'' +
//                ", capital='" + capital + '\'' +
//                ", currency='" + currency + '\'' +
//                ", region='" + region + '\'' +
//                '}';
//    }
}
