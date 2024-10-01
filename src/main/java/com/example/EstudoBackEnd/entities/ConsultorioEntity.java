package com.example.EstudoBackEnd.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;

@Entity(name = "consultorios")
public class ConsultorioEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome")
  private String nome;

  @OneToOne(mappedBy = "consultorio")
  private EnderecoEntity endereco;

  @OneToMany(mappedBy = "consultorio")
  private List<PacienteEntity> pacientes;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public EnderecoEntity getEndereco() {
    return endereco;
  }

  public void setEndereco(EnderecoEntity endereco) {
    this.endereco = endereco;
  }

  public List<PacienteEntity> getPacientes() {
    return pacientes;
  }

  public void setPacientes(List<PacienteEntity> pacientes) {
    this.pacientes = pacientes;
  }

}
