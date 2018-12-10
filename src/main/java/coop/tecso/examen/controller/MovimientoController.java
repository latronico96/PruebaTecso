package coop.tecso.examen.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.model.Cuenta;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.repository.CuentaRepository;
import coop.tecso.examen.repository.MovimientoRepository;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {

	@Autowired
	private MovimientoRepository movimientoRepository;
	@Autowired
	private CuentaRepository cuentaRepository;

	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody MovimientoDto mvPar) {
		System.out.println(mvPar.toString());
		Movimiento mv = new Movimiento();

		Optional<Cuenta> cnt = cuentaRepository.findById(mvPar.getCuenta());
		if (cnt.isPresent()) {
			mv.setCuenta(cnt.get());
			mv.setDescripcion(mvPar.getDescripcion());
			mv.setFecha(mvPar.getFecha());
			mv.setImporte(mvPar.getImporte());
			if ( !mvPar.getTipo().equals(Movimiento.Tipo.Debe.toString()) && !mvPar.getTipo().equals(Movimiento.Tipo.Haber.toString()) ) {
				return new ResponseEntity<String>("\""+mvPar.getTipo()+"\" es un tipo incorecto de movimiento.", HttpStatus.PRECONDITION_FAILED);
			} else if ((cnt.get().getMoneda().equals(Cuenta.Monedas.Dolares) && mv.getImporte() > 300d)
					|| (cnt.get().getMoneda().equals(Cuenta.Monedas.Euros) && mv.getImporte() > 150d)
					|| (cnt.get().getMoneda().equals(Cuenta.Monedas.Pesos) && mv.getImporte() > 1000d)) {				
				return new ResponseEntity<String>("Ha sobre pasado el limite de esta moneda.", HttpStatus.PRECONDITION_FAILED);
			} else {
				mv.setTipo(Movimiento.Tipo.valueOf(mvPar.getTipo()));
				Double importe = mv.getImporte();
				importe *= ( mv.getTipo().equals(Movimiento.Tipo.Debe) ? 1 : -1); 
				cnt.get().setSaldo(cnt.get().getSaldo()+importe);
				cuentaRepository.saveAndFlush(cnt.get());
				movimientoRepository.saveAndFlush(mv);
				return new ResponseEntity<Movimiento>(mv,HttpStatus.OK);
			}

		} else {
			return new ResponseEntity<Cuenta>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/findAll/{cuenta}")
	public List<MovimientoDto> findAll(@PathVariable Long cuenta) {

		Optional<Cuenta> objCuenta = cuentaRepository.findById(cuenta);
		
		List<Movimiento> movimientos = movimientoRepository.findByCuenta(objCuenta.get());
		List<MovimientoDto> result = new ArrayList<MovimientoDto>();
		
		for (Iterator iterator = movimientos.iterator(); iterator.hasNext();) {
			Movimiento movimiento = (Movimiento) iterator.next();
			System.out.println(movimiento.toString());
			MovimientoDto mvt = new MovimientoDto();
			mvt.setCuenta(movimiento.getCuenta().getId());
			mvt.setDescripcion(movimiento.getDescripcion());
			System.out.println(movimiento.getDescripcion());
			mvt.setFecha(movimiento.getFecha());
			mvt.setImporte(movimiento.getImporte());
			mvt.setTipo(movimiento.getTipo().toString());
			result.add(mvt);			
		}
		return result;
	}

}
