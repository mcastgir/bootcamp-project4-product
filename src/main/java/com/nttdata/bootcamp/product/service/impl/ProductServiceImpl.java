/**
 * Resumen.
 * Objeto                   : ProductServiceImpl.java
 * Descripción              : Clase para los métodos de la implementación de servicio del producto.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.product.service.impl;

import com.nttdata.bootcamp.product.model.dao.ProductDao;
import com.nttdata.bootcamp.product.model.document.Product;
import com.nttdata.bootcamp.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase para los métodos de la implementación de servicio del producto.
 */
@Service
public class ProductServiceImpl implements ProductService {

    /** Declaración de la variable de log */
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    /** Declaración de la clase dao */
    @Autowired
    private ProductDao productDao;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el Product, tipo Mono
     */
    @Override
    public Mono<Product> insert(Product product) {
        return productDao.save(product)
                .doFirst(() -> log.info("Begin Insert Product"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Insert Product"));
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el Client, tipo Mono
     */
    @Override
    public Mono<Product> update(Product product) {
        return productDao.findById(product.getId())
                .doFirst(() -> log.info("Begin Update Product"))
                .map(p -> product)
                .flatMap(this.productDao::save)
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Update Product"));
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @Override
    public Mono<Void> delete(String id) {
        return productDao.deleteById(id)
                .doFirst(() -> log.info("Begin Delete Product"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Delete Product"));
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el Product, tipo String
     */
    @Override
    public Mono<Product> find(String id) {
        return productDao.findById(id)
                .doFirst(() -> log.info("Begin Find Product"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Find Product"));
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el Client, tipo String
     */
    @Override
    public Mono<Product> findByCode(String code) {
        return productDao.findByCode(code)
                .doFirst(() -> log.info("Begin FindByCode Product"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish FindByCode Product"));
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Mono retorna el Product, tipo String
     */
    @Override
    public Flux<Product> findAll() {
        return productDao.findAll()
                .doFirst(() -> log.info("Begin FindAll Product"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish FindAll Product"));
    }

}
