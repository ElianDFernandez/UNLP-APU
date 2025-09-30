> ### Herusticas para asginacion de responsabilidades
Las herusticas son guias que nos ayudan a asignar responsabilidades a las clases y objetos en el diseño orientado a objetos. Estas herusticas no son reglas estrictas, sino recomendaciones basadas en buenas prácticas y principios de diseño. A continuación, se presentan algunas de las herusticas más comunes:

>1. **Experto** 
    - Asignar la responsabilidad a la clase que tiene la información necesaria para cumplir con la responsabilidad.
    - Ejemplo: Si una clase `Order` tiene la información sobre los productos y cantidades, entonces debería ser responsable de calcular el total del pedido.

>2. **Creador**
    - Asignar la responsabilidad de crear un objeto a la clase que tiene la información necesaria para hacerlo.
    - Ejemplo: Si una clase `Customer` tiene una lista de `Order`, entonces `Customer` debería ser responsable de crear nuevas instancias de `Order`.

>3. **Alta Cohesión**
    - Asignar responsabilidades de manera que las clases tengan alta cohesión, es decir, que sus responsabilidades estén estrechamente relacionadas.
    - Ejemplo: Una clase `Invoice` debería manejar todo lo relacionado con la facturación, como calcular totales, aplicar descuentos y generar el documento de la factura.

>4. **Baja Acoplamiento**
    - Asignar responsabilidades de manera que las clases tengan bajo acoplamiento, es decir, que dependan lo menos posible de otras clases.
    - Ejemplo: Si una clase `Payment` necesita información de una clase `Order`, debería recibir esa información a través de parámetros en lugar de acceder directamente a la clase `Order`.