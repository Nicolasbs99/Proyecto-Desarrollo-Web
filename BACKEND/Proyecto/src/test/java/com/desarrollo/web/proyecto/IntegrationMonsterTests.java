package com.desarrollo.web.proyecto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.javeriana.Proyecto.Model.Monstruo;
import co.edu.javeriana.Proyecto.Model.MonstruoRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import com.fasterxml.jackson.core.type.TypeReference;

@ActiveProfiles("Testeo")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IntegrationMonsterTests {

    @LocalServerPort
    private int port;

    @Autowired
    MonstruoRepo monsterRepository;

    @Autowired
    TestRestTemplate rest;

    @BeforeEach
    void init() {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Monstruo> monsterList = new ArrayList<>();
        try {
            monsterList = objectMapper.readValue(
                    new File("Assets/monstruosTest.json"),
                    new TypeReference<List<Monstruo>>() {
                    });

        } catch (IOException e) {

            e.printStackTrace();
        }
        monsterRepository.saveAll(monsterList);
    }

    @Test
    void getMonsterTest() {

        Monstruo monster = this.rest.getForObject("http://localhost:" + port + "/monster/3/get",
        Monstruo.class);

        assertEquals("Nechryael", monster.getName());

    }

    @Test
    void createMonsterTest() {

        Monstruo decoMonster = this.rest.postForObject(
                "http://localhost:" + port + "/monster/save",
                new Monstruo("new monster"),
                Monstruo.class);

        assertEquals("new monster", decoMonster.getName());

    }

    @Test
    void editMonsterTest() {

        Long id = 2l;

        Monstruo editMonster = new Monstruo("Aberrant spectre edited");
        editMonster.setId(2l);

        this.rest.postForObject(
                "http://localhost:" + port + "/monster/save",
                editMonster,
                Monstruo.class);

                Monstruo monster = this.rest.getForObject("http://localhost:" + port + "/monster/" + id + "/get",
                Monstruo.class);

        assertEquals("Aberrant spectre edited", monster.getName());

    }

    @Test
    void deleteMonsterTest() {

        String message = this.rest.getForObject(
                "http://localhost:" + port + "/monster/1/delete", String.class);

        assertEquals("monster deleted", message);

    }
}