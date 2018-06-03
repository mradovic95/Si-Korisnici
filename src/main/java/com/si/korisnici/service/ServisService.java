package com.si.korisnici.service;

import com.si.korisnici.domain.Servis;
import com.si.korisnici.mapper.PrivilegijaMapper;
import com.si.korisnici.mapper.ServisMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServisService {

    private ServisMapper servisMapper;
    private PrivilegijaMapper privilegijaMapper;

    public ServisService(ServisMapper servisMapper, PrivilegijaMapper privilegijaMapper) {
        this.servisMapper = servisMapper;
        this.privilegijaMapper = privilegijaMapper;
    }

    public List<Servis> listaj() {
        log.info("Listaj sve servise");
        return servisMapper.listaj();
    }

    public Servis listajZaSifru(String sifraServisa, String sifraMinistarstva) {
        log.info("Listaj za sifru i sifru ministarstva", sifraServisa, sifraMinistarstva);
        return servisMapper.listajZaSifruISifruMinistarstva(sifraServisa, sifraMinistarstva);
    }

    public void dodaj(Servis servis) {
        log.info("Dodaj servisa", servis);
        servisMapper.dodaj(servis);
    }

    public void brisiZaSifru(String sifraServisa, String sifraMinistarstva) {
        log.info("Brisi za sifru i sifru ministarstva", sifraServisa, sifraMinistarstva);
        privilegijaMapper.brisiZaSifruServisaISifruMinistarstva(sifraServisa, sifraMinistarstva);
        servisMapper.brisiZaSifruISifruMinistarstva(sifraServisa, sifraMinistarstva);
    }

    public void izmeni(Servis servis) {
        log.info("Izmeni servisa", servis);
        servisMapper.izmeni(servis);
    }

}
