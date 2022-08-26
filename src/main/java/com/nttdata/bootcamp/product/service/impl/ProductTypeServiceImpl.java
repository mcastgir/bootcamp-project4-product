/**
 * Resumen.
 * Objeto                   : ProductServiceImpl.java
 * Descripción              : Clase para los métodos de la implementación de servicio del tipo de producto.
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

import com.nttdata.bootcamp.product.model.dao.ProductTypeDao;
import com.nttdata.bootcamp.product.model.document.ProductType;
import com.nttdata.bootcamp.product.service.ProductTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase para los métodos de la implementación de servicio del tipo de producto.
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    /** Declaración de la variable de log */
    private static final Logger log = LoggerFactory.getLogger(ProductTypeServiceImpl.class);

    /** Declaración de la clase dao */
    @Autowired
    private ProductTypeDao productTypeDao;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el ProductType, tipo Mono
     */
    @Override
    public Mono<ProductType> insert(ProductType productType) {
        return productTypeDao.save(productType)
                .doFirst(() -> log.info("Begin Insert ProductType"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Insert ProductType"));
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el ProductType, tipo Mono
     */
    @Override
    public Mono<ProductType> update(ProductType productType) {
        return productTypeDao.findById(productType.getId())
                .doFirst(() -> log.info("Begin Update ProductType"))
                .map(p -> productType)
                .flatMap(this.productTypeDao::save)
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Update ProductType"));
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @Override
    public Mono<Void> delete(String id) {
        return productTypeDao.deleteById(id)
                .doFirst(() -> log.info("Begin Delete ProductType"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Delete ProductType"));
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el ProductType, tipo String
     */
    @Override
    public Mono<ProductType> find(String id) {
        return productTypeDao.findById(id)
                .doFirst(() -> log.info("Begin Find ProductType"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Find ProductType"));
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el ProductType, tipo String
     */
    @Override
    public Mono<ProductType> findByCode(String code) {
        return productTypeDao.findByCode(code)
                .doFirst(() -> log.info("Begin FindByCode ProductType"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish FindByCode ProductType"));
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Mono retorna el ProductType, tipo String
     */
    @Override
    public Flux<ProductType> findAll() {
        return productTypeDao.findAll()
                .doFirst(() -> log.info("Begin FindAll ProductType"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish FindAll ProductType"));
    }

}
