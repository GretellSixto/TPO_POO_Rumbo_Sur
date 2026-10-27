# 1. Análisis del Enunciado: Agencia Rumbo Sur

## 1.1 Contexto
La agencia de turismo «Rumbo Sur» organiza tours y excursiones con salidas programadas en la región. El sistema resuelve la administración de catálogo, programación de salidas con cupos, registro de reservas de pasajeros con esquemas tarifarios, control de liquidación a guías y reportes gerenciales.

## 1.2 Identificación de Actores del Sistema
### Cliente (Primario)
Persona que contrata los servicios turísticos, actúa como titular de la reserva, declara los pasajeros acompañantes, realiza la seña, completa los pagos y gestiona modificaciones o cancelaciones.

### Vendedor (Primario)
Miembro del personal de la agencia responsable de asesorar al cliente, confeccionar y dar de alta la reserva, registrar los pagos y percibir comisiones por ventas efectivas.

### Guía de Turismo (Primario)
Profesional asignado a una salida según su habilitación de categoría e idiomas. Recibe la lista oficial de pasajeros con restricciones médicas/alimentarias, lidera la excursión y cobra honorarios diarios más porcentaje de adicionales.

### Coordinador de Operaciones (Primario)
Responsable operativo que programa las salidas, asigna guías habilitados y vehículos con capacidad adecuada, emite la lista oficial de pasajeros para el inicio del tour y formaliza el cierre de la salida.

### Administrador del Sistema (Primario)
Encargado de la gestión integral del catálogo de tours (itinerarios, actividades, tarifas por temporada), parametriza políticas comerciales y emite reportes gerenciales de ocupación, ventas e ingresos.

### Proveedor Externo (Secundario)
Hoteles, restaurantes y empresas de transporte que brindan servicios tercerizados en las actividades de los tours.

### Temporizador / Cron del Sistema (Sistema)
Módulo automático que evalúa periódicamente: a 10 días de la salida el pago total del saldo (o anula la reserva liberando cupos) y a 7 días el cupo mínimo de la salida (o cancela la salida con reintegro del 100%).


