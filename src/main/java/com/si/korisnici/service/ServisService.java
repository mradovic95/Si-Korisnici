package com.si.korisnici.service;

import com.si.korisnici.domain.Servis;
import com.si.korisnici.mapper.ServisMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServisService {

    private ServisMapper servisMapper;

    public ServisService(ServisMapper servisMapper) {
        this.servisMapper = servisMapper;
    }

    public List<Servis> listaj() {
        log.info("Listaj sve servise");
        return servisMapper.listaj();
    }

//    public Servis listajZaSifru(String sifraServisa) {
//        log.info("Listaj za sifru", sifraServisa);
//        return servisMapper.listajZaSifru(sifraServisa);
//    }

    public void dodaj(Servis servis) {
        log.info("Dodaj servisa", servis);
        servisMapper.dodaj(servis);
    }

    public void brisiZaSifru(String sifraServisa) {
        log.info("Brisi za sifru", sifraServisa);
        servisMapper.brisiZaSifru(sifraServisa);
    }

    public void izmeni(Servis servis) {
        log.info("Izmeni servisa", servis);
        servisMapper.izmeni(servis);
    }


}
