package ar.edu.uai.paradigms.dto.person;

/**
 * Created by federicodonnarumma on 11/4/15.
 */
public class PersonCriteriaDTO {

    private String name;
    private Integer minAge;
    private Integer maxAge;

    public PersonCriteriaDTO() {}

    public PersonCriteriaDTO(String name, Integer minAge, Integer maxAge) {
        this();
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonCriteriaDTO{" +
                "name='" + name + '\'' +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                '}';
    }
}

