package com.hospedes.hospedes.resources;

import java.util.Date;
import java.util.GregorianCalendar;
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

import com.hospedes.hospedes.models.CheckIn;
import com.hospedes.hospedes.repository.CheckInRepository;

@RestController
@RequestMapping(value="/api")
public class CheckInResorces {
	
	@Autowired
	CheckInRepository checkInRepository;
	
	@GetMapping("/checkin")
	public List<CheckIn> listaCheckIn() {
		return checkInRepository.findAll();
	}
	
	@GetMapping("/checkin/{id}")
	public CheckIn getCheckin(@PathVariable(value="id") long id) {
		return checkInRepository.findById(id);
	}
	
	@PostMapping("/checkin")
	public CheckIn salvaCheckIn(@RequestBody CheckIn checkIn) {
		return checkInRepository.save(checkIn);
	}
	
	@DeleteMapping("/checkin")
	public void deleteHospede(@RequestBody CheckIn checkIn) {
		checkInRepository.delete(checkIn);
	}
	
	@PutMapping("/checkin")
	public CheckIn atualizaHospede(@RequestBody CheckIn checkIn) {
		return checkInRepository.save(checkIn);
	}
	
	@GetMapping("/checkin/buscar")
	public List<CheckIn> consultaHospedes(long hospedeId,
										Boolean inCheckIn) {
		List<CheckIn> hospedes;
		if(inCheckIn) {
			hospedes = checkInRepository.findInCheckIn(hospedeId);
		} else {
			hospedes = checkInRepository.findNotCheckIn(hospedeId);
		}
		
		setDiarias(hospedes);
		return hospedes;
	}
	
	private void setDiarias(List<CheckIn> hospedes) {
		GregorianCalendar gc = new GregorianCalendar();
		Double totalDiarias = 0.0;
		
        for (CheckIn checkIn : hospedes) {
			gc.setTime(checkIn.getDataEntrada());
			Date dtEntrada = checkIn.getDataEntrada();
			Date dtSaida = checkIn.getDataSaida();
			long dias = dtSaida.getTime() - dtEntrada.getTime() + 3600000;
			dias = dias/86400000L;
			int dia = gc.get(GregorianCalendar.DAY_OF_WEEK);
			Double diaria = 0.0;
			for (int i = 1; i <= dias; i++) {
				if(dia > 7) dia = 1;
				if(dia > 1 && dia < 7) {
					diaria = diaria+120.00;
					 if(checkIn.isVeiculo()) diaria = diaria+15.00;
				}else {
					diaria = diaria+150.00;
					if(checkIn.isVeiculo()) diaria = diaria+15.00;
				}
				dia++;
			}
			totalDiarias += diaria;
			checkIn.setTotalDiaria(diaria);
			checkIn.setQtddias(dias);
			checkIn.setTotalDiarias(totalDiarias);
		}
	}
}
