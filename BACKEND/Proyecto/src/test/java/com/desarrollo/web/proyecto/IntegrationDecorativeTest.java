package com.desarrollo.web.proyecto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.databind.ObjectMapper;


import co.edu.javeriana.Proyecto.Model.Decoracion;
import co.edu.javeriana.Proyecto.Model.DecoracionRepo;

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
class IntegrationDecorativeTest {

	@LocalServerPort
	private int port;

	@Autowired
	DecoracionRepo decorativeItemRepository;

	@Autowired
	TestRestTemplate rest;

	@BeforeEach
	void init() {

		ObjectMapper objectMapper = new ObjectMapper();
        List<Decoracion> itemList = new ArrayList<>();
        try {
            itemList = objectMapper.readValue(
                    new File("Assets/objetosTest.json"),
                    new TypeReference<List<Decoracion>>() {
                    });

        } catch (IOException e) {

            e.printStackTrace();
        }

        decorativeItemRepository.saveAll(itemList);
    }
	
	@Test
	void getTest() {

		Decoracion decoItem = this.rest.getForObject("http://localhost:" + port + "/decoItem/3/get",
        Decoracion.class);
		assertEquals("Door", decoItem.getName());

	}

	@Test
	void createTest() {

		Decoracion decoItem = this.rest.postForObject(
				"http://localhost:" + port + "/decoItem/save",
				new Decoracion("new Item"),
				Decoracion.class);

		assertEquals("new Item", decoItem.getName());

	}

	@Test
	void editTest() {

		Long id = 2l;

		Decoracion editDecoItem = new Decoracion("Cave Entrance edited");
		editDecoItem.setId(2l);

		this.rest.postForObject(
				"http://localhost:" + port + "/decoItem/save",
				editDecoItem,
				Decoracion.class);

                Decoracion decoItem = this.rest.getForObject("http://localhost:" + port + "/decoItem/" + id + "/get",
        Decoracion.class);

		assertEquals("Cave Entrance edited", decoItem.getName());

	}

	@Test
	void deleteTest() {

		String message = this.rest.getForObject(
				"http://localhost:" + port + "/decoItem/1/delete", String.class);

		assertEquals("item deleted", message);

	}


	




}