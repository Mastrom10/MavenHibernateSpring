package ar.edu.uai.model.auto;

import javax.persistence.*;

/**
 * Created by Nicolas on 06/07/2016.
 */

@Entity
@Table(name = "AUTO")
@Access(AccessType.FIELD)
public class Auto {

    @Id
    @GeneratedValue
    @Column(name = "AUTO_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "MARCA", nullable = false)
    private String marca;

    @Column(name = "MODELO", nullable = false)
    private Integer modelo;

    public Auto(){

    }
    public Auto(Integer id, String marca, Integer modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public Integer getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", marca=" + marca + ", modelo=" + modelo + "]";
    }


}
