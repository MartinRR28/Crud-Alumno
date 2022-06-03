package com.example.crudrosales.crud_rosales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.crudrosales.crud_rosales.entity.alumno;



public interface AlumnoRepository extends JpaRepository<alumno, Integer>{

	@Query("select a from alumno a where a.dni = ?1")
	public List<alumno> listaporDni(String dni);
			
	@Query("select a from alumno a where a.dni = ?1 and a.id <> ?2")
	public List<alumno> listaporDniDiferenteSiMis(String dni,int idalumno);
}
