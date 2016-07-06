package ar.edu.uai.paradigms.dto.auto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nicolas on 06/07/2016.
 */
public class AutoDTO {

    private Integer id;
    private String marca;
    private Integer modelo;

    @JsonCreator
    public AutoDTO(@JsonProperty("id") Integer id, @JsonProperty("marca") String marca, @JsonProperty("modelo") Integer modelo) {
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
