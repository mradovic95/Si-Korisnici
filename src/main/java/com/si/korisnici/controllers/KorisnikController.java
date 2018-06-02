package com.si.korisnici.controllers;

import com.si.korisnici.domain.Korisnik;
import com.si.korisnici.service.KorisnikService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/korisnici")
@Api(description = "Korisnici", produces = "application/json", consumes = "application/json")
public class KorisnikController {

    private KorisnikService korisnikService;

    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @GetMapping
    @ApiOperation(value = "Dohvati listu svih korisnika")
    public ResponseEntity<List<Korisnik>> listaj() {
        return new ResponseEntity<>(korisnikService.listaj(), HttpStatus.OK);
    }

    @GetMapping(value = "/{sifraKorisnika}")
    @ApiOperation(value = "Dohvati koriskika za sifru")
    public ResponseEntity<Korisnik> listajZaSifru(@PathVariable String sifraKorisnika) {
        return new ResponseEntity<>(korisnikService.listajZaSifru(sifraKorisnika), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Korisnik> dodaj(@Valid @RequestBody Korisnik korisnik) {

        Korisnik korisnik1 = korisnikService.dodaj(korisnik);
        if (korisnik1 == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(korisnik1, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{sifraKorisnika}")
    public ResponseEntity<?> brisi(@PathVariable String sifraKorisnika) {
        korisnikService.brisiZaSifru(sifraKorisnika);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> izmeni(@Valid @RequestBody Korisnik korisnik) {
        korisnikService.izmeni(korisnik);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@Valid @RequestBody Korisnik korisnik) {
        return new ResponseEntity<>(korisnikService.login(korisnik), HttpStatus.OK);
    }


}
