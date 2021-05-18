package org.wlei.thinking.in.spring.overview.domain;

import lombok.ToString;
import org.wlei.thinking.in.spring.overview.annotation.Super;

/**
 * Super
 *
 * @author Wendong Lei
 * @version 1.0
 * @since 5/17/2021
 **/
@ToString(callSuper = true)
@Super
public class SuperUser extends User{
    String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
