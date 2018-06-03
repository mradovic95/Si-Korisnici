package com.si.korisnici.mapper;

import com.si.korisnici.domain.Privilegija;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrivilegijaMapper {

    void dodaj(Privilegija privilegija);

    void brisiZaSifruKorisnika(String sifraKorisnika);

    void brisiZaSifruServisaISifruMinistarstva(String sifraServisa, String sifraMinistarstva);

    void brisiZaSifruNivoaPristupaISifruMinistarstva(String sifraNivoaPristupa, String sifraMinistarstva);

}
