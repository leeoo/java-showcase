package com.lex.showcase.java8_new_features;

import java.util.*;

/**
 *
 */
public class LambdaDemo {

    public static void main(String[] args) {
        List<User> userList = makeUserList();

        // List to Map
        Map<Gender, User> userMap = new HashMap<>();
        userList.stream().forEach(user -> userMap.put(user.getGender(), user));

        // List to Set
        Set<User> userSet = new TreeSet<>();
        userList.stream().forEach(user -> userSet.add(user));

        // List to
    }

    private static List<User> makeUserList() {
        List<User> userList = new ArrayList<>();

        User tom = new User();
        tom.setId(1L);
        tom.setName("Tom");
        tom.setGender(Gender.Male);
        tom.setAge(18);

        User ada = new User();
        tom.setId(2L);
        tom.setName("Ada");
        tom.setGender(Gender.Female);
        tom.setAge(19);

        User ken = new User();
        tom.setId(3L);
        tom.setName("Ken");
        tom.setGender(Gender.Male);
        tom.setAge(21);

        userList.add(tom);
        userList.add(ada);
        userList.add(ken);

        return userList;
    }
}

class User {
    private Long id;
    private String name;
    private Gender gender;
    private Integer age;

    public User() {

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}

enum Gender {
    Male, Female;
}
