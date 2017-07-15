package com.menu.service;

import com.menu.domain.Menu;

/**
 * Created by fmy on 2017/7/11.
 */
public interface MenuService {

    Menu get(String id);

    Object findAll();
}
