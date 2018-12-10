package coop.tecso.examen.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coop.tecso.examen.model.Cuenta;
import coop.tecso.examen.model.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
	
    @Query("select m from Movimiento m where m.cuenta = :cuenta order by m.fecha desc")
    public List<Movimiento> findByCuenta(@Param("cuenta") Cuenta cuenta);
    
}
