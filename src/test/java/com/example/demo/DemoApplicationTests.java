package com.example.demo;

import com.example.demo.controller.CityController;
import com.example.demo.entity.City;
import com.example.demo.service.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest
class DemoApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CityService cityService;

    @Autowired
    private CityController cityController;

    @Test
    void contextLoads() {
        assertThat(cityController).isNotNull();
    }


    @Test
    void nenhumaCidadeCadastrada() throws Exception {
        this.mockMvc.perform(get("/city/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void umaCidadeCadastrada() throws Exception {
        when(cityService.findAll()).thenReturn(List.of(new City("cidadeUm","estadoUm")));
        this.mockMvc.perform(get("/city/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("[{\"name\":\"cidadeUm\",\"state\":\"estadoUm\"}]"));
    }

}
