package com.izvoc.cred.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "Nome não pode ser vazio")
    private String name;
    @Column(nullable = false, unique = true)
    @NotBlank(message="Campo Obrigatório")
    @Size(min = 11, max = 11, message="Minimo de 11 caracteres")
    private String cpf;
    private Double income;
    @PastOrPresent(message = "Data não pode ser futura")

    private LocalDate birthDate;
    private Integer children;


    public Client() {}
    // CONSTRUTOR CLASSICO COM PARAMETROS
    public Client(Long id, String name, String CPF, Double income, Integer children, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.cpf = CPF;
        this.income = income;
        this.children = children;
        this.birthDate = birthDate;
    }

    //HASH PRA COMPARAR OBJETOS PELO ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        // Comparamos apenas o ID porque ele é a identidade única no banco
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    // tostring classico
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", CPF='" + cpf + '\'' +
                ", income=" + income +
                ", birthDate=" + birthDate +
                ", children=" + children +
                '}';
    }

    // GETTER E SETTERS COM ID APENAS GETEANDO POIS O SET QUEM FAZ É A JPA
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String CPF) {
        this.cpf = CPF;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
