package com.si.korisnici.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Korisnik {

    private String sifraKorisnika;
    private String emailKorisnika;
    private String usernameKorisnika;
    private String passwordKorisnika;
    private List<Privilegija> privilegije = new ArrayList();

}
