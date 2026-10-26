# Requerimientos Funcionales - Agencia Rumbo Sur

##- RF01 
El sistema debe permitir dar de alta, modificar y consultar tours con su código, nombre, descripción, duración en días, categoría (Aventura, Cultural, Naturaleza), cupo mínimo y máximo.
##- RF02
El sistema debe permitir definir el itinerario de cada tour compuesto por actividades ordenadas por día, horario, lugar, descripción y asociadas a proveedores de servicios de terceros (alojamiento, comidas, traslados) con su CUIT y datos de contacto.
##- RF03 
El sistema debe registrar las tarifas base de cada tour según la temporada (Baja, Media, Alta), con sus respectivas fechas de vigencia.
##- RF04 
El sistema debe permitir al coordinador crear salidas concretas para un tour con fecha de inicio, fecha de fin y estado inicial 'Programada'.
##- RF05
El sistema debe validar que el guía asignado esté habilitado para la categoría del tour, no tenga salidas superpuestas en el mismo período, y que la capacidad del vehículo asignado no sea menor al cupo máximo de la salida.
##- RF06
El sistema debe permitir registrar y consultar clientes con nombre, apellido, documento, teléfono, correo electrónico y país de residencia.
##- RF07
El sistema debe permitir armar una reserva para una salida específica asignada a un vendedor, registrando los datos de cada pasajero (nombre, DNI, fecha de nacimiento, tipo de pasajero, contacto de emergencia y restricciones de salud/alimentarias).
##- RF08
El sistema debe calcular el precio de la reserva sumando las tarifas individuales por tipo de pasajero (Adulto: 100%, Menor < 12 años: 60%, Menor < 3 años: 0%, Jubilado: 90%) sobre la tarifa base de la temporada.
##- RF09
El sistema debe evaluar automáticamente si corresponde 'Reserva Anticipada' (15% con más de 60 días) o 'Grupo' (10% con 6 o más pasajeros), aplicando únicamente la más conveniente para el cliente.
##- RF10
El sistema debe permitir contratar servicios adicionales (opcionales u obligatorios como el seguro en tours de aventura) sumando su costo al total por pasajero.
##- RF11
El sistema debe registrar pagos parciales y confirmar la reserva cuando se abone al menos el 30% del total en concepto de seña.
##- RF12
El sistema debe verificar que el saldo total se cancele hasta 10 días antes de la salida; de lo contrario, debe anular la reserva y reintegrar los cupos a la salida.
##- RF13
El sistema debe confirmar una salida cuando alcance su cupo mínimo, marcarla como 'Completa' al alcanzar su cupo máximo, y cancelarla con devolución del 100% si a 7 días de la fecha no llega al mínimo.
##- RF14
El sistema debe permitir cancelar reservas aplicando el porcentaje de devolución según la anticipación (>30d: 90%, 29-15d: 50%, 14-7d: 20%, <7d: 0%) o 100% si la cancelación es de la agencia, generando una Nota de Ajuste.
##- RF15
El sistema debe permitir sustituir un pasajero por otro hasta 3 días antes de la salida sin costo adicional, verificando aptitud según la categoría del tour.
##- RF16
El sistema debe generar la lista de pasajeros con DNI, contacto de emergencia y restricciones alimentarias/médicas para entregar al guía antes de iniciar la salida.
##- RF17
El sistema debe al finalizar la salida, el coordinador debe cerrarla y el sistema debe liquidar los honorarios del guía calculando: (Días trabajados * Valor honorario por día) + (5% del total de adicionales vendidos en esa salida).
##- RF18
El sistema debe emitir reportes de ocupación por salida, ventas por vendedor, ingresos generados por tour y estadísticas de cancelaciones.
