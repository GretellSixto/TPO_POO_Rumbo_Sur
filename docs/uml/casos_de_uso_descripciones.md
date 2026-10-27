# Sistema de Gestión «Rumbo Sur»
## Descripción de Diagrama de Casos de Uso
### CU01 — Crear Reserva
- **Actor:** Cliente.
- **Precondición:** Cliente titular registrado y salida «Programada» con cupo disponible.
- **Flujo principal:**
  * El vendedor ingresa el DNI del titular y selecciona la salida del catálogo.
  * El sistema valida cupo disponible (<<include>> ) e ingresa a los pasajeros.
  * El sistema calcula precio (<<include>>) y evalúa promociones (<<extend>>).
  * Guarda la reserva como «Pendiente», bloquea cupos y solicita seña del 30%.
- **Flujos alternativos:**
  * Cupo insuficiente: El sistema advierte falta de plazas y cancela la operación.
  * Pasajero no cumple edad mínima en Aventura: El sistema rechaza al pasajero y solicita corregir datos.

### CU02 — Registrar Pago de Reserva
- **Actor:** Vendedor 
- **Precondición:** Reserva registrada con saldo deudor pendiente.
- **Flujo Principal:**
  * El vendedor busca la reserva e ingresa monto y medio de pago.
  * Si es tarjeta en cuotas, aplica el 7% de recargo.
  * Registra el pago, emite comprobante y descuenta el saldo pendiente.
  * Si los pagos cubren al menos el 30% de seña, confirma la reserva.
- **Flujos Alternativos:**
  * Pago con tarjeta denegado: El sistema notifica rechazo y solicita medio de pago alternativo.

### CU03 — Cancelar Reserva
- **Actor:** Vendedor
- **Precondición:** Reserva activa y no finalizada.
- **Flujo Principal:**
  * Se solicita anulación de reserva (por cliente o por vencimiento de 10 días sin saldo).
  * El sistema calcula el porcentaje de reintegro según anticipación.
  * Emite la Nota de Ajuste inmutable con reembolso y retención.
  * Cambia estado a «Anulada» y libera los cupos en la salida.
- **Flujos Alternativos:**
  * Cancelación con menos de 7 días: El reintegro es 0%, se emite nota por $0 y se liberan las plazas.

### CU04 — Asignar Guía y Vehículo a Salida
- **Actor:** Coordinador de Operaciones
- **Precondición:** Salida programada y recursos registrados en el sistema.
- **Flujo Principal:**
  * El coordinador selecciona la salida programada.
  * Elige un guía y el sistema valida su habilitación y disponibilidad.
  * Elige un vehículo y el sistema valida su capacidad de asientos.
  * Confirma la asignación de recursos a la salida.
- **Flujos Alternativos:**
  * Guía no habilitado o superpuesto: El sistema rechaza la designación y solicita elegir otro profesional.
  * Vehículo con capacidad menor al cupo: El sistema deniega el móvil y exige asignar uno de mayor capacidad.

### CU05 — Iniciar Salida
- **Actor:** Coordinador de Operaciones
- **Precondición:** Fecha de inicio alcanzada, guía asignado y lista emitida.
- **Flujo Principal:**
  * Verifica guía asignado y emisión de lista oficial de pasajeros (RN-14).
  * El coordinador autoriza la partida del contingente.
  * Actualiza el estado de la salida a «En Curso».
- **Flujos Alternativos:**
  * Falta guía o lista oficial: El sistema bloquea el inicio de la salida hasta subsanar requisitos.
    
### CU06 — Cerrar Salida y Liquidar Honorarios a Guías
- **Actor:** Coordinador de Operaciones 
- **Precondición:** Salida en estado «En Curso» que ha finalizado su itinerario.
- **Flujo Principal:**
  * El coordinador asienta el regreso y pasa la salida a «Finalizada».
  * Calcula honorarios básicos: Días trabajados * tarifa diaria.
  * Suma el 5% del valor total de adicionales vendidos en la salida.
  * Genera el comprobante de liquidación para abono por parte de administración.

## Relaciones UML observadas
- **`<<include>>`**: comportamiento obligatorio reutilizado por otro caso de uso, según la relación del diagrama.
- **`<<extend>>`**: comportamiento opcional o condicionado que amplía un caso base.
- **Control Vencimientos** aparece asociado al actor de sistema Temporizador.

