package com.lex.showcase.mybatis;

import java.util.List;

public interface UserMapper {

    User get(Integer id);

    List<User> findAll();

    List<User> getUsers(String loginName);

    void save(User user);

    void batchInsert(List<User> users);

    void update(User user);

    void delete(Integer id);
}
