package com.example.EstudoBackEnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EstudoBackEnd.dtos.req.CreateConsultorioDTO;
import com.example.EstudoBackEnd.dtos.res.ShowConsultorioDTO;
import com.example.EstudoBackEnd.services.ConsultorioService;

@RestController
@RequestMapping("/consultorios")
public class ConsultorioContoller {

  @Autowired
  private ConsultorioService consultorioService;

  @PostMapping
  public ResponseEntity<?> createConsultorio(@RequestBody CreateConsultorioDTO dto) {

    consultorioService.createConsultorio(dto);

    return ResponseEntity.status(201).build();
  }

  @GetMapping
  public ResponseEntity<?> getAllConsultorios() {
    List<ShowConsultorioDTO> consultorios = consultorioService.getAllConsultorios();

    return ResponseEntity.status(200).body(consultorios);
  }
}
