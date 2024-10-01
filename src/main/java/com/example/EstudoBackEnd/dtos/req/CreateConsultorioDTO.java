package com.example.EstudoBackEnd.dtos.req;

import java.util.List;

public class CreateConsultorioDTO {

  private String nome;
  private CreateEnderecoDTO endereco;
  private List<CreatePacienteDTO> paciente;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public CreateEnderecoDTO getEndereco() {
    return endereco;
  }

  public void setEndereco(CreateEnderecoDTO endereco) {
    this.endereco = endereco;
  }

  public List<CreatePacienteDTO> getPaciente() {
    return paciente;
  }

  public void setPaciente(List<CreatePacienteDTO> paciente) {
    this.paciente = paciente;
  }

}
