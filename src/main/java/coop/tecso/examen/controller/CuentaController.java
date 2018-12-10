package coop.tecso.examen.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.model.Cuenta;
import coop.tecso.examen.repository.CuentaRepository;
import coop.tecso.examen.repository.MovimientoRepository;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

	@Autowired
	private CuentaRepository cuentaRepository;
	@Autowired
	private MovimientoRepository movimientoRepository;

	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody Cuenta cuenta) {
		Optional<Cuenta> aCrear = cuentaRepository.findById(cuenta.getId());
		if (aCrear.isPresent()) {
			return new ResponseEntity<String>("Ya existe una cuenta con ese Codigo",HttpStatus.CONFLICT);
		} else {
			cuentaRepository.saveAndFlush(cuenta);
			return new ResponseEntity<Cuenta>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Cuenta aBorrar = cuentaRepository.getOne(id);

		if (aBorrar == null) {
			return new ResponseEntity<Cuenta>(HttpStatus.NOT_FOUND);
		} else {
			if(movimientoRepository.findByCuenta(aBorrar).size()==0){
				cuentaRepository.delete(aBorrar);
				return new ResponseEntity<Cuenta>(HttpStatus.OK);
			}else{
				return new ResponseEntity<String>("La Cuenta tiene movimientos asociados. No se Puede Borrar.",
						HttpStatus.CONFLICT);
			}

		}

	}

	@GetMapping("/findAll")
	public List<Cuenta> findAll() {

		List<Cuenta> result = new ArrayList<>();
		for (Cuenta entity : cuentaRepository.findAll()) {
			result.add(entity);
		}

		return result;
	}

}
