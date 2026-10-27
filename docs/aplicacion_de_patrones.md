# Aplicación de Patrones 

## PRINCIPIOS SOLID 

### 1. Principio de Responsabilidad Única
**- Problema en el diseño inicial:** La clase Reserva concentraba demasiadas razones para cambiar: gestionaba los pasajeros, evaluaba promociones complejas que variaban por estacionalidad, emitía notas contables de reembolso y controlaba el estado operativo de los cupos.

**- Decisión tomada:** Se separó la lógica de cálculo comercial extrayéndola a la clase de servicio CalculadoraPrecios, y la persistencia contable de las devoluciones se delegó en una clase inmutable específica llamada NotaDeAjuste. La clase Reserva únicamente mantiene y coordina su estado de negocio.

**- Clases reflejadas:** Reserva, CalculadoraPrecios, NotaDeAjuste.

**- Ventaja:** Alta cohesión y bajo acoplamiento. Cualquier cambio en las reglas impositivas o en las fórmulas de descuentos no obliga a recompilar ni poner en riesgo la entidad Reserva.

### 2. Principio Abierto/Cerrado
**- Problema en el diseño inicial:** El cálculo de promociones (Reserva Anticipada del 15% o Descuento Grupo del 10%) se resolvía mediante estructuras condicionales if-else encadenadas. Añadir nuevas promociones futuras (como convenios corporativos o CyberMonday) implicaba modificar código existente ya testeado.

**- Decisión tomada:** Se definió la interfaz EstrategiaPromocion con el método double calcularDescuento(Reserva reserva). Se crearon implementaciones concretas: PromocionAnticipada, PromocionGrupo y SinPromocion.

**- Clases donde se refleja:** EstrategiaPromocion, PromocionAnticipada, PromocionGrupo, CalculadoraPrecios.

**- Ventaja:** El sistema queda abierto a la incorporación de nuevas promociones mediante la creación de nuevas clases sin tocar una sola línea del código de facturación ya probado.

### 3. Principio de Sustitución de Liskov
**- Problema en el diseño inicial:** Si Tour obligaba a pedir una edadMinima a todas las categorías, las subclases TourCultural y TourNaturaleza debían lanzar excepciones del tipo UnsupportedOperationException o retornar valores artificiales, rompiendo el contrato de la clase padre.

**- Decisión tomada:** Se diseñó el método polimórfico validarAptitud(Pasajero p, LocalDate fecha) en la clase abstracta Tour. Las subclases TourCultural y TourNaturaleza devuelven coherentemente true respetando la firma y la semántica, mientras que TourAventura aplica la restricción de edad mínima sin sorpresas para el código cliente.
**- Clases donde se refleja:** Tour, TourAventura, TourCultural, TourNaturaleza.
**- Ventaja aportada:** Cualquier cliente que invoque tour.validarAptitud(...) puede operar con cualquier tipo derivado de Tour sin tener que consultar su clase concreta mediante instanceof.

## PATRONES GRASP 

### 1. Information Expert (Experto en Información)
**- Problema detectado:** ¿Quién debe calcular el costo de los servicios adicionales contratados y el descuento según la franja etaria del pasajero?

**- Decisión tomada:** La clase Pasajero conoce su fecha de nacimiento y su tipo (TipoPasajero), por lo tanto, es la Experta en calcular su tarifa individual. A su vez, Reserva tiene la lista completa de pasajeros y servicios asociados, por lo que asume la responsabilidad de totalizar el costo base.

**- Clases donde se refleja:** Pasajero, Reserva, ServicioAdicional.

**- Ventaja:** Se encapsulan los datos sensibles dentro de la entidad que los posee, evitando que clases externas deban exponer o acceder indiscriminadamente a los getters/setters.

### 2. Creator (Creador)
**- Problema detectado:** ¿Qué clase debe ser responsable de instanciar los objetos Pago y asociarlos al registro financiero?

**- Decisión tomada:** Se le asignó a Reserva la creación de las instancias de Pago a través de su método registrarPago(...), dado que Reserva agrega, almacena en su colección interna y utiliza de forma exclusiva dichas transacciones.

**- Clases donde se refleja:** Reserva e Pago.

**- Ventaja:** Se reduce el acoplamiento general del sistema al no delegar la creación en clases externas o controladores desconectados.

### 3. Controlador
**- Problema detectado:** Las pantallas o consolas de usuario no deben enviar mensajes directos a las entidades de dominio ni ejecutar lógica de orquestación.

**- Decisión tomada:** Se incorporaron las clases ControladorReserva y ControladorOperaciones como objetos intermedios no gráficos encargados de coordinar los eventos del sistema (recibir entradas, llamar a los expertos del dominio y devolver respuestas a la interfaz).

**- Clases donde se refleja:** ControladorReserva, ControladorOperaciones.

**- Ventaja:** Desacopla la lógica de negocio de la interfaz de usuario, permitiendo cambiar en la Etapa 2 de una consola a una interfaz gráfica Swing/JavaFX sin tocar el modelo.

### 4. Variaciones Protegidas
**- Problema detectado:** La necesidad de liquidar devoluciones según el medio de pago original o cambiar de pasarela de cobro sin romper la lógica del sistema de reservas.

**- Decisión tomada:** Se implementó el patrón introduciendo la abstracción ProcesadorPago (PagoEfectivo, PagoTarjeta, PagoTransferencia).

**- Clases donde se refleja:** Interfaz ProcesadorPago y sus implementaciones concretas.

**- Ventaja:** Cualquier cambio o agregado en los canales de pago queda encapsulado detrás de una interfaz estable, protegiendo al núcleo del negocio contra la inestabilidad de servicios externos.

