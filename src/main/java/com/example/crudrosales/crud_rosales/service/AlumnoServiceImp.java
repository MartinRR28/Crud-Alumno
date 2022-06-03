package com.example.crudrosales.crud_rosales.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudrosales.crud_rosales.entity.alumno;
import com.example.crudrosales.crud_rosales.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;

	@Override
	public List<alumno> listaTodos() {

		return repository.findAll();
	}

	@Override
	public alumno insertaActualizaAlumno(alumno obj) {
		
		return repository.save(obj);
	}

	@Override
	public List<alumno> listaAlumnoporDni(String dni) {
	
		return repository.listaporDni(dni);
	}

	@Override
	public List<alumno> listaAlumnoporDniDiferenteDeSiMismo(String dni, int idalumno) {

		return repository.listaporDniDiferenteSiMis(dni, idalumno);
	}

	@Override
	public Optional<alumno> listaporid(int idalumno) {
		
		return repository.findById(idalumno);
	}

	@Override
	public void eliminarAlumno(int idAlumno) {
		repository.deleteById(idAlumno);
		
	}

	

}
