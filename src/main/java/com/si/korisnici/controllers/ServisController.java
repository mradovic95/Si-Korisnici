package com.si.korisnici.controllers;

import com.si.korisnici.domain.Servis;
import com.si.korisnici.security.CheckSecurity;
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
    @CheckSecurity(role = "2")
    public ResponseEntity<List<Servis>> listaj(@RequestHeader String Authorization) {
        return new ResponseEntity<>(servisService.listaj(), HttpStatus.OK);
    }

    // @TODO: Razmsliti o boljem nazivu
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Dohvati servis za sifru i sifru ministarstva")
    @CheckSecurity(role = "2")
    public ResponseEntity<Servis> listajZaSifru(@PathVariable String id,@RequestHeader String Authorization) {
        String[] idParametri = id.split(",");
        return new ResponseEntity<>(servisService.listajZaSifru(idParametri[0], idParametri[1]), HttpStatus.OK);
    }

    @PostMapping
    @CheckSecurity(role = "2")
    public ResponseEntity<?> dodaj(@Valid @RequestBody Servis servis,@RequestHeader String Authorization) {

        servisService.dodaj(servis);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    @CheckSecurity(role = "2")
    public ResponseEntity<?> brisi(@PathVariable String id,@RequestHeader String Authorization) {
        String[] idParametri = id.split(",");
        servisService.brisiZaSifru(idParametri[0], idParametri[1]);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    @CheckSecurity(role = "2")
    public ResponseEntity<?> izmeni(@Valid @RequestBody Servis servis,@RequestHeader String Authorization) {
        servisService.izmeni(servis);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
