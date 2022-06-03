package com.example.crudrosales.crud_rosales.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="alumno")
public class alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int idAlumno;
	private String nombre;
	private String dni;
	private String correo;
	
	@Temporal(TemporalType.DATE)
	private Date fechana;	
}
