package com.zk.ioc.domain;/**
 * Created by dzk on 2020/1/14.
 */

/**
 * @ClassName User
 * @Description
 * @Author dzk
 * @Version v1
 * @Date 2020/1/14
 **/
public class User {

    private Long id;

    private String name;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static User createUsrer() {
        return new User();
    }
}

