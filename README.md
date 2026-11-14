# Sistema de Gestión de Agencia de Turismo «Rumbo Sur»
**Trabajo Práctico Obligatorio - Programación Orientada a Objetos**  
**Alumna:** Gretell Sixto | **Docente:** María Ángela León | **Año:** 2026  

---

## DESCRIPCION DEL SISTEMA
Aplicación orientada a objetos desarrollada en Java para la gestión integral de tours, salidas programadas, reservas de pasajeros, cobro de señas y saldos, y cálculo automatizado de reintegros por cancelación para la agencia de turismo receptivo «Rumbo Sur».

El sistema implementa:
* **Jerarquía polimórfica de tours:** `Tour` (abstracta), `TourAventura`, `TourCultural` y `TourNaturaleza`, sobreescribiendo la validación de aptitud de pasajeros (`validarAptitud`).
* **Patrones GRASP:** Experto en Información (`CalculadoraPrecios`, `Pasajero`), Creador (`Reserva`), Controlador (`ControladorReserva`) y Variaciones Protegidas.
* **Principios SOLID:** Responsabilidad Única (SRP), Abierto/Cerrado (OCP con patrón *Strategy* para promociones) y Sustitución de Liskov (LSP).
* **Colecciones y ordenamiento:** `Comparable` para orden natural cronológico de salidas y `Comparator` para orden personalizado por plazas disponibles.
* **Excepciones de negocio:** `CupoExcedidoException` y `PasajeroNoAptoException` con bloques `try-catch-finally`.
* **Persistencia I/O:** Almacenamiento y lectura de reservas en archivo de texto (`reservas_registradas.txt`).

---

## RREQUISITOS DEL ENTORNO
* **Lenguaje:** Java SE 17 o superior (compatible con OpenJDK 21/26).
* **IDE recomendado:** IntelliJ IDEA / Eclipse.
* **Testing:** JUnit 5 (Jupyter).

---

## INSTRUCCIONES DE EJECUCION

### 1: Desde IntelliJ IDEA
1. Abrir IntelliJ y seleccionar **File > Open**, eligiendo la carpeta del proyecto.
2. Asegurar que el SDK del proyecto esté en Java 17 o superior en **File > Project Structure > Project**.
3. Navegar a `src/com/rumbosur/app/Main.java`.
4. Hacer clic derecho sobre `Main.java` y seleccionar **Run 'Main.main()'**.
5. Seguir el menú interactivo en la consola inferior.

### 2: Ejecución de Pruebas Unitarias
1. Navegar a `test/com/rumbosur/test/ReservaTest.java`.
2. Hacer clic derecho y seleccionar **Run 'ReservaTest'** para verificar la suite de tests automatizados (validación de aptitud y seña del 30%).
