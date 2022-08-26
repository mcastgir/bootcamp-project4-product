/**
 * Resumen.
 * Objeto                   : ProductTypeController.java
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
import com.nttdata.bootcamp.product.model.document.ProductType;
import com.nttdata.bootcamp.product.service.ProductTypeService;
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
@RequestMapping("/api/producttypes")
public class ProductTypeController {

    /** Declaración de la clase service */
    @Autowired
    private ProductTypeService productTypeService;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el ProductType, tipo Mono
     */
    @PostMapping
    public Mono<ResponseEntity<ProductType>> create(@RequestBody ProductType productType){
        return this.productTypeService.insert(productType)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el ProductType, tipo Mono
     */
    @PutMapping
    public Mono<ResponseEntity<ProductType>> update(@RequestBody ProductType productType){
        return this.productTypeService.update(productType)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return this.productTypeService.delete(id)
                .map(v -> new ResponseEntity<>(v, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el ProductType, tipo String
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<ProductType>> find(@PathVariable String id) {
        return this.productTypeService.find(id)
                .map(productType -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(productType));
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el ProductType, tipo String
     */
    @GetMapping("/findByCode/{code}")
    public Mono<ResponseEntity<ProductType>> findByCode(@PathVariable String code) {
        return this.productTypeService.findByCode(code)
                .map(productType -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(productType));
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el ProductType, tipo Flux
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<ProductType>>> findAll() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(this.productTypeService.findAll())
        );
    }

}
