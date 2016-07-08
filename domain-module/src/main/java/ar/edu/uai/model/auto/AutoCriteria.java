package ar.edu.uai.model.auto;

/**
 * Created by Nicolas on 06/07/2016.
 */
public class AutoCriteria {

    private String marca;
    private Integer minModelo;
    private Integer maxModelo;

    public AutoCriteria(String marca, Integer minModelo, Integer maxModelo) {
        this.marca = marca;
        this.minModelo = minModelo;
        this.maxModelo = maxModelo;
    }

    public Integer getMaxModelo() {
        return maxModelo;
    }

    public Integer getMinModelo() {
        return minModelo;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "AutoCriteria {" +
                "marca='" + marca + '\'' +
                ", minModelo=" + minModelo +
                ", maxModelo=" + maxModelo +
                '}';
    }


}
