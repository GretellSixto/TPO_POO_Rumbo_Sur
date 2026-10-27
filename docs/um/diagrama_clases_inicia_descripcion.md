# Diagrama de Clases Inicial del Sistema
## Identificación de Clases, Atributos, Métodos y Visibilidad
El modelo inicial de la agencia «Rumbo Sur» modela el dominio operativo y comercial utilizando tipos primitivos y enumerados de Java, respetando visibilidad privada (-) para los atributos y pública (+) para las operaciones:

### Persona (Clase Base / Abstracta):
**Atributos:** - legajo: String, - nombre: String, - documento: String, - telefono: String
**Métodos:** + Persona(legajo: String, nombre: String, documento: String, telefono: String), + getDocumento(): String, + getNombre(): String

### Cliente (hereda de Persona):
**Atributos:** - apellido: String, - correo: String, - paisResidencia: String
**Métodos:** + getNombreCompleto(): String

### Vendedor (hereda de Persona):
**Atributos:** - porcentajeComision: double
**Métodos:** + getPorcentajeComision(): double

### Guia (hereda de Persona):
**Atributos:** - idiomas: List<String>, - categoriasHabilitadas: List<CategoriaTour>, - honorarioPorDia: double
**Métodos:** + estaHabilitadoPara(cat: CategoriaTour): boolean, + getHonorarioPorDia(): double

### Vehiculo:
**Atributos:** - patente: String, - capacidad: int, - tipo: TipoVehiculo (Enum: MICRO, COMBI, CAMIONETA)
**Métodos:** + getCapacidad(): int, + getPatente(): String

### Tour (Clase Abstracta):
**Atributos:** - codigo: String, - nombre: String, - descripcion: String, - duracionDias: int, - cupoMinimo: int, - cupoMaximo: int
**Métodos:** + abstract validarAptitud(pasajero: Pasajero, fechaSalida: LocalDate): boolean, + getDuracionDias(): int, + getCupoMinimo(): int, + getCupoMaximo(): int

### TourAventura (subclase de Tour):
**Atributos:** - edadMinima: int, - nivelDificultad: String
**Métodos:** + @Override validarAptitud(pasajero: Pasajero, fechaSalida: LocalDate): boolean (Valida que la edad del pasajero a la fecha de salida sea >= edadMinima, según SUP01)

### TourCultural (subclase de Tour):
**Atributos:** - sitiosHistoricos: List<String>
**Métodos:** + @Override validarAptitud(pasajero: Pasajero, fechaSalida: LocalDate): boolean (Siempre retorna true: apto para todo público)

### TourNaturaleza (subclase de Tour):
Atributos: - parqueNacional: String
Métodos: + @Override validarAptitud(pasajero: Pasajero, fechaSalida: LocalDate): boolean (Siempre retorna true)

### Salida:
**Atributos:** - fechaInicio: LocalDate, - fechaFin: LocalDate, - cupoMaximo: int, - estado: EstadoSalida (Enum: PROGRAMADA, CONFIRMADA, COMPLETA, EN_CURSO, FINALIZADA, CANCELADA)
**Métodos:** + asignarGuia(guia: Guia): void, + asignarVehiculo(vehiculo: Vehiculo): void, + hayCupoDisponible(cantidad: int): boolean, + cerrarSalida(): void

### Reserva:
**Atributos:** - numero: long, - fecha: LocalDate, - estado: EstadoReserva (Enum: PENDIENTE, CONFIRMADA, ANULADA, FINALIZADA), - total: double
**Métodos:** + agregarPasajero(pasajero: Pasajero): void, + calcularTotal(temporada: Temporada): double, + registrarPago(monto: double, medio: MedioPago): Pago, + verificarSaldoCancelado(): boolean

### Pasajero:
**Atributos:** - nombre: String, - documento: String, - fechaNacimiento: LocalDate, - tipo: TipoPasajero (Enum: ADULTO, MENOR_12, MENOR_3, JUBILADO con factor de tarifa), - contactoEmergencia: String, - restriccionesSaludAlimenticias: String
**Métodos:** + calcularEdad(fechaRef: LocalDate): int, + getTipo(): TipoPasajero

### ServicioAdicional:
**Atributos:** - nombre: String, - precio: double, - obligatorio: boolean
**Métodos:** + getPrecio(): double

### Pago:
**Atributos:** - id: String, - fecha: LocalDate, - importe: double, - medio: MedioPago (Enum: EFECTIVO, TRANSFERENCIA, TARJETA)
**Métodos:** + getImporte(): double

## Relaciones y Multiplicidades
**- Generalización / Herencia:** Persona es superclase de Cliente, Vendedor y Guia. Tour es superclase abstracta de TourAventura, TourCultural y TourNaturaleza.
**- Composición:** Reserva compone Pasajero (1 a 1..) y compone sus registros de Pago (1 a 0..). Si una reserva se anula o destruye, la conformación interna de ítems y pagos pertenece exclusivamente a su ciclo de vida.
**- Agregación:** Salida agrega un Guia (0..1) y un Vehiculo (0..1). El guía y el vehículo existen independientemente de la salida. Tour agrega Itinerario / Actividad.
**- Asociación:** Cliente realiza Reserva (1 a 0..); Vendedor confecciona Reserva (1 a 0..); Reserva corresponde a una Salida (0..* a 1); Salida corresponde a un Tour (0..* a 1).
