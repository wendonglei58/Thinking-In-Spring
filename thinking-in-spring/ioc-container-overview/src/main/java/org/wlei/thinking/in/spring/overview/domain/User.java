package org.wlei.thinking.in.spring.overview.domain;

import lombok.ToString;

/**
 * User Class
 *
 * @author Wendong Lei
 * @version 1.0
 * @since 5/17/2021
 **/
@ToString
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
}
