package com.si.korisnici.controllers;

import com.si.korisnici.domain.NivoPristupa;
import com.si.korisnici.security.CheckSecurity;
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
    @CheckSecurity(role = "2")
    public ResponseEntity<List<NivoPristupa>> listaj(@RequestHeader String Authorization) {
        return new ResponseEntity<>(nivoPristupaServis.listaj(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Dohvati nivo pristupa za sifru i sifru ministarstva")
    @CheckSecurity(role = "2")
    public ResponseEntity<NivoPristupa> listajZaSifru(@PathVariable String id,@RequestHeader String Authorization) {
        String[] idParametri = id.split(",");
        return new ResponseEntity<>(nivoPristupaServis.listajZaSifru(idParametri[0], idParametri[1]), HttpStatus.OK);
    }

    @PostMapping
    @CheckSecurity(role = "2")
    public ResponseEntity<?> dodaj(@Valid @RequestBody NivoPristupa nivoPristupa,@RequestHeader String Authorization) {

        nivoPristupaServis.dodaj(nivoPristupa);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    @CheckSecurity(role = "2")
    public ResponseEntity<?> brisi(@PathVariable String id,@RequestHeader String Authorization) {
        String[] idParametri = id.split(",");
        nivoPristupaServis.brisiZaSifru(idParametri[0], idParametri[1]);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    @CheckSecurity(role = "2")
    public ResponseEntity<?> izmeni(@Valid @RequestBody NivoPristupa nivoPristupa,@RequestHeader String Authorization) {
        nivoPristupaServis.izmeni(nivoPristupa);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
