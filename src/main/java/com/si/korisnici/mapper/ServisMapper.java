package com.si.korisnici.mapper;

import com.si.korisnici.domain.Servis;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServisMapper {

    public List<Servis> listaj();

    public Servis listajZaSifruISifruMinistarstva(String sifraMinistarstva, String sifraServisa);

    public void dodaj(Servis servis);

    public void brisiZaSifru(String sifraServisa);

    public void izmeni(Servis servis);

}
