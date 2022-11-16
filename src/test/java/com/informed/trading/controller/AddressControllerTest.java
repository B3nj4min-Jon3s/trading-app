package com.informed.trading.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.informed.trading.reference.transactionalData.Address;
import com.informed.trading.service.ServiceTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {ServiceTestConfig.class})
@AutoConfigureMockMvc
@EnableWebMvc
class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void setAddressService() {
    }

    @Test
    void getAddresses() {
    }

    @Test
    void getAddress() {
    }

    @Test
    void addAddress() {
    }

    @Test
    void updateAddress() {
    }

    @Test
    void deleteByID() {
    }

    @Test
    void itemNotFoundFailure() {
    }

    @Test
    public void testAddingNewAddressRequest() throws Exception {

        String url = "/trader/address";

        Address address = new Address("20 high street", "line", "line", "Manchester", "BANES", "BA2 2EE");

        System.out.println(asJsonString(address));

        mockMvc.perform(post(url)
                        .content(asJsonString(address))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


