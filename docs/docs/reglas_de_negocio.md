# Reglas de Negocio y Supuestos Adoptados

## 1. Reglas de Negocio Obligatorias
### RN01. Categorías y Requisitos de Tours
Existen 3 categorías: Aventura, Cultural y Naturaleza. Los tours de Aventura exigen obligatoriamente una edad mínima para los pasajeros y declaran nivel de dificultad.

### RN02. Ciclo de Estados de Salida 
Una salida transita exclusivamente por los estados: Programada -> Confirmada (al alcanzar cupo mínimo) -> Completa (al llegar a cupo máximo) -> En Curso -> Finalizada, o Cancelada.

### RN03. Regla de los 7 Días para Cupo Mínimo 
Si a 7 días antes de la fecha de inicio la salida no alcanzó su cupo mínimo, se cancela automáticamente y se reintegra el 100% de lo pagado a todos los clientes.

### RN04. Compatibilidad de Guía y Capacidad de Vehículo
Un guía no puede tener salidas superpuestas en las mismas fechas y solo puede ser asignado a tours de categorías para las que está habilitado. El vehículo debe tener capacidad mayor o igual al cupo de la salida.

### RN05. Ocupación de Cupo por Pasajero (Reservas y Precios)
Una reserva pertenece a un cliente titular y a una salida específica. Ocupa tantos lugares del cupo disponible como pasajeros tenga asignados.

### RN06. Tarificación según Pasajero y Temporada
La tarifa base del tour depende de la temporada (baja, media, alta). Cada pasajero abona: Adulto 100%, Menor de 12 años 60%, Menor de 3 años gratis (0%), Jubilado 10% de descuento.

### RN07. Promociones No Acumulativas
Promoción "Reserva Anticipada" (15% si se reserva con >60 días de anticipación) y "Grupo" (10% para 6 o más pasajeros). No se acumulan: se evalúan ambas y se aplica la más favorable al cliente.

### RN08. Servicios Adicionales y Seguro Obligatorio 
Los adicionales (traslados, excursiones, seguro) se suman por pasajero. El seguro de viaje es mandatorio en tours de aventura y opcional en otros.

### RN09. Esquema de Pagos y Confirmación 
Una reserva se confirma abonando una seña del 30%. El saldo restante debe cancelarse hasta 10 días antes de la salida; de lo contrario se anula y los lugares vuelven al cupo. Si se paga con tarjeta en cuotas, aplica recargo del 7%.

### RN10. Escala de Devoluciones por Cancelación
Cancelación solicitada por cliente: >= 30 días antes: 90% reintegro; entre 29 y 15 días: 50%; entre 14 y 7 días: 20%; menos de 7 días: 0%. Cancelación provocada por la agencia: siempre 100%. Reembolso por el mismo medio de pago.

### RN11. Reemplazo de Pasajeros sin Costo
Un pasajero puede ser sustituido por otro hasta 3 días antes de la salida sin costo, siempre que el nuevo cumpla las condiciones (p. ej. edad mínima).

### RN12. Requisitos Previos de Partida de Salida
No se puede iniciar una salida sin guía asignado y sin haber emitido previamente la lista oficial de pasajeros con documento y contacto de emergencia.

### RN13. Liquidación de Honorarios del Guía
Al finalizar la salida, el guía percibe un monto fijo por día trabajado más el 5% del valor total de los servicios adicionales comercializados en esa salida.

### RN14. Inmutabilidad Contable y Notas de Ajuste
Una reserva con pagos no puede borrarse físicamente. Cualquier modificación o anulación se registra mediante notas de ajuste contables.


---

## 2. Supuestos Adoptados
### SUP01. Momento de Validación de la Edad del Pasajero
- **Ambigüedad en el texto:** El enunciado no especifica si la edad para tours de aventura y categorías (menor <3, menor <12) se evalúa a la fecha de reserva o de inicio de la salida.
- **Supuesto adoptado:** La edad de los pasajeros se calcula con respecto a la FECHA DE INICIO DE LA SALIDA y no a la fecha en que se realiza la reserva.

### SUP02. Base de Aplicación del Recargo por Tarjeta en Cuotas (7%)
- **Ambigüedad en el texto:** El texto indica "pagar con tarjeta en cuotas tiene un recargo del 7%", sin aclarar si aplica sobre el pago puntual o sobre el total de la reserva.
- **Supuesto adoptado:** El recargo del 7% se aplica exclusivamente sobre el monto abonado en esa transacción con tarjeta en cuotas, no sobre la totalidad de la reserva.

### SUP03. Base de Cálculo para el Reembolso de Cancelación
- **Ambigüedad en el texto:** No se detalla explícitamente si el porcentaje de devolución (90%, 50%, etc.) aplica sobre el total pagado hasta la fecha o sobre el costo total de la reserva.
- **Supuesto adoptado:** El porcentaje de devolución se aplica sobre el TOTAL EFECTIVAMENTE ABONADO por el cliente hasta el momento de la cancelación.

### SUP04. Vigencia de Tarifas por Temporada
- **Ambigüedad en el texto:** El enunciado menciona tarifas por temporada con fecha de vigencia pero no especifica qué ocurre si la salida cae entre dos temporadas.
- **Supuesto adoptado:** La temporada aplicable a la reserva queda fijada por la FECHA DE INICIO de la salida.

### SUP05. Hora de Corte para el Cómputo de Días de Anticipación
- **Ambigüedad en el texto:** No se especifica a qué hora se considera que vence el plazo de 10 días para el pago del saldo o los plazos de cancelación.
- **Supuesto adoptado:** Se computan días corridos completos de 24 horas exactas antes de las 00:00 hs de la fecha de inicio de la salida.

