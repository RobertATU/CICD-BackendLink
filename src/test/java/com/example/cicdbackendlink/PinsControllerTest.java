package com.example.cicdbackendlink;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PinsControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;
    @Autowired
    public PinsControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }


    @Test
    public void testCreatePins() throws Exception{
        Pins pins = new Pins();
        pins.setSheepId("newSheep");
        pins.setLongitude(20.321);
        pins.setLatitude(20.123);

        String requestBody = objectMapper.writeValueAsString(pins);

        mockMvc.perform(post("/pins/createPin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());

    }

    @Test
    public void testAllPins() throws Exception{
        mockMvc.perform(get("/pins"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletePin() throws Exception {
        Pins pins = new Pins();
        pins.setSheepId("Delete");
        pins.setLongitude(20.321);
        pins.setLatitude(20.123);

        String requestBody = objectMapper.writeValueAsString(pins);
        mockMvc.perform(post("/pins/createPin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/pins/removePin/{sheepId}","Delete"))
                .andExpect(status().isOk());

    }
}

