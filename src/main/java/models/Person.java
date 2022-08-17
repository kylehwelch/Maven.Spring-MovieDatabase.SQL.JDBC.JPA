package models;

import java.sql.Date;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String first_name;
    private String last_name;
    private String mobile;
    private Date birthday;
    private Integer home_id;

    public Person() {
    }

    public Person (String first_name, String last_name, String mobile, Date birthday, Integer home_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobile = mobile;
        this.birthday = birthday;
        this.home_id = home_id;
    }

    public Person (Integer id, String first_name, String last_name, String mobile, Date birthday, Integer home_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobile = mobile;
        this.birthday = birthday;
        this.home_id = home_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getHome_id() {
        return home_id;
    }

    public void setHome_id(Integer home_id) {
        this.home_id = home_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(first_name, person.first_name) &&
                Objects.equals(last_name, person.last_name) &&
                Objects.equals(mobile, person.mobile) &&
                Objects.equals(birthday, person.birthday)&&
                Objects.equals(home_id, person.home_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, mobile, birthday, home_id);
    }
}
