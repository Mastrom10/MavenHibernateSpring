package ar.edu.uai.paradigms.dto.auto;

/**
 * Created by Nicolas on 06/07/2016.
 */
public class AutoCriteriaDTO {

    private String marca;
    private Integer minModelo;
    private Integer maxModelo;

    public AutoCriteriaDTO(){}

    public AutoCriteriaDTO(String marca, Integer minModelo, Integer maxModelo) {
        this.marca = marca;
        this.minModelo = minModelo;
        this.maxModelo = maxModelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getMinModelo() {
        return minModelo;
    }

    public void setMinModelo(Integer minModelo) {
        this.minModelo = minModelo;
    }

    public Integer getMaxModelo() {
        return maxModelo;
    }

    public void setMaxModelo(Integer maxModelo) {
        this.maxModelo = maxModelo;
    }

    @Override
    public String toString() {
        return "AutoCriteriaDTO{" +
                "marca='" + marca + '\'' +
                ", minModelo=" + minModelo +
                ", maxModelo=" + maxModelo +
'}';
        }


        }
