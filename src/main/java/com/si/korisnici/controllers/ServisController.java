package com.si.korisnici.controllers;

import com.si.korisnici.domain.Servis;
import com.si.korisnici.service.ServisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/servis")
@Api(description = "Servisi", produces = "application/json", consumes = "application/json")
public class ServisController {

    private ServisService servisService;

    public ServisController(ServisService servisService) {
        this.servisService = servisService;
    }

    @GetMapping
    @ApiOperation(value = "Dohvati listu svih servisa")
    public ResponseEntity<List<Servis>> listaj() {
        return new ResponseEntity<>(servisService.listaj(), HttpStatus.OK);
    }

//    @GetMapping(value = "/{sifraServisa}")
//    @ApiOperation(value = "Dohvati koriskika za sifru")
//    public ResponseEntity<Servis> listajZaSifru(@PathVariable String sifraServisa) {
//        return new ResponseEntity<>(servisService.listajZaSifru(sifraServisa), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<?> dodaj(@Valid @RequestBody Servis servis) {

        servisService.dodaj(servis);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{sifraServisa}")
    public ResponseEntity<?> brisi(@PathVariable String sifraServisa) {
        servisService.brisiZaSifru(sifraServisa);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> izmeni(@Valid @RequestBody Servis servis) {
        servisService.izmeni(servis);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
