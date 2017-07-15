package com.menu.controller;

import com.menu.domain.Menu;
import com.menu.service.MenuService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by fmy on 2017/7/11.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    @RequestMapping("/{id}/getMenu")
    public Menu getMenu(@PathVariable("id")String id){
        return menuService.get(id);
    }

    @RequestMapping("/findAll")
    public Object findAll(){
        return menuService.findAll();
    }
}
