package com.example.EstudoBackEnd.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "pacientes")
public class PacienteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "idade")
  private int idade;

  @ManyToOne
  @JoinColumn(name = "id_consultorio")
  private ConsultorioEntity consultorio;

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

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public ConsultorioEntity getConsultorio() {
    return consultorio;
  }

  public void setConsultorio(ConsultorioEntity consultorio) {
    this.consultorio = consultorio;
  }

}
