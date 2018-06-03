package com.si.korisnici.service;

import com.si.korisnici.domain.Korisnik;
import com.si.korisnici.mapper.KorisnikMapper;
import com.si.korisnici.mapper.PrivilegijaMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class KorisnikService {

    private KorisnikMapper korisnikMapper;
    private TokenService tokenService;
    private PrivilegijaMapper privilegijaMapper;

    public KorisnikService(KorisnikMapper korisnikMapper, TokenService tokenService, PrivilegijaMapper privilegijaMapper) {
        this.korisnikMapper = korisnikMapper;
        this.tokenService = tokenService;
        this.privilegijaMapper = privilegijaMapper;
    }

    public List<Korisnik> listaj() {
        log.info("Listaj sve korisnike");
        return korisnikMapper.listaj();
    }

    public Korisnik listajZaSifru(String sifraKorisnika) {
        log.info("Listaj za sifru", sifraKorisnika);
        return korisnikMapper.listajZaSifru(sifraKorisnika);
    }

    public Korisnik dodaj(Korisnik korisnik) {
        log.info("Dodaj korisnika", korisnik);
        Korisnik korisnik1 = korisnikMapper.listajZaUsername(korisnik.getUsernameKorisnika());
        if (korisnik1 == null) {
            log.info("Uspesno dodavanje");
            korisnikMapper.dodaj(korisnik);
            // Sacuvaj sve privilegije
            korisnik.getPrivilegije().stream().forEach(p -> {
                p.setSifraKorisnika(korisnik.getSifraKorisnika());
                privilegijaMapper.dodaj(p);
            });
            return korisnik;
        }
        log.info("Neuspesno dodavanje");
        return null;
    }

    public void brisiZaSifru(String sifraKorisnika) {
        log.info("Brisi za sifru", sifraKorisnika);
        privilegijaMapper.brisiZaSifruKorisnika(sifraKorisnika);
        korisnikMapper.brisiZaSifru(sifraKorisnika);
    }

    public void izmeni(Korisnik korisnik) {
        log.info("Izmeni korisnika", korisnik);
        korisnikMapper.izmeni(korisnik);
    }

    public String login(Korisnik korisnik) {
        log.info("Loginuje se korisnik: ", korisnik);
        Korisnik korisnik1 = korisnikMapper.listajZaUsernameIPassword(korisnik.getUsernameKorisnika(), korisnik.getPasswordKorisnika());
        if (korisnik1 != null) {
            return tokenService.generate(korisnik1);
        }
        return "Los username ili password";

    }

}
