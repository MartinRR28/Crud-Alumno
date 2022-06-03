package com.example.crudrosales.crud_rosales.service;

import java.util.List;
import java.util.Optional;

import com.example.crudrosales.crud_rosales.entity.alumno;

public interface AlumnoService {

	public abstract List<alumno> listaTodos();
	
	public abstract alumno insertaActualizaAlumno(alumno obj);
	
	public abstract List<alumno> listaAlumnoporDni(String dni);
	
	public abstract List<alumno> listaAlumnoporDniDiferenteDeSiMismo(String dni,int idalumno);
	
	public abstract Optional<alumno> listaporid(int idalumno);
	
	public abstract void eliminarAlumno(int idAlumno);
	
}
