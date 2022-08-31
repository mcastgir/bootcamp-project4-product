package com.nttdata.bootcamp.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bootcamp.product.model.document.Product;
import com.nttdata.bootcamp.product.service.ProductService;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    private static final String URI_PRODUCT = "/api/products";

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;

    @Test
    void create() throws Exception {
        /* Builder Object */
        Product product = Product.builder()
                .id("62f0c3e4b2d3ae40b08f56dd")
                .code("CTA-AHR")
                .name("CUENTA DE AHORRO")
                .description("CUENTA DE AHORRO")
                .codeProductType("CBA")
                .movementControl(true)
                .movementCountMax(10)
                .monthlyCommission(20.00)
                .state(true)
                .build();
        /* Mockito When */
        Mockito.when(productService.insert(product))
                .thenReturn(Single.just(product));
        /* MvcResult When */
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post(URI_PRODUCT)
                        .content(objectMapper.writeValueAsString(product))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult))
                .andExpect(MockMvcResultMatchers.status().isOk());
        /* Mockito Verify */
        Mockito.verify(productService, Mockito.times(1)).insert(product);
    }

    @Test
    void update() throws Exception {
        /* Builder Object */
        Product product = Product.builder()
                .id("62f0c3e4b2d3ae40b08f56dd")
                .code("CTA-AHR")
                .name("CUENTA DE AHORRO")
                .description("CUENTA DE AHORRO")
                .codeProductType("CBA")
                .movementControl(true)
                .movementCountMax(10)
                .monthlyCommission(20.00)
                .state(true)
                .build();
        /* Mockito When */
        Mockito.when(productService.update(product))
                .thenReturn(Single.just(product));
        /* MvcResult When */
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .put(URI_PRODUCT)
                        .content(objectMapper.writeValueAsString(product))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult))
                .andExpect(MockMvcResultMatchers.status().isOk());
        /* Mockito Verify */
        Mockito.verify(productService, Mockito.times(1)).update(product);
    }

    @Test
    void delete() throws Exception {
        /* Builder Object */
        Product product = Product.builder()
                .id("62f0c3e4b2d3ae40b08f56dd")
                .build();
        /* Mockito When */
        Mockito.when(productService.delete(product.getId()))
                .thenReturn(Single.just(product));
        /* MvcResult When */
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .delete(URI_PRODUCT.concat("/{id}"), product.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult))
                .andExpect(MockMvcResultMatchers.status().isOk());
        /* Mockito Verify */
        Mockito.verify(productService, Mockito.times(1)).delete(product.getId());
    }

    @Test
    void find() throws Exception {
        /* Builder Object */
        Product product = Product.builder()
                .id("62f0c3e4b2d3ae40b08f56dd")
                .code("CTA-AHR")
                .name("CUENTA DE AHORRO")
                .description("CUENTA DE AHORRO")
                .codeProductType("CBA")
                .movementControl(true)
                .movementCountMax(10)
                .monthlyCommission(20.00)
                .state(true)
                .build();
        /* Mockito */
        Mockito.when(productService.find(product.getId()))
                .thenReturn(Single.just(product));
        /* MvcResult When */
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get(URI_PRODUCT.concat("/{id}"), product.getId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andReturn();
        mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult))
                .andExpect(MockMvcResultMatchers.status().isOk());
        /* Mockito Verify */
        Mockito.verify(productService, Mockito.times(1)).find(product.getId());
    }

    @Test
    void findByCode() throws Exception {
        /* Builder Object */
        Product product = Product.builder()
                .id("62f0c3e4b2d3ae40b08f56dd")
                .code("CTA-AHR")
                .name("CUENTA DE AHORRO")
                .description("CUENTA DE AHORRO")
                .codeProductType("CBA")
                .movementControl(true)
                .movementCountMax(10)
                .monthlyCommission(20.00)
                .state(true)
                .build();
        /* Mockito */
        Mockito.when(productService.findByCode(product.getCode()))
                .thenReturn(Single.just(product));
        /* MvcResult When */
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get(URI_PRODUCT.concat("/findByCode/{code}"), product.getCode())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult))
                .andExpect(MockMvcResultMatchers.status().isOk());
        /* Mockito Verify */
        Mockito.verify(productService, Mockito.times(1)).findByCode(product.getCode());
    }

    @Test
    void findAll() throws Exception {
        /* Builder Object */
        List<Product> persons = Arrays.asList(Product.builder()
                .id("62f0c3e4b2d3ae40b08f56dd")
                .code("CTA-AHR")
                .name("CUENTA DE AHORRO")
                .description("CUENTA DE AHORRO")
                .codeProductType("CBA")
                .movementControl(true)
                .movementCountMax(10)
                .monthlyCommission(20.00)
                .state(true)
                .build());
        /* Mockito */
        Mockito.when(productService.findAll())
                .thenReturn(Observable.fromIterable(persons));
        /* MvcResult When */
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get(URI_PRODUCT)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andReturn();
        mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult))
                .andExpect(MockMvcResultMatchers.status().isOk());
        /* Mockito Verify */
        Mockito.verify(productService, Mockito.times(1)).findAll();
    }

}