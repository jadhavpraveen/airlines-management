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
public class Translations {
    @Id
    private String id;
    private String kr;
    private String br;
    private String pt;
    private String nl;
    private String hr;
    private String fa;
    private String de;
    private String es;
    private String fr;
    private String ja;
    private String it;
    private String cn;

    public Translations(String kr, String br, String pt, String nl,
                        String hr, String fa, String de, String es,
                        String fr, String ja, String it, String cn) {
        this.kr = kr;
        this.br = br;
        this.pt = pt;
        this.nl = nl;
        this.hr = hr;
        this.fa = fa;
        this.de = de;
        this.es = es;
        this.fr = fr;
        this.ja = ja;
        this.it = it;
        this.cn = cn;
    }
}
