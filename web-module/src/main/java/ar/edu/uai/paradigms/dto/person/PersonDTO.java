package ar.edu.uai.paradigms.dto.person;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Federico Donnarumma on 10/15/14.
 */
public class PersonDTO {

    private Integer id;

    private String name;
    private int age;

    @JsonCreator
    public PersonDTO(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("age") int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}
