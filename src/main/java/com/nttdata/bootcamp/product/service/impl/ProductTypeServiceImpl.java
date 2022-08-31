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
import io.reactivex.Observable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Clase para los métodos de la implementación de servicio del tipo de producto.
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    private static final Logger log = LoggerFactory.getLogger(ProductTypeServiceImpl.class);

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    public Single<ProductType> insert(ProductType productType) {
        return Single.just(productTypeDao.insert(productType));
    }

    @Override
    public Single<ProductType> update(ProductType productType) {
        Optional<ProductType> finded = productTypeDao.findById(productType.getId());
        if (finded.isPresent()) {
            return Single.just(productTypeDao.save(productType));
        } else {
            return Single.error(new RuntimeException("No existe el tipo de producto"));
        }
    }

    @Override
    public Single<ProductType> delete(String id) {
        Optional<ProductType> finded = productTypeDao.findById(id);
        if (finded.isPresent()) {
            productTypeDao.deleteById(id);
            return Single.just(finded.get());
        } else {
            return Single.error(new RuntimeException("No existe el tipo de producto"));
        }
    }

    @Override
    public Single<ProductType> find(String id) {
        Optional<ProductType> finded = productTypeDao.findById(id);
        if (finded.isPresent()) {
            return Single.just(finded.get());
        } else {
            return Single.error(new RuntimeException("No existe el tipo de producto"));
        }
    }

    @Override
    public Single<ProductType> findByCode(String code) {
        Optional<ProductType> finded = productTypeDao.findByCode(code);
        if (finded.isPresent()) {
            return Single.just(finded.get());
        } else {
            return Single.error(new RuntimeException("No existe el tipo de producto"));
        }
    }

    @Override
    public Observable<ProductType> findAll() {
        return Observable.fromIterable(productTypeDao.findAll());
    }

}
