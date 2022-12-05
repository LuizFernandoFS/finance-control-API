package com.luiz.financecontrol.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luiz.financecontrol.domain.RegistroFinanceiro;
import com.luiz.financecontrol.service.RegistroFinanceiroService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/registros")
public class RegistroFinanceiroResource {
	
	@Autowired
	private RegistroFinanceiroService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<RegistroFinanceiro> findById(@PathVariable Integer id) throws Exception {
		RegistroFinanceiro registro = service.findById(id);
		return ResponseEntity.ok().body(registro);
	}

	@GetMapping
	public ResponseEntity<List<RegistroFinanceiro>> findAll() {
		List<RegistroFinanceiro> registros = service.findAll();
		return ResponseEntity.ok().body(registros);
	}

	@PostMapping
	public ResponseEntity<RegistroFinanceiro> create(@RequestBody RegistroFinanceiro obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.
		fromCurrentRequest().
		path("/{id}").
		buildAndExpand(obj.getId())
		.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<RegistroFinanceiro> update(@PathVariable Integer id, @RequestBody RegistroFinanceiro obj) throws Exception{
		RegistroFinanceiro newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	} 

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
