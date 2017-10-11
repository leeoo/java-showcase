package com.lex.showcase.language_feature.clone;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Lex Li
 */
public class User implements Serializable {

    private transient String serialNo;
    private static String IDENTIFIER = "User";

    private Long id;
    private String name;
    private String gender;
    private Integer age;

    private Role role;

    public User() {

    }

    public User(Long id, String name, String gender, Integer age) {
        this.serialNo = UUID.randomUUID().toString();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!name.equals(user.name)) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("gender", gender)
                .append("age", age)
                .append("role", role)
                .toString();
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
