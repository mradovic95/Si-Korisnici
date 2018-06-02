package com.si.korisnici.mapper;

import com.si.korisnici.domain.Servis;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServisMapper {

    List<Servis> listaj();

    Servis listajZaSifruISifruMinistarstva(String sifraServisa, String sifraMinistarstva);

    void dodaj(Servis servis);

    void brisiZaSifruISifruMinistarstva(String sifraServisa, String sifraMinistarstva);

    void izmeni(Servis servis);

}
