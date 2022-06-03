package com.example.crudrosales.crud_rosales.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudrosales.crud_rosales.entity.alumno;
import com.example.crudrosales.crud_rosales.service.AlumnoService;

@RestController
@RequestMapping("/rest/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<alumno>> listartodos(){
		return ResponseEntity.ok(service.listaTodos());
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> insertaAlumno(@RequestBody alumno obj){
		HashMap<String, Object> salida = new HashMap<String,Object>();
		
		try {
			
			List<alumno> lstAlumno = service.listaAlumnoporDni(obj.getDni());
			
			if (CollectionUtils.isEmpty(lstAlumno)) {
				obj.setIdAlumno(0);
				alumno objSalida = service.insertaActualizaAlumno(obj);
				if (objSalida==null) {
						
					salida.put("Mensaje", "Registro Fallido");
				} else {
					
					salida.put("Mensaje", "Registro Exitoso");					
				}				
			} else {
				salida.put("Mensaje", "El dni ya existe :" + obj.getDni());
			}	
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("Mensaje", "Error en el Registro" + e.getMessage());
			
		}
		return ResponseEntity.ok(salida);
		
	}
	
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> actualizarAlumno(@RequestBody alumno obj){
		HashMap<String, Object> salida = new HashMap<String,Object>();
		
		try {
			
		Optional<alumno> opcion =	service.listaporid(obj.getIdAlumno());
		
			if(opcion.isPresent()) {
				List<alumno> lstAlumno = service.listaAlumnoporDniDiferenteDeSiMismo(obj.getDni(), obj.getIdAlumno());
				
				if (CollectionUtils.isEmpty(lstAlumno)) {
					alumno objSalida = service.insertaActualizaAlumno(obj);
					if (objSalida==null) {
							
						salida.put("Mensaje", "Actualización Fallida");
					} else {
						
						salida.put("Mensaje", "Actualización Exitosa");					
					}				
					
				} else {
					salida.put("Mensaje", "El DNI ya existe :" + obj.getDni());
				}
			
			}else {
				salida.put("Mensaje", "El id no existe :" + obj.getIdAlumno());
		   }
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("Mensaje", "Error en la actualización " + e.getMessage());
			
		}
		return ResponseEntity.ok(salida);
		
	}
	
	
	@DeleteMapping("/dni/{id}")
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> EliminarAlumno(@PathVariable int id){
		HashMap<String, Object> salida = new HashMap<String,Object>();
		
		try {
			Optional<alumno> opcion = service.listaporid(id);
			if (opcion.isPresent()) {				
				service.eliminarAlumno(id);
				salida.put("Mensaje", "Eliminación Exitosa");				
			} else {
				salida.put("Mensaje", "El id no existe :" + id);
			}		
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("Mensaje", "Error en la eliminación " + e.getMessage());		
		}
		return ResponseEntity.ok(salida);
		
	}
	
	
	@GetMapping("/dni/{dni}")
	@ResponseBody
	public ResponseEntity<List<alumno>> listarAlumnosPorDni(@PathVariable String dni){
		List<alumno> lstAlumpoDni = service.listaAlumnoporDni(dni);
		return ResponseEntity.ok(service.listaAlumnoporDni(dni));
	}
}
