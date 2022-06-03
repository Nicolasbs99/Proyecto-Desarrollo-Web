package com.desarrollo.web.proyecto;
import static org.junit.jupiter.api.Assertions.assertEquals;


import co.edu.javeriana.Proyecto.Model.Jugador;
import co.edu.javeriana.Proyecto.Model.JugadorRepo;

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


@ActiveProfiles("Testeo")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IntegrationPlayerTests {
    @LocalServerPort
    private int port;

    @Autowired
    JugadorRepo playerRepository;

    @Autowired
    TestRestTemplate rest;

    @BeforeEach
    void init() {

        Jugador pA = new Jugador();
        pA.setName("Alice");
        pA.setAttack_level(30);
        pA.setSize(30);
        pA.setWeight(0l);
        pA.setMaxWeight(100l);
        pA.getCategory().add("Categoria Uno");
        pA.getCategory().add("Categoria Dos");

        Jugador pB = new Jugador();
        pB.setName("Bob");
        pB.setAttack_level(20);
        pB.setSize(20);
        pB.setWeight(0l);
        pB.setMaxWeight(100l);
        pB.getCategory().add("Categoria Uno");
        pB.getCategory().add("Categoria Dos");

        playerRepository.save(pA);
        playerRepository.save(pB);

    }

    
    @Test
    void getPlayerTest() {

        Jugador player = this.rest.getForObject("http://localhost:" + port + "/player/2/get",
        Jugador.class);

        assertEquals("Bob", player.getName());

    }

    @Test
    void createPlayerTest() {

        Jugador newPlayer = this.rest.postForObject(
                "http://localhost:" + port + "/player/save",
                new Jugador("new player"),
                Jugador.class);

        assertEquals("new player", newPlayer.getName());

    }

    @Test
    void editPlayerTest() {

        Long id = 2l;

        Jugador editPlayer = new Jugador("Bob edited");
        editPlayer.setId(2l);

        this.rest.postForObject(
                "http://localhost:" + port + "/player/save",
                editPlayer,
                Jugador.class);

                Jugador player = this.rest.getForObject("http://localhost:" + port + "/player/" + id + "/get",
        Jugador.class);

        assertEquals("Bob edited",player.getName());

    }

    @Test
    void deleteMonsterTest() {

        String message = this.rest.getForObject(
                "http://localhost:" + port + "/player/1/delete", String.class);

        assertEquals("player deleted", message);

    }
}
