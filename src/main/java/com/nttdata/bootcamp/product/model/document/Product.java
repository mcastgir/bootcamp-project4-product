/**
 * Resumen.
 * Objeto                   : Product.java
 * Descripción              : Clase de tipo document para obtener o establecer los datos de cada atributo.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un campo nuevo.
 */

package com.nttdata.bootcamp.product.model.document;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de tipo document para obtener o establecer los datos de cada atributo.
 */
@Data
@ToString
@Document(collection="product")
public class Product {

    /** Identificador del Producto */
    @Id
    private String id;

    /** Código de Producto */
    private String code;

    /** Nombre de Producto */
    private String name;

    /** Descripción de Producto */
    private String description;

    /** Código de Tipo de Producto */
    private String codeProductType;

    /** Control de Movimiento */
    private boolean movementControl;

    /** Cantidad Máxima de Movimiento */
    private int movementCountMax;

    /** Monto de Comisión */
    private double monthlyCommission;
    private boolean state;

}
