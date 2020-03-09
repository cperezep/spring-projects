/**
 * 
 */
package com.spring.ereservation.resources.dto;

import lombok.Data;

/**
 * DTO Data Transfer Object
 * 
 * Una de las problemáticas más comunes cuando desarrollamos aplicaciones, es
 * diseñar la forma en que la información debe viajar desde la capa de servicios
 * a las aplicaciones o capa de presentación, lo que ocasiona que retornemos más
 * datos de los necesarios o incluso, tengamos que ir en más de una ocasión a la
 * capa de servicios para recuperar los datos requeridos.
 * 
 * 
 * El patrón DTO tiene como finalidad de crear un objeto plano (POJO) con una
 * serie de atributos que puedan ser enviados o recuperados del servidor en una
 * sola invocación, de tal forma que un DTO puede contener información de
 * múltiples fuentes o tablas y concentrarlas en una única clase simple.}
 * 
 * Caracteristicas DTO:
 * Solo lectura
 * Serializable
 * 
 * @author cristian.perez
 *
 */
@Data
public class CustomerDTO {
	private String identification;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
}
