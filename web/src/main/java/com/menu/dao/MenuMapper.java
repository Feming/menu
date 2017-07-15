package com.menu.dao;

import com.menu.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by fmy on 2017/7/11.
 */
@Mapper
@Repository
public interface MenuMapper {
    Menu get(@Param("id")String id);

    Object findAll();
}
