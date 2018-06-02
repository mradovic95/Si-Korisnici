package com.si.korisnici.mapper;

import com.si.korisnici.domain.Korisnik;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KorisnikMapper {

    List<Korisnik> listaj();

    Korisnik listajZaSifru(String sifraKorisnika);

    Korisnik listajZaUsername(String usernameKorisnika);

    Korisnik listajZaUsernameIPassword(String usernameKorisnika, String passwordKorisnika);

    void dodaj(Korisnik korisnik);

    void brisiZaSifru(String sifraKorisnika);

    void izmeni(Korisnik korisnik);
}
