package com.lex.showcase.mybatis;

import java.util.List;

public interface GroupMapper {

    Group get(Integer id);

    // List<Group> findAll();
    //
    List<User> getGroupUsers(Integer groupId);

    // List<Group> getGroups(String name);
    //
    // void save(Group group);
    //
    // void batchInsert(List<Group> groups);
    //
    // void update(Group group);
    //
    // void delete(Integer id);
}
