package br.com.jlgregorio.rentacar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vehicles")
public class VehicleModel {

    @Id   /*aqui ele já sabe que o id vai ser a chave primária*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*gera um valor único*/
    private int id;

    @Column(name = "model_name", nullable = false, length = 50)
    private String modelName;

    @Column(nullable = false, length = 50)  /*Se não colocar nome, ele assume o mesmo nome da variável*/
    private String assembler;

    @Column(name = "manufacture_year", nullable = false)
    private int manufactureYear;

    @Column(name = "model_year", nullable = false)
    private int modelYear;

}
