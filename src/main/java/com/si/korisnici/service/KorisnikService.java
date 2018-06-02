package com.si.korisnici.service;

import com.si.korisnici.domain.Korisnik;
import com.si.korisnici.mapper.KorisnikMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class KorisnikService {

    private KorisnikMapper korisnikMapper;

    public KorisnikService(KorisnikMapper korisnikMapper) {
        this.korisnikMapper = korisnikMapper;
    }

    public List<Korisnik> listaj() {
        log.info("Listaj sve korisnike");
        return korisnikMapper.listaj();
    }

    public Korisnik listajZaSifru(String sifraKorisnika) {
        log.info("Listaj za sifru", sifraKorisnika);
        return korisnikMapper.listajZaSifru(sifraKorisnika);
    }

    public void dodaj(Korisnik korisnik) {
        log.info("Dodaj korisnika", korisnik);
        korisnikMapper.dodaj(korisnik);
    }

    public void brisiZaSifru(String sifraKorisnika) {
        log.info("Brisi za sifru", sifraKorisnika);
        korisnikMapper.brisiZaSifru(sifraKorisnika);
    }

    public void izmeni(Korisnik korisnik) {
        log.info("Izmeni korisnika", korisnik);
        korisnikMapper.izmeni(korisnik);
    }

}
