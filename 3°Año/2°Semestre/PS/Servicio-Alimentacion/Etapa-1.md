# Sistema para la gestión del servicio de alimentación

## Trabajo integrador Cursada 2026

FECHA DE ENTREGA 16/10/2026

&nbsp;

**Destinatario:** Hospital Interzonal de Agudos Especializado en Pediatría "Sor María Ludovica".  Servicio de Alimentación y Dietética

&nbsp;

# Contexto

El Servicio de Alimentación y Dietética del Hospital Interzonal de Agudos Especializado en Pediatría **“Sor María Ludovica”** tiene a su cargo la gestión de las comidas destinadas al personal autorizado de los diferentes sectores/ servicios del hospital.

Para organizar esta actividad es necesario coordinar tres instancias de un mismo circuito:

* La declaración de las personas o cantidades de viandas requeridas por cada servicio/sector.  
* La revisión y autorización de esos pedidos por parte del Servicio de Alimentación.  
* La entrega física de las comidas y el registro de quién las retira.

Actualmente, estas actividades se realizan mediante planillas en papel, listados impresos, comunicaciones telefónicas y controles manuales. Cada sector informa sus necesidades, el Servicio de Alimentación revisa y ajusta las cantidades solicitadas, y el personal del comedor verifica posteriormente las autorizaciones al momento de efectuar la entrega.

La falta de integración entre estas etapas provoca diferentes dificultades operativas y administrativas:

* Pedidos duplicados o superiores a las necesidades reales.  
* Inconsistencias entre las cantidades solicitadas, autorizadas y entregadas.  
* Cambios de personal o de guardias que no son comunicados oportunamente.  
* Necesidad de realizar verificaciones y llamados entre los distintos sectores.  
* Falta de trazabilidad sobre quién solicitó, autorizó y retiró cada comida.  
* Dificultades para controlar los diferentes tipos de menú.  
* Escasa disponibilidad de información consolidada para auditoría, planificación y control del gasto.  
* Desperdicio de alimentos como consecuencia de sobrepedidos o entregas no registradas.

Deberá permitir gestionar de manera independiente el **desayuno**, **almuerzo, merienda** y la **cena**, así como distinguir diferentes tipos de menú, a saber:

* General.  
* Vegetariano.  
* Celíaco.

Para resolver esta problemática se propone desarrollar una aplicación web que digitalice el circuito completo de solicitud, autorización y entrega de comidas. El sistema será utilizado por tres actores principales:

* Los **Jefes de Servicio**, responsables de declarar las necesidades de alimentación de su sector.  
* El **Servicio de Alimentación**, encargado de revisar, ajustar y autorizar los pedidos.  
* El **Sector Comedor**, responsable de verificar las autorizaciones y entregar las comidas.

Cada actor dispondrá de una vista específica dentro del sistema, de acuerdo con sus responsabilidades y permisos. Sin embargo, todos trabajarán sobre información integrada: los pedidos cargados por los Jefes de Servicio serán revisados por el Servicio de Alimentación, y únicamente las cantidades autorizadas estarán disponibles para su entrega en el comedor.

La solución deberá mantener diferenciadas las cantidades **pedidas**, **autorizadas** y **entregadas**, registrar el historial de las operaciones realizadas y permitir conocer en todo momento el estado de cada solicitud. De esta manera, se buscará mejorar la coordinación entre las áreas, reducir errores y desperdicios, y garantizar la trazabilidad integral del proceso.

# Funcionalidades de la aplicación (se dividirá en dos etapas)

El desarrollo se organizará en dos etapas. La primera comprenderá la aplicación privada de administración, el modelo de datos y la API del sistema. La segunda comprenderá la aplicación web utilizada por los tres roles operativos —Jefe de Servicio, Servicio de Alimentación y Sector Comedor— e implementará el circuito de solicitud, autorización y entrega de comidas.

A continuación se describen, en líneas generales, las principales funcionalidades esperadas para cada actor.

### **Jefe de Servicio**

El Jefe de Servicio será responsable de registrar y consultar los pedidos de comidas correspondientes a su sector.

El sistema deberá permitirle:

* Consultar  e incorporar el personal asociado a su sector y eventuales personas de tipo Residente a los pedidos de su sector.  
* Registrar pedidos nominados de comidas, identificando a cada persona mediante nombre, apellido y DNI.  
* Gestionar de manera independiente las solicitudes de desayuno, almuerzo, merienda y cena.  
* Utilizar automáticamente el tipo de menú asociado a cada persona.  
* Realizar cargas con periodicidad diaria, semanal o mensual.  
* Visualizar los cupos correspondientes a su sector para cada tipo de comida.  
* Identificar las solicitudes que quedan comprendidas dentro del cupo Regular y aquellas que correspondan a Excepción.  
* Consultar y modificar los pedidos de su sector mientras éstos no hayan sido autorizados o rechazados por el Servicio de Alimentación.  
* Consultar pedidos actuales e históricos.

Cuando un sector tenga más de un Jefe de Servicio, todos ellos podrán consultar y gestionar los pedidos correspondientes a dicho sector.

### **Servicio de Alimentación**

El Servicio de Alimentación será responsable de revisar los pedidos realizados por los distintos sectores y determinar qué solicitudes quedan autorizadas.

El sistema deberá permitirle:

* Consultar los pedidos realizados por todos los sectores.  
* Visualizar las solicitudes correspondientes a desayuno, almuerzo, merienda y cena de manera independiente.  
* Identificar claramente las solicitudes clasificadas como Regulares y aquellas realizadas por Excepción.  
* Autorizar o no autorizar de manera nominada las solicitudes realizadas.  
* Realizar autorizaciones individuales o masivas para agilizar la operatoria.  
* Rechazar completamente un pedido cuando corresponda.  
* Mantener diferenciada la información originalmente solicitada de la posteriormente autorizada.  
* Administrar los cupos correspondientes a cada sector y tipo de comida.  
* Consultar pedidos y autorizaciones actuales e históricas.  
* Obtener totales y resúmenes por sector, fecha, tipo de comida y tipo de menú.  
* Exportar listados y consultar información consolidada para control y planificación.

Las cantidades autorizadas deberán obtenerse a partir de las solicitudes nominadas efectivamente autorizadas y no deberán sobrescribir la información del pedido original.

### **Sector Comedor**

El Sector Comedor será responsable de consultar las comidas autorizadas y registrar las entregas realizadas.

El sistema deberá permitirle:

* Buscar personas mediante DNI, nombre o apellido.  
* Consultar las comidas autorizadas para cada persona en una fecha determinada.  
* Identificar de manera independiente si una persona tiene autorizado desayuno, almuerzo, merienda o cena.  
* Visualizar el tipo de menú correspondiente.  
* Verificar si una comida autorizada ya fue entregada.  
* Registrar la entrega de una o varias comidas en una misma operación.  
* Permitir que una persona retire comidas correspondientes a otras personas autorizadas.  
* Registrar quién fue el responsable efectivo del retiro.  
* Impedir que una misma comida autorizada sea entregada más de una vez.  
* Consultar las entregas realizadas durante el día.  
* Visualizar totales autorizados y entregados.

### **Requerimientos funcionales generales**

Independientemente del actor que utilice cada funcionalidad, el sistema deberá:

* Gestionar usuarios, roles y permisos de acceso.  
* Mantener un registro de los sectores o servicios del hospital y sus responsables.  
* Mantener un registro del personal que podrá ser incluido en los pedidos de comidas.  
* Permitir la carga manual y la importación masiva de personal.  
* Contemplar los distintos tipos de personal y tipos de menú definidos para el sistema.  
* Mantener todos los pedidos de comida de forma nominada.  
* Gestionar desayuno, almuerzo, merienda y cena de manera independiente.  
* Mantener diferenciadas las solicitudes realizadas, las autorizaciones otorgadas y las entregas efectivamente registradas.  
* Mantener la condición Regular o Excepción asignada a cada solicitud durante el posterior circuito de autorización y entrega.  
* Registrar fecha, hora y usuario responsable de las operaciones relevantes.  
* Conservar la información histórica necesaria para garantizar la trazabilidad del circuito.  
* Proporcionar resúmenes, estadísticas e historiales por período, sector, tipo de comida y tipo de menú.  
* Implementar controles de acceso y validaciones tanto en la interfaz como en el backend.  
* Proporcionar interfaces adaptadas a las funciones y permisos correspondientes a cada tipo de usuario.

&nbsp;

La distribución detallada de estas funcionalidades entre la primera y la segunda etapa se especificará posteriormente.

&nbsp;

## Componentes de la aplicación

* **Backend en Python y Flask:** implementará la lógica de negocio, las validaciones del lado del servidor, la autenticación, el control de roles y permisos, y el acceso a la información almacenada. También será responsable de aplicar las reglas correspondientes a la carga, autorización y entrega de comidas.  
* **Base de datos PostgreSQL:** almacenará la información de usuarios, roles, permisos, sectores, personal, solicitudes, detalles de pedidos, cupos, autorizaciones, entregas e historial de operaciones. Para la interacción con la base de datos se utilizará SQLAlchemy como ORM.  
* **API para consultas e integración:** el backend desarrollado en Flask expondrá los endpoints necesarios para que la aplicación frontend pueda consultar y modificar la información del sistema. La comunicación se realizará mediante solicitudes HTTP y el intercambio de datos en formato JSON.  
* **Aplicación frontend en Vue.js 3:** se desarrollará una aplicación web que consumirá la API implementada en Flask. La aplicación contará con diferentes vistas y funcionalidades según el rol del usuario autenticado:  
  * Jefe de Servicio.  
  * Servicio de Alimentación.  
  * Sector Comedor.  
* **Interfaz responsive y mobile first:** las pantallas deberán adaptarse a computadoras de escritorio, notebooks, tablets y teléfonos móviles. La vista utilizada por el Sector Comedor deberá estar especialmente optimizada para tablets y ofrecer una modalidad de interacción tipo kiosco, con controles de tamaño adecuado y teclado numérico en pantalla para realizar búsquedas por DNI.

&nbsp;

&nbsp;

# **Etapa 1**

**ENTREGA 16/10/2026**

## **Alcance : Aplicación Privada y API**

Durante la primera etapa se desarrollará la **aplicación privada de administración**, el modelo de datos y la **API** necesaria para implementar el circuito completo de solicitud, autorización y entrega de comidas.

La aplicación privada estará destinada a usuarios con rol **Administrador**. Permitirá gestionar la información estructural y de configuración utilizada por las diferentes áreas del sistema, incluyendo usuarios, roles, sectores, personal, tipos de menú y otros parámetros generales.

El Administrador tendrá acceso completo a los módulos de la aplicación privada y será responsable de:

* Gestionar usuarios.  
* Asignar roles a los usuarios.  
* Activar o bloquear cuentas.  
* Gestionar sectores o servicios.  
* Asignar responsables a los sectores.  
* Gestionar el personal del hospital.  
* Administrar tipos de personal.  
* Administrar tipos de menú de comidas.  
* Configurar otros parámetros generales requeridos por el sistema.

La aplicación se desarrollará utilizando **Python y Flask**, con **Jinja** como motor de plantillas, **PostgreSQL** como base de datos y **SQLAlchemy** como ORM.

Además de la aplicación privada, durante esta etapa se implementará una **API** que exponga las operaciones necesarias para las interfaces operativas que se desarrollarán en Vue.js durante la segunda etapa.

## **Roles del sistema**

Quedarían definidos cuatro roles:

* **Administrador:** gestiona la configuración general, los usuarios, sectores, personal y parámetros del sistema.  
* **Jefe de Servicio:** registra y consulta los pedidos correspondientes al personal de su sector.  
* **Servicio de Alimentación:** revisa, ajusta, autoriza o rechaza pedidos y administra los cupos.  
* **Sector Comedor:** consulta las autorizaciones vigentes y registra las entregas realizadas.

El Administrador podrá crear usuarios y asignar cualquiera de los tres roles operativos. También podrá crear otros usuarios administradores.

1. ## **Layout**

### **Descripción**

Implementar un **layout base** para todas las vistas de la aplicación privada de administración. Este layout funcionará como contenedor principal y deberá garantizar una estructura visual uniforme, permitiendo que cada módulo reemplace únicamente el contenido central sin modificar los elementos generales de navegación.

El layout deberá implementarse mediante una plantilla base de **Jinja**, que será extendida por las diferentes vistas de la aplicación Flask. De esta manera, los elementos comunes —encabezado, navegación, mensajes y datos de la sesión— deberán definirse una sola vez.

![][image1]

\* El layout es solo un ejemplo, carece de opciones relevantes. Cada grupo es libre de la implementación de su interfaz.

&nbsp;

### **Requerimientos funcionales**

* Implementar un menú de navegación lateral o superior con enlaces a los módulos de la aplicación privada:  
  * Gestión de usuarios.  
  * Gestión de sectores o servicios.  
  * Gestión de personal.  
  * Gestión de tipos de menú.  
  * Parámetros generales del sistema, en caso de incorporarse.  
* El menú deberá indicar visualmente cuál es el módulo o sección activa.  
* Implementar una barra superior que incluya:  
  * Nombre o logo de la aplicación.  
  * Nombre y apellido del usuario autenticado.  
  * Menú de cuenta con las opciones:  
    * Ver perfil.  
    * Cerrar sesión.  
* Incorporar un área central destinada al contenido particular de cada módulo.  
* Incorporar un mecanismo común para mostrar mensajes de información, confirmación, advertencia o error generados por Flask.

&nbsp;

2. ## **Módulo de usuarios**

### **Descripción**

Implementar el módulo de usuarios de la aplicación privada, accesible únicamente para usuarios con rol **Administrador**. Este módulo permitirá crear, consultar, actualizar y eliminar usuarios del sistema, asignarles un rol y, cuando corresponda, asociarlos a un sector del hospital.

### **Requerimientos funcionales**

* Operaciones CRUD de usuarios.  
* Validar que no existan dos usuarios con el mismo correo electrónico.  
* Campos mínimos para cada usuario:  
  * Correo electrónico.  
  * Nombre.  
  * Apellido.  
  * DNI  
  * Contraseña.  
  * Activo: Sí | No.  
  * Rol:  
    * Administrador.  
    * Jefe de Servicio.  
    * Servicio de Alimentación.  
    * Sector Comedor.  
  * Sector, obligatorio únicamente para usuarios con rol Jefe de Servicio.  
  * Fecha de creación.  
  * Fecha de última modificación.  
* Reglas para la asignación de sectores:  
  * Un usuario con rol Jefe de Servicio deberá estar asociado a un único sector.  
  * Un sector podrá tener uno o más usuarios con rol Jefe de Servicio.  
  * Todos los Jefes asociados a un mismo sector podrán cargar y consultar pedidos correspondientes a dicho sector.  
  * Los usuarios con rol Administrador, Servicio de Alimentación o Sector Comedor no tendrán un sector asociado.  
  * Si se modifica el rol de un Jefe de Servicio, deberá eliminarse su asociación con el sector.  
  * No se podrá asociar un usuario a un sector inactivo.  
  * No se podrá desactivar un sector con usuarios activos.  
* Funcionalidad de búsqueda por:  
  * Correo electrónico.  
  * Nombre o apellido.  
  * DNI  
  * Activo: Sí | No.  
  * Rol.  
  * Sector o servicio.  
* Los filtros deberán poder combinarse entre sí.  
* Resultados ordenables por:  
  * Fecha de creación.  
  * Apellido y nombre.  
  * Correo electrónico.  
* El ordenamiento deberá permitir sentido ascendente y descendente.  
* Paginación del lado del servidor, con un máximo de **25 registros por página**.  
* En la edición de un usuario:  
  * La contraseña no será obligatoria.  
  * Si el campo de contraseña queda vacío, deberá conservarse la contraseña actual.  
  * Si se ingresa una nueva contraseña, deberá almacenarse utilizando un hash seguro.  
* No se podrá eliminar un usuario que tenga pedidos, autorizaciones, entregas u otras operaciones asociadas. En esos casos deberá desactivarse mediante la funcionalidad de bloqueo definida en el módulo siguiente.

### **Notas**

* Validar en el cliente:  
  * Campos requeridos.  
  * Formato de correo electrónico.  
  * Formato y longitud de nombre y apellido.  
  * Longitud mínima y confirmación de contraseña.  
  * Selección obligatoria de un sector cuando el rol sea Jefe de Servicio.  
* Validar en el servidor:  
  * Campos requeridos.  
  * Formato y longitud de los campos.  
  * Unicidad del correo electrónico.  
* Las contraseñas deberán almacenarse mediante un algoritmo seguro de hash y nunca podrán mostrarse en formularios, listados, registros de log o respuestas de la API.  
* Se deberá mostrar un feedback claro ante errores de validación y ante el resultado de las operaciones realizadas.

### **Permisos**

* Solamente los usuarios con rol **Administrador** podrán acceder a este módulo.

&nbsp;

3. ## **Gestión de Roles, Permisos y Bloqueo de Usuarios**

### **Descripción**

Implementar las funcionalidades de asignación de roles, control de permisos y bloqueo o desbloqueo de usuarios.

Cada usuario tendrá asignado **un único rol**, que determinará las funcionalidades a las que puede acceder. Los permisos deberán utilizarse para controlar las acciones específicas que cada rol puede realizar, tanto en la aplicación privada desarrollada con Flask y Jinja como en los endpoints de la API.

Los roles definidos para el sistema serán:

* Administrador.  
* Jefe de Servicio.  
* Servicio de Alimentación.  
* Sector Comedor.

### Requerimientos funcionales

* Asignar o desasignar roles a un usuario (Administrador).  
* Bloquear/desbloquear usuarios:  
  * Un usuario bloqueado no puede iniciar sesión.  
  * Los usuarios con rol Administrador no pueden ser bloqueados.  
* Implementar permisos siguiendo el patrón modulo\_accion. Ejemplos para este módulo:  
  * user\_index → listar usuarios  
  * user\_new → crear usuario  
  * user\_update → actualizar usuario  
  * user\_destroy → eliminar usuario  
  * user\_show → ver detalle de usuario

### Notas

* Los permisos y roles pueden administrarse directamente desde la base de datos en esta etapa del proyecto. Es decir, no hace falta hacer una interfaz gráfica para agregar permisos y roles, pero deberán existir en la base de datos.  
* **Es importante entender el porqué del uso de esta solución para implementar la autorización y seguir el esquema de forma correcta. Este tema será explicado oportunamente en los horarios de práctica.**

![][image2]

Figura 2\. Posible esquema para el manejo de usuarios.

### Permisos

* Todas las operaciones de roles y permisos sólo pueden ser realizadas por un usuario con rol **Administrador**.

&nbsp;

4. ## **Login y manejo de sesiones**

Descripción

Implementar el sistema de autenticación y manejo de sesiones para la aplicación privada (Administración).

Requerimientos funcionales

* Formulario de login para la aplicación privada que permita iniciar sesión con email y contraseña.  
* Validación de credenciales contra la base de datos.  
* Manejo seguro de contraseñas (hash).  
* Creación y manejo de sesiones para mantener el estado del usuario autenticado.  
* Verificación de sesión y permisos en cada módulo.  
* Implementar cierre de sesión.

Notas

* **No se permite el uso de librerías externas que abstraigan el proceso completo de login (por ejemplo, flask-login)**. La implementación debe ser manual para comprender y controlar cada paso del flujo de autenticación.  
* Implementar verificación de permisos antes de acceder a funcionalidades restringidas. Esta verificación se debe realizar para todas las secciones del sistema de Administración.  
* Las cookies de sesión deben ser seguras y tener fecha de expiración.  
* **Deben utilizar** la librería **Flask-Session** para almacenar las sesiones del lado del servidor.  
* La autenticación en la aplicación privada será obligatoria para acceder cualquier parte de la aplicación de administración.

&nbsp;

&nbsp;

5. ## **Gestión de Sectores**

### **Descripción**

Implementar el módulo de sectores del hospital. Este módulo permitirá crear, consultar, actualizar y eliminar los sectores a los que pertenecen el personal y los Jefes de Servicio.

### **Requerimientos funcionales**

* Operaciones CRUD de sectores.  
* Validar que no existan dos sectores con el mismo nombre.  
* Campos mínimos para cada sector:  
  * Nombre.  
  * Descripción.  
  * Activo: Sí | No.  
  * Fecha de creación.  
  * Fecha de última modificación.  
* Permitir asociar uno o más usuarios con rol **Jefe de Servicio** a un sector.  
* Cada Jefe de Servicio podrá estar asociado a un único sector.  
* Un sector podrá tener varios Jefes de Servicio.  
* Los Jefes de Servicio asociados a un mismo sector podrán cargar y consultar pedidos de ese sector.  
* Funcionalidad de búsqueda por:  
  * Nombre.  
  * Estado: Activo | Inactivo.  
  * Jefe de Servicio asignado.  
* Resultados ordenables por:  
  * Nombre.  
  * Fecha de creación.  
* El ordenamiento deberá permitir sentido ascendente y descendente.  
* Paginación del lado del servidor, con un máximo de **25 registros por página**.

### **Notas**

* Validar en el cliente:  
  * Campos requeridos.  
  * Formato y longitud de los campos.  
* Validar en el servidor:  
  * Campos requeridos.  
  * Unicidad del nombre.  
  * Existencia de los usuarios seleccionados.  
  * Que los usuarios asignados tengan rol Jefe de Servicio.  
  * Que un Jefe de Servicio no se encuentre asociado a otro sector.  
* No se podrá eliminar un sector que tenga personal, usuarios o pedidos asociados. En esos casos deberá desactivarse.  
* Un sector inactivo no podrá utilizarse para nuevas asignaciones de personal ni para nuevos pedidos.  
* La desactivación de un sector no deberá eliminar sus registros históricos.

### **Permisos**

* Solamente los usuarios con rol **Administrador** podrán acceder a este módulo.

  &nbsp;

6. ## **Gestión del Personal del Hospital**

### **Descripción**

Implementar el módulo de personal del hospital. Este módulo permitirá registrar, consultar, actualizar e importar las personas que podrán ser incluidas en los pedidos nominados de comidas.

Importante : El personal registrado no necesariamente tendrá una cuenta para acceder al sistema. Los **usuarios** representan a quienes utilizan la aplicación, mientras que el **personal** representa a las personas para las que se solicitan y entregan comidas. Una excepción es el caso de los Jefes de Servicio que son usuarios registrados y a la vez pueden ser personal autorizado para las comidas.

El sistema deberá contemplar que algunas personas, particularmente los **residentes**, pueden rotar entre distintos sectores del hospital por lo tanto no tendrán sector asignado y podrá incorporarse a pedidos de cualquier sector.

&nbsp;

### **Requerimientos funcionales**

* Operaciones CRUD de personal.  
* Campos mínimos para cada persona:  
  * DNI.  
  * Nombre.  
  * Apellido.  
  * Tipo de personal. \[\*1\]  
  * Sector (No aplica para residentes) \[\*2\]  
  * Menu\[\*3\]  
  * Activo: Sí | No.  
  * Fecha de creación.  
  * Fecha de última modificación.  
* Validar que no existan dos personas con el mismo DNI .  
* El personal fijo está asociado a un único sector a la vez. Para cambiar de sector alcanza con reemplazar ese valor;  
* El personal de tipo Residente no tiene sector asignado obligatoriamente y puede incorporarse al pedido nominado de cualquier sector  
* Para incorporar una persona de tipo Personal fijo a un pedido, su sector debe coincidir con el sector del Jefe de Servicio que realiza la carga. Los Residentes pueden incorporarse a un pedido de cualquier sector sin esa validación  
* Permitir la búsqueda por:  
  * DNI.  
  * Nombre o apellido.  
  * Sector.  
  * Tipo de personal.  
  * Estado.  
* Resultados ordenables por:  
  * Apellido y nombre.  
  * DNI.  
  * Fecha de creación.  
* Paginación del lado del servidor, con un máximo de 25 registros por página.  
* Permitir la importación masiva de personal mediante un archivo CSV. Para esta funcionalidad se espera que se defina un formato de CSV, luego el usuario administrador cargue el personal en él y cuando se importe desde el sistema se añadan el personal nominado en él. Es importante validar cada registro/persona e informar el error en caso de suceder.&nbsp;

### **Notas**

* Validar en el cliente y en el servidor:  
  * Campos requeridos.  
  * Formato de DNI.  
  * Unicidad de DNI&nbsp;  
  * Existencia del tipo de personal.  
  * Existencia de los sectores asignados.  
* No se podrá eliminar una persona que tenga pedidos o entregas asociados. En esos casos deberá marcarse como inactiva.  
* Una persona inactiva no podrá incorporarse a nuevos pedidos, pero deberá mantenerse visible en los registros históricos.  
* El cambio de sector de una persona no deberá modificar pedidos, autorizaciones o entregas registrados anteriormente.  
* Cada persona tendrá asociado un tipo de menú predeterminado en su ficha de Personal. Al incorporarla a un pedido, el sistema utilizará automáticamente dicho tipo de menú y lo almacenará en el detalle del pedido, sin necesidad que el Jefe de servicio deba asignarlo manualmente. Posteriores cambios en la ficha de la persona no deben modificar pedidos históricos.  
* La importación masiva deberá informar los registros procesados, importados y rechazados, indicando el motivo de cada error.

### **Permisos**

* Solamente los usuarios con rol **Administrador, Jefe de Servicio y Servicio de Alimentación** podrán gestionar el personal y sus asignaciones desde la aplicación.

&nbsp;

&nbsp;

\[\*1\] Sobre el Tipo de Personal:  
**Tipos de personal**

Los tipos de personal serán datos predefinidos, por ejemplo:

* Residente.  
* Personal Fijo.

Deberán almacenarse obligatoriamente en una tabla independiente de la base de datos y relacionarse con el personal mediante una clave foránea, garantizando la integridad referencial. Los valores podrán cargarse mediante migraciones, scripts de inicialización o datos precargados. Opcionalmente, el grupo podrá implementar un CRUD en la aplicación privada para que el Administrador gestione los tipos de personal.

\[\*2\] **Sobre los Sectores/Servicios**

Los sectores/servicios existentes son los siguientes. Instanciar a modo de ejemplo alguno o la totalidad de los mismos. A saber:

Medicos Internos, Medicos De Guardia (Urg)., Quirofano , Equipo De Guardia , Intendencia , Policia , Mantenimiento , Electricidad, Conmutador, Admision De Camas, Prep De Materiales, Laboratorio De Guardia, Economia Y Gestion , Hemoterapia , Secretarias De Guardia Estadistica, Rayos, Esterilizacion, Ssp, Mensajeria , Ate, Limpieza , Cefli , Lavadero, Salud Mental , Quirofano Cardiovascular , Alimentacion, Direccion, Deposito Central, Alegria Intensiva, Estadistica, Neurocirugia, Hermanas, Residentes Jefes, Niño Sano 63 Y 16, Genetica Idip

&nbsp;

\[\*3\] Sobre el Tipo de Menu:

### **Tipos de menú**

Los tipos de menú serán datos predefinidos:

* General.  
* Vegetariano.  
* Celiaco.

Deberán almacenarse obligatoriamente en una tabla independiente de la base de datos y relacionarse con el Personal y, según el modelo adoptado, con la información histórica correspondiente a las solicitudes de comidas. Los valores podrán cargarse mediante migraciones, scripts de inicialización o datos precargados. Opcionalmente, el grupo podrá implementar un CRUD en la aplicación privada para que el Administrador gestione los tipos de menú.

7. ## **Cupos**

   &nbsp;

**Descripción**

Implementar el módulo de cupos por sector. Este módulo permitirá definir, para cada sector y tipo de comida (desayuno, almuerzo, merienda y cena), la cantidad máxima de personas que podrán incorporarse como solicitudes regulares.

Todos los pedidos de comidas serán nominados, por lo que cada comida solicitada deberá estar asociada a una persona identificada.

El cupo no representa una modalidad diferente de pedido, sino que se utilizará como límite para determinar si cada persona incorporada a un pedido corresponde a una **solicitud regular o a una solicitud por excepción**.

**Requerimientos funcionales**&nbsp;

* Operaciones CRUD de cupos.  
* Campos mínimos para cada cupo:  
  * Sector.  
  * Tipo de comida:  
    * Desayuno.  
    * Almuerzo.  
    * Merienda.  
    * Cena.  
  * Cantidad de comensales.  
  * Fecha de creación.  
  * Fecha de última modificación.  
* El cupo será independiente del tipo de menú.  
* Para cada fecha y tipo de comida, las personas incorporadas al pedido hasta alcanzar el cupo disponible serán consideradas **regulares**.  
* Las personas incorporadas una vez alcanzado el cupo serán consideradas **excepciones**.  
* El sistema deberá identificar automáticamente esta condición durante la carga del pedido.  
* No se podrá crear un cupo para un sector inactivo.  
* No podrán coexistir dos cupos vigentes para el mismo sector y el mismo tipo de comida&nbsp;  
* Funcionalidad de búsqueda por:  
  * Sector.  
  * Tipo de comida.  
* Resultados ordenables por:  
  * Sector.

Paginación del lado del servidor, con un máximo de 25 registros por página.

### **Notas**

* Validar en el cliente y en el servidor:  
  * Campos requeridos.  
  * Que la cantidad sea mayor que cero.  
  * Existencia y estado activo del sector.  
* La modificación de un cupo no deberá alterar retroactivamente pedidos que ya se encuentren confirmados, autorizados o entregados.  
* El tipo de menú no modifica el consumo del cupo. Cada persona ocupa una unidad del cupo independientemente de que corresponda menú General, Vegetariano o Celíaco.

### **Permisos**

Los cupos serán administrados por usuarios con rol **Servicio de Alimentación** mediante la API. El Jefe de Servicio podrá consultar los correspondientes a su sector, pero no modificarlos.

&nbsp;

**Sobre los pedidos de comida**

Los pedidos deberán permitir representar de manera independiente las solicitudes correspondientes a **desayuno, almuerzo, merienda y cena** para cada **sector** y **fecha**. Todas las solicitudes serán nominadas, por lo que cada comida solicitada deberá quedar asociada a una persona identificada.

Para cada solicitud deberá poder determinarse, como mínimo, el sector, la fecha, el tipo de comida, la persona, el tipo de menú y su condición **Regular** o **Excepción**.

La organización interna de esta información y el modelo de datos utilizado quedarán a criterio de cada grupo, siempre que permitan cumplir las reglas de negocio y mantener la trazabilidad requerida.

La estructura de la API podrá adaptarse al modelo de datos y a las decisiones de diseño adoptadas por cada grupo. Recuerden que los endpoints propuestos en este documento deberán considerarse como una guía y podrán ajustarse, agruparse o complementarse cuando resulte necesario, siempre que se mantengan las funcionalidades, reglas de negocio y restricciones de acceso definidas.

8. ## **Ajustes del sistema**

&nbsp;

Este módulo permitirá administrar la configuración del sistema, como mínimo deberá contemplar la siguiente configuración:

* Cantidad de elementos por página en los listados del sistema (todos los listados deberán respetar este valor para el paginado).  
* Posibilidad de deshabilitar el sitio para mantenimiento  
* Mensaje de mantenimiento de sitio

La configuración del sistema sólo podrá modificarla un usuario con el rol de Administrador.

&nbsp;

9. ## **API**

### **Descripción**

Implementar una API que permita acceder a las funcionalidades necesarias para las tres interfaces que se desarrollarán en Vue.js durante la segunda etapa:

* Jefe de Servicio.  
* Servicio de Alimentación.  
* Sector Comedor.

NOTAS:

- La siguiente lista es una guía pero que el/la estudiante pueda modificar lo definido o agregar en caso que se considere, según lo requiera la solución implementada.  
- Todos los endpoints deben manejar los errores siguiendo el estándar HTTP, devolviendo el código de estado que corresponda a cada situación (por ejemplo 400 para datos inválidos, 401 para falta de autenticación o token inválido, 403 para falta de permisos, 404 para recursos inexistentes, etc) junto con el detalle del error en el cuerpo de la respuesta.  
- Salvo el login, todos los endpoints deben estar protegidos con autenticación: la ausencia o invalidez del token debe rechazarse con 401 antes de evaluar cualquier otra regla de negocio, y los permisos según el rol del usuario autenticado deben verificarse en el propio endpoint, no solo ocultarse en la interfaz.&nbsp;

### **Autenticación**

* `POST /api/auth/login` — iniciar sesión.  
* `POST /api/auth/logout` — cerrar sesión.  
* `GET /api/auth/me` — obtener los datos del usuario autenticado.  
- **Rol(es)**: cualquier usuario autenticado de las tres interfaces operativas.  
- **Entrada**: token de acceso en el header Authorization (Bearer).  
- **Salida**: id, nombre, apellido, email, rol, sector asociado (si corresponde).  
- **Reglas** de negocio: validar que el token sea válido y no haya expirado.  
- **Errores**: 401 si falta el token, es inválido o expiró.

### **Sectores y datos generales**

* #### `GET /api/sectors — listar sectores.`&nbsp;&nbsp;

- **Rol(es)**: Servicio de Alimentación, Sector Comedor. El Jefe de Servicio no lo necesita: opera únicamente sobre su propio sector, ya disponible mediante \`GET /api/auth/me\`.&nbsp;&nbsp;  
- **Entrada**: parámetro de query opcional \`estado\` (\`activo\` por defecto; \`todos\` para incluir inactivos, necesario al consultar períodos históricos).&nbsp;&nbsp;  
- **Salida**: listado de sectores (id, nombre, descripción, estado).&nbsp;&nbsp;  
- **Reglas de negocio**: por defecto solo deben listarse sectores activos, para no ofrecerlos como opción en nuevos cupos o autorizaciones.&nbsp;&nbsp;  
- **Errores**: 403 si lo invoca un usuario con rol Jefe de Servicio.&nbsp;&nbsp;

* #### ``GET /api/sectors/{sector_id}` — obtener un sector.``&nbsp;&nbsp;

- **Rol(es)**: Servicio de Alimentación, Sector Comedor.&nbsp;&nbsp;  
- **Entrada**: \`sector\_id\` en la URL.&nbsp;&nbsp;  
- **Salida**: datos completos del sector, incluyendo inactivos.&nbsp;&nbsp;  
- **Reglas de negocio**: sin restricción por estado — un sector desactivado debe poder consultarse para mantener trazabilidad histórica; solo se restringe su uso para nuevas asociaciones.&nbsp;&nbsp;  
- **Errores**: 404 si el sector no existe.&nbsp;&nbsp;

* #### `GET /api/menu-types — listar tipos de menú.`&nbsp;&nbsp;

- **Rol(es)**: cualquier usuario autenticado de las tres interfaces operativas (Jefe de Servicio, Servicio de Alimentación, Sector Comedor); se usa para poblar los combos de selección de menú y funcionalidades que lo requieran .&nbsp;&nbsp;  
- **Entrada**: ninguna.&nbsp;&nbsp;  
- **Salida**: listado completo de tipos de menú predefinidos.&nbsp;&nbsp;  
- **Reglas de negocio**: ninguna; catálogo fijo, sin filtro de activo/inactivo previsto en esta etapa.&nbsp;&nbsp;  
- **Errores**: —&nbsp;&nbsp;

* #### `GET /api/personnel-types — listar tipos de personal.`&nbsp;&nbsp;

- **Rol(es)**: cualquier usuario autenticado de las tres interfaces operativas.&nbsp;  
- **Entrada**: ninguna.&nbsp;&nbsp;  
- **Salida**: listado completo de tipos de personal predefinidos.&nbsp;&nbsp;  
- **Reglas de negocio**: ninguna.&nbsp;&nbsp;  
- **Errores**: —&nbsp;&nbsp;

* #### `GET /api/configuration — consultar parámetros generales necesarios para las interfaces.`&nbsp;&nbsp;

- **Rol(es)**: cualquier usuario autenticado.&nbsp;&nbsp;  
- **Entrada**: ninguna.&nbsp;&nbsp;  
- **Salida**:&nbsp;  
- **Reglas de negocio**: pendiente de cerrar la definición de "Ajustes del sistema".&nbsp;  
- **Errores**: —

### **Personal**

* `GET /api/personnel` — buscar y listar personal.  
- **Rol(es)**: Jefe de Servicio (limitado a su propio sector y del listado de residentes, ver Reglas de negocio), Servicio de Alimentación, Sector Comedor.  
- **Entrada**: filtros por query — DNI, nombre o apellido, sector, tipo de personal, estado; paginación (máximo 25 por página).  
- **Salida**: listado paginado de personas con sus datos básicos y el sector.  
- **Reglas de negocio**: un Jefe de Servicio solo puede ver personal con asignación vigente en su propio sector y, adicionalmente, buscar personas de tipo Residente, sin importar qué sector pida por parámetro — el backend debe forzarlo según el usuario autenticado, no confiar en lo que envíe el cliente; Servicio de Alimentación y Sector Comedor pueden buscar en todos los sectores; por defecto listar solo personas activas.  
- **Errores**: 400 si los filtros son inválidos.  
* `GET /api/personnel/{person_id}` — obtener una persona.  
- **Rol(es)**: Jefe de Servicio (solo si la persona tiene asignación vigente en su sector o si es de Tipo residente), Servicio de Alimentación, Sector Comedor.  
- **Entrada**: person\_id en la URL.  
- Salida: datos completos de la persona, incluyendo el sector y el tipo de personal.  
- **Reglas de negocio**: si lo llama un Jefe de Servicio y la persona no tiene asignación vigente en su sector o no es residente, debe rechazarse aunque la persona exista, para no exponer datos de personal de otros sectores.  
- **Errores**: 404 si no existe; 403 si un Jefe de Servicio consulta a alguien fuera de su sector.  
* `GET /api/sectors/{sector_id}/personnel` — listar el personal de un sector.  
- **Rol(es)**: Jefe de Servicio (solo su propio sector\_id), Servicio de Alimentación, Sector Comedor.  
- **Entrada**: sector\_id en la URL; parámetro de query opcional fecha (por defecto la fecha actual); paginación.  
- **Salida**: listado del personal activo perteneciente al sector.&nbsp;  
- **Reglas de negocio:** un Jefe de Servicio que pida un sector\_id distinto al propio debe recibir 403\.  
- **Errores**: 403 si un Jefe de Servicio pide un sector distinto al propio; 404 si el sector no existe.  
* `POST /api/personnel — crear una persona.`&nbsp;  
- **Rol(es)**:Rol(es): Jefe de Servicio, Servicio de Alimentación.  
- **Entrada**: DNI, nombre, apellido, tipo de personal, tipo menu y sector cuando corresponda.  
- **Salida**: datos de la persona creada.  
- **Reglas de negocio**:  
  - No debe existir otra persona con el mismo DNI  
  - Un Jefe de Servicio solo podrá crear personas de tipo Personal Fijo asociadas a su propio sector. El sector se determinará a partir del usuario autenticado y no deberá confiarse en un `sector_id` enviado por el cliente.  
  - Las personas de tipo Residente no tendrán sector asociado.  
  - La creación o modificación de Residentes quedará a cargo del **Servicio de Alimentación**. El Jefe de Servicio solamente podrá buscarlos y agregarlos a sus pedidos.  
  - El tipo de personal indicado deberá existir.  
  - La nueva persona quedará activa por defecto.  
- **Errores**: 400 si faltan datos obligatorios o alguno de los datos es inválido.; 409 si ya existe una persona con el mismo DNI ; 403 si un Jefe de Servicio intenta crear personal fuera de su sector o una persona de tipo Residente

&nbsp;

* `PUT /api/personnel/{person_id} — modificar una persona.`  
- **Rol(es)**:Rol(es): Jefe de Servicio, Servicio de Alimentación.  
- **Entrada**: `person_id` en la URL y los datos modificables de la persona.  
- **Salida**: datos actualizados de la persona.  
- **Reglas de negocio**:  
  - Un Jefe de Servicio solo podrá modificar personas de tipo Personal Fijo pertenecientes a su propio sector.  
  - Un Jefe de Servicio no podrá modificar Residentes ni trasladar una persona a otro sector.  
  - El Servicio de Alimentación podrá modificar Personal Fijo y Residentes.  
  - No deberá permitirse modificar el DNI de forma que se genere una duplicación con otra persona registrada.  
  - Si se modifica el tipo de personal de Personal Fijo a Residente, deberá eliminarse su asociación con el sector.  
  - Si una persona pasa de Residente a Personal Fijo, deberá indicarse obligatoriamente el sector al que pertenece.  
  - Las modificaciones de los datos de una persona no deberán alterar pedidos, autorizaciones o entregas registrados anteriormente.  
- **Errores**: 404 si la persona no existe; 400 si los datos ingresados son inválidos; 403 si un Jefe de Servicio intenta modificar una persona que no pertenece a su sector o una persona de tipo Residente; 409 si el DNI ingresado corresponde a otra persona.

  &nbsp;

* `DELETE /api/personnel/{person_id} — eliminar o desactivar una persona.`  
- **Rol(es)**:Rol(es): Jefe de Servicio, Servicio de Alimentación.  
- **Entrada**: `person_id` en la URL.&nbsp;  
- **Salida**: confirmación de la operación realizada.&nbsp;  
- **Reglas de negocio:**&nbsp;  
  - Un Jefe de Servicio solo podrá realizar la operación sobre Personal Fijo perteneciente a su propio sector.  
  - Si la persona no tiene pedidos, autorizaciones, entregas u otros registros históricos asociados, podrá eliminarse.  
  - Si existen registros históricos asociados, la persona no deberá eliminarse físicamente y deberá marcarse como inactiva.  
  - Una persona inactiva no podrá incorporarse a nuevos pedidos, pero deberá continuar disponible para consultas históricas.  
  - Los pedidos, autorizaciones y entregas registrados previamente no deberán modificarse como consecuencia de esta operación.  
- **Errores**: 404 si la persona no existe; 403 si un Jefe de Servicio intenta modificar una persona que no pertenece a su sector o una persona de tipo Residente;&nbsp;

### 

### **Pedidos de comidas**

#### `GET /api/requests — listar pedidos.`

- Rol(es): Jefe de Servicio.  
- Entrada: filtros por query — rango de fechas, tipo de comida, tipo de menú, estado (confirmado/autorizado/rechazado); paginación.  
- Salida: listado paginado de pedidos con sus totales por comida y tipo de menú.  
- Reglas de negocio: el sector se determina por el usuario autenticado, nunca por un parámetro que mande el cliente — un Jefe de Servicio solo ve los pedidos de su propio sector, y los ve junto con el resto de los Jefes de ese sector.  
- Errores: —

  #### 

  #### `POST /api/requests — crear un pedido.`

- Rol(es): Jefe de Servicio.  
- Entrada: periodicidad (diaria, semanal o mensual), fecha o rango de fechas, y el detalle por comida (desayuno/almuerzo/merienda/cena): la lista de personas (person\_id) incluidas. El sector se toma del usuario autenticado, no se recibe del cliente.  
- Reglas de negocio: cada persona de tipo Personal fijo incluida debe tener como sector el del Jefe de Servicio que realiza la carga; los Residentes pueden incluirse sin esa validación; no debe permitirse cargar personas inactivas; las personas se cargan dentro del cupo asignado al sector para esa comida hasta agotarlo, y las que excedan ese límite quedan marcadas como excepción. No deberá registrarse más de una vez una misma solicitud para la combinación persona, sector, fecha y tipo de comida.  
- Errores: 400 si faltan datos o una persona no tiene asignación vigente en la fecha de la comida; 409 si ya existe un pedido para el mismo sector y fecha&nbsp;

&nbsp;

  #### `GET /api/requests/{request_id} — obtener un pedido.`

- Rol(es): Jefe de Servicio, solo si el pedido pertenece a su sector.  
- Entrada: request\_id en la URL.  
- Salida: detalle completo del pedido — cantidades pedidas por comida y tipo de menú, personas incluidas, estado; si ya fue revisado por Servicio de Alimentación, incluir también las cantidades autorizadas como referencia de solo lectura, sin mezclarlas con las pedidas.  
- Reglas de negocio: —  
- Errores: 404; 403 si el pedido no pertenece al sector del Jefe de Servicio que consulta.

&nbsp;

  #### `PUT /api/requests/{request_id} — modificar un pedido.`

- Rol(es): Jefe de Servicio, solo del sector propio.  
- Entrada: los mismos campos que la creación.  
- Salida: el pedido actualizado.  
- Reglas de negocio: solo podrá modificarse un pedido en estado confirmado. Al modificar las personas incluidas, el sistema deberá recalcular la condición Regular o Excepción de las solicitudes según el cupo actual del sector. Un pedido autorizado o rechazado no podrá ser modificado por el Jefe de Servicio.  
- Errores: 404 si el pedido no existe; 403 si no pertenece al sector del usuario; 409 si el pedido ya fue autorizado o rechazado.

&nbsp;

  #### `DELETE /api/requests/{request_id} — eliminar un pedido`

- Rol(es): Jefe de Servicio, sector propio.  
- Entrada: request\_id en la URL.  
- Salida: confirmación vacía.  
- Reglas de negocio: solo podrá eliminarse un pedido en estado confirmado, mientras no haya sido autorizado o rechazado por el Servicio de Alimentación.  
- Errores: 404 si el pedido no existe; 403 si no pertenece al sector del usuario; 409 si el pedido ya fue autorizado o rechazado.

&nbsp;

&nbsp;

### **Autorización de pedidos**

#### `GET /api/authorizations — listar pedidos pendientes o autorizados.`

- Rol(es): Servicio de Alimentación.  
- Entrada: filtros por query — rango de fechas, sector, tipo de comida, tipo de menú, estado (confirmado/autorizado/rechazado); paginación. Etapa 2 pide vistas diarias y semanales, y consultar únicamente los períodos que tengan pedidos registrados, así que el filtro por fecha debería poder devolver solo fechas con datos en vez de un calendario vacío.  
- Salida: listado paginado de pedidos confirmados por los Jefes de Servicio, con las cantidades pedidas y, si ya se ajustaron, las autorizadas, siempre por separado.  
- Reglas de negocio: los pedidos en estado confirmado se consideran pendientes de autorización. Los totales deberán calcularse a partir de las solicitudes nominadas.  
- Errores: —

&nbsp;

  #### `GET /api/authorizations/{request_id} — obtener el detalle de un pedido para su autorización.`

- Rol(es): Servicio de Alimentación.  
- Entrada: request\_id en la URL.  
- Salida: detalle completo discriminado por comida y tipo de menú, con cantidades pedidas y autorizadas por separado, y las personas incluidas.  
- Reglas de negocio: —  
- Errores: 404 si el pedido no existe.

&nbsp;

  #### `PUT /api/authorizations/{request_id} — autorizar un pedido`

- Rol(es): Servicio de Alimentación.  
- Entrada: listado de las solicitudes nominadas del pedido indicando cuáles quedan autorizadas y cuáles no autorizadas.  
- Salida: pedido actualizado con las personas y comidas autorizadas, junto con los totales resultantes.  
- Reglas de negocio: solo podrán autorizarse solicitudes que formen parte del pedido original. La autorización deberá realizarse de manera independiente para cada persona y tipo de comida. La interfaz podrá permitir la selección individual o masiva de solicitudes, manteniendo en todos los casos el registro nominado de cada autorización. Las cantidades autorizadas se calcularán automáticamente a partir de las solicitudes autorizadas.  
- Errores: 404 si el pedido no existe; 409 si el pedido ya está autorizado o rechazado; 400 si se intenta autorizar una solicitud que no pertenece al pedido.

&nbsp;

  #### `POST /api/authorizations/{request_id}/reject — rechazar un pedido.`

- Rol(es): Servicio de Alimentación.  
- Entrada: request\_id en la URL; posiblemente un motivo de rechazo, para trazabilidad (no está pedido en el documento pero es un dato barato de guardar).  
- Salida: el pedido en estado rechazado.  
- Reglas de negocio: un pedido rechazado no debe quedar disponible para entrega, pero sí visible en el historial.  
- Errores: 409 si ya estaba autorizado.

&nbsp;

### **Cupos por sector**

#### `GET /api/quotas — listar cupos.`

- Rol(es): Servicio de Alimentación (gestión); Jefe de Servicio, solo lectura del cupo de su propio sector (Etapa 2 pide "visualizar el cupo asignado a su sector... mientras se realiza la carga"); Sector Comedor, para consultas en la interfaz.  
- Entrada: filtros por query — sector, tipo de comida; paginación.  
- Salida: listado de cupos (sector, comida, cantidad).  
- Reglas de negocio: un Jefe de Servicio solo puede ver los cupos de su propio sector, igual que con /api/sectors.  
- Errores: 403 si un Jefe de Servicio pide cupos de otro sector.

&nbsp;

  #### `POST /api/quotas — crear un cupo.`

- Rol(es): Servicio de Alimentación.  
- Entrada: sector, comida, cantidad  
- Salida: el cupo creado.  
- Reglas de negocio: no debe poder crearse un cupo para un sector inactivo, igual que el resto de las asociaciones del sistema con sectores.  
- Errores: 400 si el sector está inactivo o los datos son inválidos.

&nbsp;

  #### `GET /api/quotas/{quota_id} — obtener un cupo.`

- Rol(es): Servicio de Alimentación; Jefe de Servicio, solo el propio; Sector Comedor.  
- Entrada: quota\_id en la URL.  
- Salida: datos completos del cupo.  
- Reglas de negocio: mismo scoping por sector que en el listado para el Jefe de Servicio.  
- Errores: 404; 403 según corresponda.

&nbsp;

  #### `PUT /api/quotas/{quota_id} — modificar un cupo.`

- Rol(es): Servicio de Alimentación.  
- Entrada: los mismos campos que la creación.  
- Salida: el cupo actualizado.  
- Reglas de negocio: la modificación de un cupo se aplicará únicamente a los pedidos que se registren con posterioridad al cambio. No deberá modificar la condición Regular o Excepción de las solicitudes pertenecientes a pedidos ya registrados. No podrá existir más de un cupo para la misma combinación de sector y tipo de comida.&nbsp;  
- Errores: 400 si la nueva cantidad es menor a lo ya entregado en el período.

&nbsp;

&nbsp;

### **Consulta de comidas autorizadas**

#### `GET /api/authorized-meals — consultar comidas autorizadas por fecha, DNI, sector o tipo de comida.`

- Rol(es): Sector Comedor (uso principal, para verificar autorizaciones al momento de la entrega); Servicio de Alimentación.  
- Entrada: filtros por query — fecha, DNI,NyA, sector, tipo de comida.  
- Salida: listado de personas autorizadas para esa combinación, con el tipo de menú autorizado y si ya fue entregada esa comida o no, para evitar entregas duplicadas.  
- Reglas de negocio: solo deben aparecer pedidos en estado autorizado; debe indicarse cuánto de lo autorizado ya fue entregado.  
- Errores: 400 si no se envía ningún filtro, para evitar traer todo el sistema de una.

  #### 

  #### `GET /api/authorized-meals/{person_id} — consultar las comidas autorizadas para una persona.`

- Rol(es): Sector Comedor, Servicio de Alimentación.  
- Entrada: person\_id en la URL; parámetro de query fecha (por defecto la fecha actual).  
- Salida: las comidas autorizadas para esa persona en esa fecha (desayuno/almuerzo/merienda/cena, tipo de menú, si ya fue entregada).  
- Reglas de negocio: igual que el endpoint anterior.  
- Errores: 404 si la persona no existe.

### **Entregas**

#### `GET /api/deliveries — listar entregas.`

- Rol(es): Sector Comedor (las del turno en curso o consultas propias); Servicio de Alimentación (para reportes).  
- Entrada: filtros por query — fecha, sector, tipo de comida; paginación.  
- Salida: responsable y listado de entregas registradas.  
- Reglas de negocio: —  
- Errores: —

&nbsp;

  #### `POST /api/deliveries — registrar una entrega.`

- Rol(es): Sector Comedor.  
- Entrada: personas incluidas en el retiro (person\_id de cada una), tipo de comida, tipo de menú entregado, y quién es el responsable del retiro (puede ser una de las personas incluidas o alguien que retira en representación de otras).  
- Salida: la entrega registrada, con fecha y hora, usuario del Sector Comedor que la efectuó, personas incluidas y responsable del retiro.  
- Reglas de negocio: cada persona incluida debe tener autorización vigente para esa comida y fecha que todavía no haya sido entregada, para no permitir retirar dos veces lo mismo; fecha, hora y usuario se completan automáticamente en el servidor, nunca los envía el cliente. Debe permitirse registrar la entrega de comidas correspondientes a una o varias personas en una misma operación&nbsp;  
- 409 si alguna persona ya tiene esa comida entregada; 400 si alguna persona no tiene autorización vigente para esa comida y fecha.

&nbsp;

  #### `GET /api/deliveries/{delivery_id} — obtener el detalle de una entrega.`

- Rol(es): Sector Comedor, Servicio de Alimentación.  
- Entrada: delivery\_id en la URL.  
- Salida: detalle completo de la entrega.  
- Reglas de negocio: —  
- Errores: 404\.

&nbsp;

  #### `GET /api/deliveries/summary — obtener el resumen de entregas de una fecha o tipo de comida.`

- Rol(es): Sector Comedor (para ver el total autorizado y entregado durante el día, según Etapa 2); Servicio de Alimentación.  
- Entrada: fecha o tipo de comida; sector opcional.  
- Salida: totales autorizados vs. entregados, discriminados por comida y tipo de menú.  
- Reglas de negocio: —  
- Errores: —

### **Resúmenes**

#### `GET /api/summaries/requests — obtener el resumen de pedidos.`

- Rol(es): Servicio de Alimentación; Jefe de Servicio, limitado a su propio sector.  
- Entrada: filtros por query — rango de fechas, sector, tipo de comida, tipo de menú, agrupamiento (día/semana/mes, sector, comida, tipo de menú).  
- Salida: totales de comidas pedidas, agrupados según el filtro.  
- Reglas de negocio: si lo llama un Jefe de Servicio, se limita a su propio sector.  
- Errores: —

&nbsp;

  #### `GET /api/summaries/authorizations — obtener el resumen de autorizaciones.`

- Rol(es): Servicio de Alimentación.  
- Entrada: los mismos filtros que el resumen de pedidos.  
- Salida: totales pedidos vs. autorizados, con la diferencia entre ambos.  
- Reglas de negocio: —  
- Errores: —

  #### 

  #### `GET /api/summaries/deliveries — obtener el resumen de entregas.`

- Rol(es): Servicio de Alimentación.  
- Entrada: los mismos filtros que el resumen de pedidos.  
- Salida: totales autorizados vs. entregados, con la diferencia entre ambos.  
- Reglas de negocio: —  
- Errores: —

# 

# **Requisitos técnicos y pautas de trabajo**

## 1 Requisitos técnicos

* El prototipo debe desarrollarse utilizando **Python**, **JavaScript**, **HTML5**, **CSS3** y **PostgreSQL**, respetando el modelo en capas **MVC**.  
* Seguir las guías de estilo de Python y documentar todo el código Python con **docstrings**.  
* Uso obligatorio de **Jinja** como motor de plantillas para la aplicación privada.  
* La aplicación privada debe desarrollarse con el framework **Flask**.  
* Validar todos los datos de entrada tanto en el cliente como en el servidor.  
  * Las validaciones del lado del servidor deben implementarse en un módulo aparte que reciba los datos y devuelva el resultado.  
  * Ejemplos de validaciones: solo números en un DNI, solo caracteres válidos para un nombre, opciones de lista que pertenezcan al conjunto permitido, etc.  
* **Contraseñas**: deben almacenarse utilizando hash seguro (bcrypt, Argon2 o equivalente).  
  **Seguridad contra inyección SQL**: toda interacción con la base de datos debe realizarse a través de **SQLAlchemy** para evitar inyecciones SQL.  
* Se permite el uso de librerías que facilitan tareas (conexiones a servicios externos, parseo, patrones de buenas prácticas, validaciones de datos, etc.), siempre que todos los miembros del equipo puedan explicar su funcionamiento y propósito. Consultar con el ayudante si el uso de la misma está permitido.  
* **Login:** no se permite el uso de librerías que abstraiga completamente el proceso (por ejemplo, Flask-Login), para asegurar comprensión de la implementación.  
* Para la interacción con la base de datos, utilizar **SQLAlchemy** como ORM para mantener una capa de abstracción.  
* Aplicar buenas prácticas de **semántica web en HTML5**, usando correctamente las etiquetas del lenguaje.  
* Versionar todas las entregas con **git**, siguiendo **Versionado Semántico** (por ejemplo, etapa 1 → v1.x.x).  
* Se permite el uso de frameworks CSS como **Bootstrap**, **Foundation**, **Bulma** o **Tailwind CSS**.  
* **Manejo de logs**: implementar registro básico de eventos y errores en backend para facilitar depuración.  
* **Control de dependencias**: mantener actualizados y controlados pyproject.toml (Poetry) y package.json con versiones definidas para evitar incompatibilidades.  
* Todas las vistas deben ser **responsive** contemplando al menos tres resoluciones cómo mínimo (si quiere utilizar las sugeridas por el framework que utilice comuníquelo al ayudante):  
  * \< 767px (móviles)  
  * 768px – 1024px (tablets)  
  * \> 1025px (portátiles y escritorio)

  ## 2 Pautas de trabajo y entrega

* La entrega es obligatoria. Todos los integrantes deben participar en la defensa.  
* El ayudante evaluará el progreso y participación mediante consultas online y seguimiento en **GitLab**.  
* El proyecto se deberá realizar en grupos de **cinco integrantes**.  
* Deben ser visibles los aportes de cada integrante tanto en **GitLab** como en la defensa.  
* Si bien las tareas deberán dividirse entre los integrantes para organizar el trabajo, todos los miembros del equipo deberán comprender el funcionamiento integral del sistema y ser capaces de responder preguntas sobre cualquiera de sus componentes.  
* La defensa será virtual, salvo que se acuerde presencial por falta de medios técnicos (**micrófono y cámara**).  
* El trabajo será evaluado desde el **servidor de la cátedra**. No se aceptarán entregas fuera del tiempo y forma establecidos.  
* Funcionalidades no terminadas en la etapa 1 podrán completarse en la etapa siguiente.

  ## 3 Información del servidor

* **Lenguaje:** Python 3.14.4  
* **Servidor web:** nginx/1.28.3 (Ubuntu)  
* **Dependencias Python:** Poetry 2.4.1  
* **Base de datos:** PostgreSQL 16

&nbsp;

[image1]: <data:image/png;base64,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>

[image2]: <data:image/png;base64,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>