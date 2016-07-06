package ar.edu.uai.model.person;

/**
 * Created by federicodonnarumma on 11/4/15.
 */
public class PersonCriteria {

    private String name;
    private Integer minAge;
    private Integer maxAge;

    public PersonCriteria(String name, Integer minAge, Integer maxAge) {
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
    public Integer getMaxAge() {
        return maxAge;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonCriteria {" +
                "name='" + name + '\'' +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                '}';
    }
}

