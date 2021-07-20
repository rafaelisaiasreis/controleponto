package com.rafael.controleponto.controller;

import com.rafael.controleponto.model.entities.JornadaTrabalho;
import com.rafael.controleponto.model.services.JornadaTrabalhoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "API REST Controle Ponto")
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    private JornadaTrabalhoService jornadaTrabalhoService;

    @ApiOperation(value = "Cadastra nova jornada")
    @PostMapping
    public ResponseEntity<JornadaTrabalho> createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        JornadaTrabalho saveJornada = jornadaTrabalhoService.save(jornadaTrabalho);
        return new ResponseEntity<JornadaTrabalho>(saveJornada, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retorna lista de jornadas cadastradas")
    @GetMapping
    public ResponseEntity<List<JornadaTrabalho>> listJornada() {
        List<JornadaTrabalho> listJornada = jornadaTrabalhoService.list();
        return new ResponseEntity<List<JornadaTrabalho>>(listJornada, HttpStatus.OK);
    }

    @ApiOperation(value = "Busca jornada por número de ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> findJornadaById(@PathVariable Long id) {
        try {
            JornadaTrabalho jornadaById = jornadaTrabalhoService.findById(id);
            return new ResponseEntity<>(jornadaById, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Atualiza jornada")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateJornada(@PathVariable Long id, @RequestBody JornadaTrabalho jornada) {
        final JornadaTrabalho jornadaTrabalho = jornadaTrabalhoService.updateJornada(id, jornada);
        return new ResponseEntity<JornadaTrabalho>(jornadaTrabalho, HttpStatus.OK);
    }

    @ApiOperation(value = "Deleta jornada")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJornada(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
