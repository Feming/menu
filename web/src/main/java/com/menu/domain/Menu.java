package com.menu.domain;

import java.io.Serializable;

/**
 * Created by fmy on 2017/7/11.
 */
public class Menu implements Serializable {

    private String uuid;

    private String name;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
