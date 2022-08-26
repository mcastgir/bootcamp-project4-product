/**
 * Resumen.
 * Objeto                   : ProductTypeDao.java
 * Descripción              : Clase de interface dao para obtener los datos de la base de datos.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.product.model.dao;

import com.nttdata.bootcamp.product.model.document.ProductType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Clase de interface dao para obtener los datos de la base de datos.
 */
public interface ProductTypeDao extends ReactiveMongoRepository<ProductType, String> {

    /**
     * Método que obtiene los datos del document ProductType
     * @return Mono retorna el ProductType, tipo Mono
     */
    Mono<ProductType> findByCode(String code);

}
