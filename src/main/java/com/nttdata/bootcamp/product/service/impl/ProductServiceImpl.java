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
import io.reactivex.Observable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase para los métodos de la implementación de servicio del producto.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Override
    public Single<Product> insert(Product product) {
        return Single.just(productDao.insert(product));
    }

    @Override
    public Single<Product> update(Product product) {
        Optional<Product> finded = productDao.findById(product.getId());
        if (finded.isPresent()) {
            return Single.just(productDao.save(product));
        } else {
            return Single.error(new RuntimeException("No existe producto"));
        }
    }

    @Override
    public Single<Product> delete(String id) {
        Optional<Product> finded = productDao.findById(id);
        if (finded.isPresent()) {
            productDao.deleteById(id);
            return Single.just(finded.get());
        } else {
            return Single.error(new RuntimeException("No existe producto"));
        }
    }

    @Override
    public Single<Product> find(String id) {
        Optional<Product> finded = productDao.findById(id);
        if (finded.isPresent()) {
            return Single.just(finded.get());
        } else {
            return Single.error(new RuntimeException("No existe producto"));
        }
    }

    @Override
    public Single<Product> findByCode(String code) {
        Optional<Product> finded = productDao.findByCode(code);
        if (finded.isPresent()) {
            return Single.just(finded.get());
        } else {
            return Single.error(new RuntimeException("No existe producto"));
        }
    }

    @Override
    public Observable<Product> findAll() {
        return Observable.fromIterable(productDao.findAll());
    }

}
