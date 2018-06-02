package com.si.korisnici.controllers;

import com.si.korisnici.domain.NivoPristupa;
import com.si.korisnici.service.NivoPristupaServis;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/nivopristupa")
@Api(description = "Nivoi pristupa", produces = "application/json", consumes = "application/json")
public class NivoPristupaController {

    private NivoPristupaServis nivoPristupaServis;

    public NivoPristupaController(NivoPristupaServis nivoPristupaServis) {
        this.nivoPristupaServis = nivoPristupaServis;
    }

    @GetMapping
    @ApiOperation(value = "Dohvati listu svih nivoa pristupa")
    public ResponseEntity<List<NivoPristupa>> listaj() {
        return new ResponseEntity<>(nivoPristupaServis.listaj(), HttpStatus.OK);
    }

    // @TODO: Razmsliti o boljem nazivu
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Dohvati nivo pristupa za sifru i sifru ministarstva")
    public ResponseEntity<NivoPristupa> listajZaSifru(@PathVariable String id) {
        String[] idParametri = id.split(",");
        return new ResponseEntity<>(nivoPristupaServis.listajZaSifru(idParametri[0], idParametri[1]), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> dodaj(@Valid @RequestBody NivoPristupa nivoPristupa) {

        nivoPristupaServis.dodaj(nivoPristupa);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> brisi(@PathVariable String id) {
        String[] idParametri = id.split(",");
        nivoPristupaServis.brisiZaSifru(idParametri[0], idParametri[1]);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> izmeni(@Valid @RequestBody NivoPristupa nivoPristupa) {
        nivoPristupaServis.izmeni(nivoPristupa);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
