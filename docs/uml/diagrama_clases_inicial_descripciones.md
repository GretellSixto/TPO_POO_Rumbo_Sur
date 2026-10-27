# Diagrama de Clases Inicial del Sistema

## IDENTIFICACION DE CLASES, ATRIBUTOS, MÉTODOS Y VISIBILIDAD
El modelo inicial de la agencia «Rumbo Sur» se modela utilizando tipos primitivos y enumerados de Java. Se aplican modificadores de acceso UML: privado (-) para los atributos y público (+) o protegido (#) para los métodos y constructores.

## 1. Persona (Clase Abstracta base de personal y clientes):
**Atributos:** # legajo: String, # nombre: String, # documento: String, # telefono: String

**Métodos:** + Persona(legajo: String, nombre: String, documento: String, telefono: String), + getDocumento(): String, + getNombre(): String, + getTelefono(): String

## 2. Cliente (hereda de Persona):
**Atributos:** - apellido: String, - correo: String, - paisResidencia: String
  
**Métodos:** + Cliente(...), + getApellido(): String, + getCorreo(): String, + getNombreCompleto(): String

## 3. Vendedor (hereda de Persona):
**Atributos:** - comisionPorcentaje: double
  
**Métodos:** + Vendedor(...), + getComisionPorcentaje(): double

## 4. Guia (hereda de Persona):
**Atributos:** - idiomas: List<String>, - categoriasHabilitadas: List<CategoriaTour>, - honorarioPorDia: double
  
**Métodos:** + estaHabilitadoPara(cat: CategoriaTour): boolean, + getHonorarioPorDia(): double

## 5. Vehiculo:
**Atributos:** - patente: String, - capacidad: int, - tipo: TipoVehiculo
  
**Métodos:** + Vehiculo(patente: String, capacidad: int, tipo: TipoVehiculo), + getCapacidad(): int, + getPatente(): String

## 6. Tour (Clase Abstracta):
**Atributos:** # codigo: String, # nombre: String, # descripcion: String, # duracionDias: int, # cupoMinimo: int, # cupoMaximo: int

**Métodos:** + Tour(...), + {abstract} validarAptitud(pasajero: Pasajero, fechaSalida: LocalDate): boolean, + getDuracionDias(): int, + getCupoMinimo(): int, + getCupoMaximo(): int, + getCodigo(): String

## 7. TourAventura (subclase de Tour):
**Atributos:** - edadMinima: int, - nivelDificultad: String

**Métodos:** + @Override validarAptitud(pasajero: Pasajero, fechaSalida: LocalDate): boolean (Evalúa según SUP01 que la edad del pasajero a la fecha de inicio sea ≥ edadMinima)

## 8. TourCultural (subclase de Tour):
**Atributos:** - sitiosHistoricos: List<String>

**Métodos:** + @Override validarAptitud(pasajero: Pasajero, fechaSalida: LocalDate): boolean (Retorna true: apto para todas las edades)

## 9. TourNaturaleza (subclase de Tour):
**Atributos:** - parqueNacional: String

**Métodos:** + @Override validarAptitud(pasajero: Pasajero, fechaSalida: LocalDate): boolean (Retorna true: apto para todas las edades)

## 10. Salida:
**Atributos:** - idSalida: String, - fechaInicio: LocalDate, - fechaFin: LocalDate, - cupoMaximo: int, - estado: EstadoSalida

**Métodos:** + asignarGuia(guia: Guia): void, + asignarVehiculo(vehiculo: Vehiculo): void, + hayCupoDisponible(cantidad: int): boolean, + reservarLugares(cantidad: int): void, + liberarLugares(cantidad: int): void, + cerrarSalida(): void

## 11. Reserva:
**Atributos:** - numero: long, - fecha: LocalDate, - estado: EstadoReserva, - total: double

**Métodos:** + agregarPasajero(p: Pasajero): void, + calcularTotal(): double, + registrarPago(monto: double, medio: MedioPago): void, + getTotalAbonado(): double, + getSaldoPendiente(): double, + cancelarReserva(motivo: String): void

## 12. Pasajero:
**Atributos:** - nombre: String, - documento: String, - fechaNacimiento: LocalDate, - tipo: TipoPasajero, - contactoEmergencia: String, - restriccionesSalud: String

**Métodos:** + calcularEdad(fechaRef: LocalDate): int, + getTipo(): TipoPasajero, + getDocumento(): String

## 13. ServicioAdicional:
**Atributos:** - nombre: String, - precio: double, - obligatorio: boolean

**Métodos:** + getPrecio(): double, + isObligatorio(): boolean
  
## 14. Pago:
**Atributos:** - idTransaccion: String, - fecha: LocalDate, - importe: double, - medio: MedioPago

**Métodos** + getImporte(): double, + getMedio(): MedioPago

# RELACIONES Y MULTIPLICIDADES

**Generalización / Herencia:** 
* Persona ← Cliente, Vendedor, Guia: Especializan los roles humanos de la empresa reutilizando atributos comunes.
* Tour ←TourAventura, TourCultural, TourNaturaleza: Jerarquía polimórfica que sobreescribe la regla de validación de aptitud de los pasajeros (validarAptitud).
  
**Composición (⧫):** 
* Reserva contiene Pasajero (multiplicidad 1 a 1..*): Un pasajero en el contexto de una reserva no tiene sentido si esta no existe.
* Reserva contiene Pago (multiplicidad 1 a 0..*): El historial de cobros pertenece al ciclo de vida de la reserva.

**Agregación:** 
* Salida agrega Guia (0..* a 0..1): El guía es asignado a la salida, pero su ciclo de vida es independiente.
* Salida agrega Vehiculo (0..* a 0..1): El vehículo existe en el inventario antes y después de la salida.

**Asociación:** 
* Cliente a Reserva (1 a 0..*): El cliente actúa como titular.
* Vendedor a Reserva (1 a 0..*): El vendedor genera y gestiona la venta.
* Salida a Tour (0..* a 1): Cada salida corresponde a un tour específico del catálogo.
* Reserva a Salida (0..* a 1): Cada reserva reserva plazas de una salida programada.
