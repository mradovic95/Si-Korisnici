package com.si.korisnici.mapper;

import com.si.korisnici.domain.Korisnik;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KorisnikMapper {

    public List<Korisnik> listaj();

    public Korisnik listajZaSifru(String sifraKorisnika);

    public void dodaj(Korisnik korisnik);

    public void brisiZaSifru(String sifraKorisnika);

    public void izmeni(Korisnik korisnik);
}
