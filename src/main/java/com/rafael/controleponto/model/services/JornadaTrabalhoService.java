package com.rafael.controleponto.model.services;

import com.rafael.controleponto.model.entities.JornadaTrabalho;
import com.rafael.controleponto.model.repositories.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JornadaTrabalhoService {

    @Autowired
    private JornadaTrabalhoRepository jornadaTrabalhoRepository;

    public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoRepository.saveAndFlush(jornadaTrabalho);
    }

    public List<JornadaTrabalho> list() {
        return jornadaTrabalhoRepository.findAll();
    }

    public JornadaTrabalho findById(Long id) {
        return jornadaTrabalhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Jornada not found!"));
    }

    public JornadaTrabalho updateJornada(Long id, JornadaTrabalho jornadaTrabalho) {
       return jornadaTrabalhoRepository.findById(id).map( jornada-> {
            jornada.setDescricao(jornadaTrabalho.getDescricao());
            return jornadaTrabalhoRepository.saveAndFlush(jornada);
        } ).orElseGet(() -> {
           jornadaTrabalho.setId(id);
           return jornadaTrabalhoRepository.saveAndFlush(jornadaTrabalho);
        });
    }

    public void deleteJornada(Long id) {
        jornadaTrabalhoRepository.deleteById(id);
    }

}
