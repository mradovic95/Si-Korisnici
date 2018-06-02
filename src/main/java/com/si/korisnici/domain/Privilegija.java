package com.si.korisnici.domain;

import lombok.Data;

@Data
public class Privilegija {

    private String sifraKorisnika;
    private String sifraServisa;
    private String sifraMinistarstva;
    private String sifraNivoaPristupa;

}
