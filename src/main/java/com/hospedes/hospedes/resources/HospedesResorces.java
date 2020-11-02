package com.hospedes.hospedes.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospedes.hospedes.models.Hospede;
import com.hospedes.hospedes.repository.HospedesRepository;

@RestController
@RequestMapping(value="/api")
public class HospedesResorces {
	
	@Autowired
	HospedesRepository hospeRepository;
	
	@GetMapping("/hospedes")
	public List<Hospede> listaHospedes() {
		return hospeRepository.findAll();
	}
	
	@GetMapping("/hospedes/{id}")
	public Hospede getHospede(@PathVariable(value="id") long id) {
		return hospeRepository.findById(id);
	}
	
	@GetMapping("/hospedes/{campo}")
	public List<Hospede> getHospedes(@PathVariable(value="campo") String campo) {
		return hospeRepository.findByNomeDocFone(campo);
	}
	
	@PostMapping("/hospedes")
	public Hospede salvaHospede(@RequestBody Hospede hospede) {
		return hospeRepository.save(hospede);
	}
	
	@DeleteMapping("/hospedes")
	public void deleteHospede(@RequestBody Hospede hospede) {
		hospeRepository.delete(hospede);
	}
	
	@PutMapping("/hospedes")
	public Hospede atualizaHospede(@RequestBody Hospede hospede) {
		return hospeRepository.save(hospede);
	}
}
