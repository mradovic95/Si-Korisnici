package com.si.korisnici.service;

import com.si.korisnici.domain.NivoPristupa;
import com.si.korisnici.mapper.NivoPristupaMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NivoPristupaServis {

    private NivoPristupaMapper nivoPristupaMapper;

    public NivoPristupaServis(NivoPristupaMapper nivoPristupaMapper) {
        this.nivoPristupaMapper = nivoPristupaMapper;
    }

    public List<NivoPristupa> listaj() {
        log.info("Listaj sve nivoe pristupa");
        return nivoPristupaMapper.listaj();
    }

    public NivoPristupa listajZaSifru(String sifraNivoaPristupa, String sifraMinistarstva) {
        log.info("Listaj za sifru i sifru ministarstva", sifraNivoaPristupa, sifraMinistarstva);
        return nivoPristupaMapper.listajZaSifruISifruMinistarstva(sifraNivoaPristupa, sifraMinistarstva);
    }

    public void brisiZaSifru(String sifraNivoaPristupa, String sifraMinistarstva) {
        log.info("Brisi za sifru i sifru ministarstva", sifraNivoaPristupa, sifraMinistarstva);
        nivoPristupaMapper.brisiZaSifruISifruMinistarstva(sifraNivoaPristupa, sifraMinistarstva);

    }

    public void dodaj(NivoPristupa nivoPristupa) {
        log.info("Dodaj servisa", nivoPristupa);
        nivoPristupaMapper.dodaj(nivoPristupa);
    }

    public void izmeni(NivoPristupa nivoPristupa) {
        log.info("Izmeni servisa", nivoPristupa);
        nivoPristupaMapper.izmeni(nivoPristupa);
    }
}
