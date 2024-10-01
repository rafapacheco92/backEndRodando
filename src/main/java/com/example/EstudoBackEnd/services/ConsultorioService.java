package com.example.EstudoBackEnd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EstudoBackEnd.dtos.req.CreateConsultorioDTO;
import com.example.EstudoBackEnd.dtos.req.CreatePacienteDTO;
import com.example.EstudoBackEnd.dtos.res.ShowConsultorioDTO;
import com.example.EstudoBackEnd.dtos.res.ShowEnderecoDTO;
import com.example.EstudoBackEnd.dtos.res.ShowPacienteDTO;
import com.example.EstudoBackEnd.entities.ConsultorioEntity;
import com.example.EstudoBackEnd.entities.EnderecoEntity;
import com.example.EstudoBackEnd.entities.PacienteEntity;
import com.example.EstudoBackEnd.repositories.ConsultorioRepository;
import com.example.EstudoBackEnd.repositories.EnderecoRepository;
import com.example.EstudoBackEnd.repositories.PacienteRepository;

@Service
public class ConsultorioService {

  @Autowired
  ConsultorioRepository consultorioRepository;

  @Autowired
  EnderecoRepository enderecoRepository;

  @Autowired
  PacienteRepository pacienteRepository;

  public void createConsultorio(CreateConsultorioDTO dto) {

    ConsultorioEntity consultorioEntity = new ConsultorioEntity();
    consultorioEntity.setNome(dto.getNome());

    consultorioEntity = consultorioRepository.save(consultorioEntity);

    EnderecoEntity enderecoEntity = new EnderecoEntity();
    enderecoEntity.setRua(dto.getEndereco().getRua());
    enderecoEntity.setNumero(dto.getEndereco().getNumero());
    enderecoEntity.setCidade(dto.getEndereco().getCidade());
    enderecoEntity.setConsultorio(consultorioEntity);

    enderecoEntity = enderecoRepository.save(enderecoEntity);

    List<PacienteEntity> pacientesEntity = new ArrayList<>();

    if (dto.getPaciente() != null) {
      for (CreatePacienteDTO pacienteDTO : dto.getPaciente()) {
        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setNome(pacienteDTO.getNome());
        pacienteEntity.setIdade(pacienteDTO.getIdade());
        pacienteEntity.setConsultorio(consultorioEntity);

        pacientesEntity.add(pacienteEntity);
      }

      pacienteRepository.saveAll(pacientesEntity);
    }
  }

  public List<ShowConsultorioDTO> getAllConsultorios() {
    List<ConsultorioEntity> consultoriosEntity = consultorioRepository.findAll();

    return consultoriosEntity
        .stream()
        .map(consultorio -> {
          ShowConsultorioDTO consultorioDTO = new ShowConsultorioDTO();
          ShowEnderecoDTO enderecoDTO = new ShowEnderecoDTO();
          List<ShowPacienteDTO> pacientesDTO = new ArrayList<>();

          for (PacienteEntity pacienteEntity : consultorio.getPacientes()) {
            ShowPacienteDTO pacienteDTO = new ShowPacienteDTO();
            pacienteDTO.setNome(pacienteEntity.getNome());
            pacienteDTO.setIdade(pacienteEntity.getIdade());
            pacientesDTO.add(pacienteDTO);
          }

          if (consultorio.getEndereco() != null) {
            enderecoDTO.setRua(consultorio.getEndereco().getRua());
            enderecoDTO.setNumero(consultorio.getEndereco().getNumero());
            enderecoDTO.setCidade(consultorio.getEndereco().getCidade());
          }
          consultorioDTO.setId(consultorio.getId());
          consultorioDTO.setNome(consultorio.getNome());
          consultorioDTO.setEndereco(enderecoDTO);
          consultorioDTO.setPacientes(pacientesDTO);

          return consultorioDTO;
        }).toList();
  }
}
