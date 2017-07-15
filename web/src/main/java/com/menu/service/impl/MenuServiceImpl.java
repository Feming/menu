package com.menu.service.impl;

import com.menu.dao.MenuMapper;
import com.menu.domain.Menu;
import com.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fmy on 2017/7/11.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu get(String id) {
        return menuMapper.get(id);
    }

    @Override
    public Object findAll() {
        return menuMapper.findAll();
    }
}
