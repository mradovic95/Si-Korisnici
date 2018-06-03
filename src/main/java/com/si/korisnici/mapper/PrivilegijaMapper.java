package com.si.korisnici.mapper;

import com.si.korisnici.domain.Privilegija;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrivilegijaMapper {

    void dodaj(Privilegija privilegija);

    void brisiZaSifruKorisnika(String sifraKorisnika);

}
