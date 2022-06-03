package com.desarrollo.web.proyecto;
import static org.junit.jupiter.api.Assertions.assertEquals;


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

import co.edu.javeriana.Proyecto.Model.HabRepo;
import co.edu.javeriana.Proyecto.Model.Habitacion;



@ActiveProfiles("Testeo")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IntegrationRoomTests {
    @LocalServerPort
    private int port;

    @Autowired
    HabRepo roomRepository;

    @Autowired
    TestRestTemplate rest;

    @BeforeEach
    void init() {

        Habitacion roomA = new Habitacion();
        roomA.setName("Room A");
        roomRepository.save(roomA);

        Habitacion rB = new Habitacion();
        rB.setName("Room B");
        roomRepository.save(rB);

    }

    @Test
    void getRoomTest() {

        Habitacion room = this.rest.getForObject("http://localhost:" + port + "/room/2/get",
        Habitacion.class);

        assertEquals("Room B", room.getName());

    }

    @Test
    void createRoomTest() {

        Habitacion newRoom = this.rest.postForObject(
                "http://localhost:" + port + "/room/save",
                new Habitacion("new room"),
                Habitacion.class);

        assertEquals("new room", newRoom.getName());

    }

    @Test
    void editRoomTest() {

        Long id = 2l;

        Habitacion editDecoMonster = new Habitacion("Room B edited");
        editDecoMonster.setId(2l);

        this.rest.postForObject(
                "http://localhost:" + port + "/room/save",
                editDecoMonster,
                Habitacion.class);

                Habitacion room = this.rest.getForObject("http://localhost:" + port + "/room/" + id + "/get",
                Habitacion.class);

        assertEquals("Room B edited",room.getName());

    }

    @Test
    void deleteMonsterTest() {

        String message = this.rest.getForObject(
                "http://localhost:" + port + "/room/1/delete", String.class);

        assertEquals("room deleted", message);

    }
}
