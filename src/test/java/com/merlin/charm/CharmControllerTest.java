package com.merlin.charm;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CharmController.class)
class CharmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharmService charmService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getCharmsReturnsList() throws Exception {
        Charm charm1 = new Charm("Charm1", "red", "fire");
        Charm charm2 = new Charm("Charm2", "blue", "water");
        when(charmService.getAllCharms()).thenReturn(Arrays.asList(charm1, charm2));

        mockMvc.perform(get("/api/v1/charms"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Charm1"))
                .andExpect(jsonPath("$[1].name").value("Charm2"));
    }

    @Test
    void saveCharmPersistsCharm() throws Exception {
        Charm charm = new Charm("Charm1", "red", "fire");

        mockMvc.perform(post("/api/v1/charms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(charm)))
                .andExpect(status().isOk());

        Mockito.verify(charmService).saveCharm(any(Charm.class));
    }
}
