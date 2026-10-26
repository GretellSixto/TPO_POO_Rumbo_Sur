# Requerimientos Funcionales - Agencia Rumbo Sur

## RF01. Administración de Catálogo de Tours
- **Actor Principal:** Administrador
- **Prioridad:** Alta
- **Descripción:** El sistema debe permitir dar de alta, modificar y consultar tours con su código, nombre, descripción, duración en días, categoría (aventura, cultural, naturaleza), itinerario por actividades y cupos mín/máx.

## RF02. Gestión de Tarifas por Temporada
- **Actor Principal:** Administrador
- **Prioridad:** Alta
- **Descripción:** Permitir fijar tarifas base por persona para cada tour según temporada (baja, media, alta) con su período de vigencia.

## RF03. Programación de Salidas
- **Actor Principal:** Coordinador de Operaciones
- **Prioridad:** Alta
- **Descripción:** Programar salidas concretas para un tour indicando fecha de inicio, fecha de fin, cupo máximo, guía habilitado y vehículo disponible.

## RF04. Registro de Clientes y Creación de Reservas
- **Actor Principal:** Vendedor
- **Prioridad:** Alta
- **Descripción:** Registrar datos del cliente titular e iniciar una reserva para una salida determinada, incluyendo uno o más pasajeros.

## RF05. Cálculo Automático de Precios y Promociones
- **Actor Principal:** Sistema
- **Prioridad:** Alta
- **Descripción:** Calcular el total de la reserva según la tarifa de temporada del tour, tipo de pasajero (Adulto 100%, Menor <12 60%, Menor <3 gratis, Jubilado 10% desc), y aplicar la mejor promoción no acumulable (Reserva anticipada >60 días 15% o Grupo >=6 pax 10%).

## RF06. Contratación de Servicios Adicionales
- **Actor Principal:** Vendedor / Cliente
- **Prioridad:** Alta
- **Descripción:** Permitir asociar servicios adicionales (traslados, excursiones opcionales, seguro de viaje) a cada pasajero. Validar que el seguro de viaje es obligatorio si el tour es de aventura.

## RF07. Registro de Pagos y Confirmación de Reserva
- **Actor Principal:** Vendedor
- **Prioridad:** Alta
- **Descripción:** Registrar la seña obligatoria del 30% para pasar la reserva a estado "Confirmada", y registrar pagos posteriores del saldo (hasta 10 días antes de la salida). Aplicar recargo del 7% si el pago es en cuotas con tarjeta.

## RF08. Cancelación de Reserva y Reembolso Escalonado
- **Actor Principal:** Vendedor / Cliente
- **Prioridad:** Alta
- **Descripción:** Cancelar una reserva registrando fecha y motivo, calculando la devolución automática según política de días (>=30d: 90%, 29-15d: 50%, 14-7d: 20%, <7d: 0%; 100% si cancela la agencia) por el mismo medio de pago.

## RF09. Reemplazo de Pasajeros
- **Actor Principal:** Vendedor
- **Prioridad:** Media
- **Descripción:** Permitir reemplazar un pasajero de la reserva por otro hasta 3 días antes de la fecha de salida sin costo adicional, verificando que cumpla las condiciones (edad mínima en aventura).

## RF10. Control de Cupo y Confirmación/Cancelación de Salida
- **Actor Principal:** Sistema / Coordinador
- **Prioridad:** Alta
- **Descripción:** Monitorear cupo de salida: pasa a "Confirmada" al alcanzar cupo mínimo; pasa a "Completa" al llegar al cupo máximo. Si a 7 días de la salida no alcanza cupo mínimo, cancela la salida y reembolsa 100% a clientes.

## RF11. Emisión de Lista Oficial de Pasajeros
- **Actor Principal:** Coordinador de Operaciones
- **Prioridad:** Alta
- **Descripción:** Generar la lista obligatoria de pasajeros previa a la partida de la salida con documento, contacto de emergencia y restricciones alimentarias o de salud.

## RF12. Cierre de Salida y Liquidación de Guías
- **Actor Principal:** Coordinador / Administrador
- **Prioridad:** Alta
- **Descripción:** Cerrar la salida finalizada y calcular la liquidación del guía asignado: honorario fijo por día * duración en días + 5% del valor total de adicionales vendidos en esa salida.

## RF13. Generación de Reportes Gerenciales
- **Actor Principal:** Administrador
- **Prioridad:** Media
- **Descripción:** Generar reportes analíticos de: ocupación por salida, ventas y comisiones por vendedor, ingresos desglosados por tour y estadísticas de cancelaciones/reembolsos.

## RF14. Gestión de Notas de Ajuste
- **Actor Principal:** Sistema
- **Prioridad:** Media
- **Descripción:** Asegurar que ninguna reserva que haya tenido pagos registrados pueda ser eliminada físicamente de la base de datos; cualquier diferencia económica o cancelación debe registrarse como nota de ajuste contable.
