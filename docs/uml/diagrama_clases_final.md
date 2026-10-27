# Diagrama de Clases Final
<img width="1892" height="1247" alt="diagrama_clases_final" src="https://github.com/user-attachments/assets/0cd0b504-3c59-4a46-8bf0-df7a402188d9" />

## CAMBIOS RESPECTO DE LA VERSIÓN INICIAL
**1. Incorporación de Enums con Comportamiento:** Se implementó TipoPasajero como un enum con campos y métodos que encapsula el porcentaje de cobro (ADULTO: 1.0, MENOR_12: 0.6, MENOR_3: 0.0, JUBILADO: 0.9), eliminando números mágicos.

**2. Aplicación de Inmutabilidad:** La clase NotaDeAjuste se diseñó como inmutable (public final class, atributos private final, sin setters y con constructor defensivo), asegurando que los comprobantes contables no puedan ser adulterados en memoria (visto en la clase de Clases Inmutables).

**3. Desacoplamiento mediante el Patrón Strategy (OCP):** Se introdujo la interfaz EstrategiaPromocion y sus clases derivadas para eliminar condicionales de descuentos en Reserva.

**4. Controladores GRASP:** Se añadieron explícitamente ControladorReserva y ControladorOperaciones para no sobrecargar las entidades del modelo.
