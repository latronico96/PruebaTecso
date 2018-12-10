#Descargando el repositorio:

	- git clone git@gitlab.tecso.coop:tecso-public/test-spring-boot-level-1.git


#Para ejecutar la aplicacion utilizando Maven:

	mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=dev"
	
	
#Probando controllers:


	Todas las Cuentas:
		curl -X GET localhost:8080/api/cuenta/findAll
	
	Crear Una cuenta:
		curl -X POST -H "Content-Type: application/json" -d "{\"id\":\"2\",\"moneda\":\"Pesos\", \"saldo\": \"0\"}" localhost:8080/api/cuenta

	Borrar la cuenta "2": (Si no tiene movientos Asociados)
		curl -X DELETE localhost:8080/api/cuenta/2
		
	Todos los Movimientos de la cuenta "4": 
		curl -X GET localhost:8080/api/movimiento/findAll/4
	
	Crear un Movimiento:
		curl -X POST -H "Accept: application/json" -H "Content-Type: application/json" -d 
	"{\"cuenta\": \"4\",\"fecha\": \"2012-09-01T14:36:35.000\",\"descripcion\": \"Movimiento 03\",\"importe\": \"150\",\"tipo\":\"Haber\",\"description\": \"descripcion bla bla\"}"
	 http://localhost:8080/api/movimiento
