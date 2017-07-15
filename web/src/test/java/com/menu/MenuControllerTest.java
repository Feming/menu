package com.menu;

import com.menu.domain.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by fmy on 2017/7/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class MenuControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void getMenu() {
        String id = "1";
        Menu menu = restTemplate.getForObject("http://localhost:" + port + "/menu/"+ id + "/getMenu", Menu.class);
        assertThat(menu.getName()).isEqualTo("平台");
    }

    public void findAll(){

    }

}
