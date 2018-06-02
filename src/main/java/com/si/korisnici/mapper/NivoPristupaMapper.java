package com.si.korisnici.mapper;

import com.si.korisnici.domain.NivoPristupa;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NivoPristupaMapper {

    List<NivoPristupa> listaj();

    NivoPristupa listajZaSifruISifruMinistarstva(String sifraNivoaPristupa, String sifraMinistarstva);

    void brisiZaSifruISifruMinistarstva(String sifraNivoaPristupa, String sifraMinistarstva);

    void dodaj(NivoPristupa nivoPristupa);

    void izmeni(NivoPristupa nivoPristupa);
}
