/**
 * Resumen.
 * Objeto                   : ProductController.java
 * Descripción              : Clase de controladora para invocar a métodos CRUD con rest api.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.product.controller;

import com.nttdata.bootcamp.product.model.document.Product;
import com.nttdata.bootcamp.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controladora para invocar a métodos CRUD con rest api.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    /** Declaración de la clase service */
    @Autowired
    private ProductService productService;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el Product, tipo Mono
     */
    @PostMapping
    public Mono<ResponseEntity<Product>> create(@RequestBody Product product){
        return this.productService.insert(product)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el Product, tipo Mono
     */
    @PutMapping
    public Mono<ResponseEntity<Product>> update(@RequestBody Product product){
        return this.productService.update(product)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return this.productService.delete(id)
                .map(v -> new ResponseEntity<>(v, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el Product, tipo String
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Product>> find(@PathVariable String id) {
        return this.productService.find(id)
                .map(product -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(product));
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el Product, tipo String
     */
    @GetMapping("/findByCode/{code}")
    public Mono<ResponseEntity<Product>> findByCode(@PathVariable String code) {
        return this.productService.findByCode(code)
                .map(product -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(product));
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el Product, tipo Flux
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<Product>>> findAll() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(this.productService.findAll())
        );
    }

}
