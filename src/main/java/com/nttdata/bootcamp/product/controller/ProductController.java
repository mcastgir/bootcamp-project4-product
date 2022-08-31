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
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Clase de controladora para invocar a métodos CRUD con rest api.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Single<ResponseEntity<Product>> create(@RequestBody Product product){
        return this.productService.insert(product)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK));
    }

    @PutMapping
    public Single<ResponseEntity<Product>> update(@RequestBody Product product){
        return this.productService.update(product)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public Single<ResponseEntity<Product>> delete(@PathVariable String id) {
        return this.productService.delete(id)
                .map(v -> new ResponseEntity<>(v, HttpStatus.OK));
    }

    @GetMapping("/{id}")
    public Single<ResponseEntity<Product>> find(@PathVariable String id) {
        return this.productService.find(id)
                .map(product -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(product));
    }

    @GetMapping("/findByCode/{code}")
    public Single<ResponseEntity<Product>> findByCode(@PathVariable String code) {
        return this.productService.findByCode(code)
                .map(product -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(product));
    }

    @GetMapping
    public Single<ResponseEntity<Observable<Product>>> findAll() {
        return Single.just(
                ResponseEntity.ok()
                        .header("Accept", "application/json")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(this.productService.findAll())
        );
    }

}
