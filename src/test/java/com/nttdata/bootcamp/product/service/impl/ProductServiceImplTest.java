package com.nttdata.bootcamp.product.service.impl;

import com.nttdata.bootcamp.product.model.dao.ProductDao;
import com.nttdata.bootcamp.product.model.document.Product;
import com.nttdata.bootcamp.product.service.ProductService;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Mock
    private ProductDao productDao;
    @InjectMocks
    private ProductService productService = new ProductServiceImpl();

    @Test
    void insert() {
        /*Product product = Product.builder()
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

        Mockito.when(productDao.insert(product))
                .thenReturn(product);

        productService.insert(product)
                .test()
                .assertComplete()
                .assertNoErrors()
                .assertValue(product)
                .awaitTerminalEvent();

        InOrder inOrder = Mockito.inOrder(productDao);
        inOrder.verify(productDao, Mockito.times(1)).insert(product);*/
    }

    @Test
    void update() {
        /*Product product = Product.builder()
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

        Mockito.when(productDao.save(product))
                .thenReturn(product);

        productService.update(product)
                .test()
                .assertComplete()
                .assertNoErrors()
                .assertValue(product)
                .awaitTerminalEvent();

        InOrder inOrder = Mockito.inOrder(productDao);
        inOrder.verify(productDao, Mockito.times(1)).save(product);*/
    }

    @Test
    void delete() {
        /*Product product = Product.builder()
                .id("62f0c3e4b2d3ae40b08f56dd")
                .build();

        Mockito.doNothing().when(productDao)
                .deleteById(product.getId());

        productService.delete(product.getId())
                .test()
                .assertComplete()
                .assertNoErrors()
                .awaitTerminalEvent();

        InOrder inOrder = Mockito.inOrder(productDao);
        inOrder.verify(productDao, Mockito.times(1)).deleteById(product.getId());*/
    }

    @Test
    void find() {
        /*Product product = Product.builder()
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

        Mockito.when(productDao.findById(product.getId()))
                .thenReturn(Optional.of(product));

        productService.find(product.getId())
                .test()
                .assertComplete()
                .assertNoErrors()
                .awaitTerminalEvent();

        InOrder inOrder = Mockito.inOrder(productDao);
        inOrder.verify(productDao, Mockito.times(1)).findById(product.getId());*/
    }

    @Test
    void findByCode() {
        /*Product product = Product.builder()
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

        Mockito.when(productDao.findByCode(product.getCode()))
                .thenReturn(Optional.of(product));

        productService.findByCode(product.getCode())
                .test()
                .assertComplete()
                .assertNoErrors()
                .awaitTerminalEvent();

        InOrder inOrder = Mockito.inOrder(productDao);
        inOrder.verify(productDao, Mockito.times(1)).findByCode(product.getCode());*/
    }

    @Test
    void findAll() {
        /*List<Product> products = Arrays.asList(Product.builder()
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

        Mockito.when(productService.findAll())
                .thenReturn(Observable.fromIterable(products));

        productService.findAll()
                .test()
                .assertComplete()
                .assertNoErrors()
                .awaitTerminalEvent();

        InOrder inOrder = Mockito.inOrder(productDao);
        inOrder.verify(productDao, Mockito.times(1)).findAll();*/
    }
}