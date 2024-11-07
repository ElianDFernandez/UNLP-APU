<div style="text-align: center;" markdown="1">

<h2>Ejercicio 1</h2>

Cliente(idCliente, nombre, apellido, DNI, telefono, direccion)  
Factura (nroTicket, total, fecha, hora,idCliente(Fk))  
Detalle(nroTicket, idProducto, cantidad, preciounitario)  
Producto(idProducto, nombreP, descripcion, precio, stock)  

</div>

* 1. Listar nombre, apellido, DNI, teléfono y dirección de clientes con DNI superior a 22222222.

            π nombre,apellido,DNI,telefono,direccion(σ DNI > 22222222 (Cliente))

* 2. Listar nombre, apellido, DNI, teléfono y dirección de clientes con DNI superior a 22222222 y que tengan facturas cuyo total no supere los $100000.

            π nombre,apellido,DNI,telefono,direccion(σ(DNI > 22222222)^(total > 100000) Clientes |x| Factura)

* 3. Listar nombre, apellido, DNI, teléfono y dirección de clientes que realizaron compras durante 2020.

            π nombre,apellido,DNI,telefono,direccion(σ(Fecha <= 01/01/2020) ^ (Fecha>= 31/12/2020) (Clientes |x| Factura))

* 4. Listar nombre, apellido, DNI, teléfono y dirección de clientes que no realizaron compras durante 2020.

            Compradores2020 <= π nombre,apellido,DNI,telefono,direccion(σ(Fecha <= 01/01/2020) ^ (Fecha>= 31/12/2020) (Clientes |x| Factura)) 
            π nombre,apellido,DNI,telefono,direccion(Cliente-Compradores2020) 


* 5. Listar nombre, apellido, DNI, teléfono y dirección de clientes que solo tengan compras durante 2020.

            Antes2020 <= π nombre,apellido,DNI,telefono,direccion(σ(Fecha < 01/01/2020) (Clientes |x| Factura))
            Despues2020 <= π nombre,apellido,DNI,telefono,direccion(σ(Fecha > 01/01/2020) (Clientes |x| Factura))
            π nombre,apellido,DNI,telefono,direccion(Cliente - (Antes2020 U Despues2020))

* 6. Listar nombre, descripción, precio y stock de productos no vendidos.

            Vendidos <= π nombre,descripcion,precio,stock (Producto |x| Detalle)
            π nombre,descripcion,precio,stock (Producto - Vendidos)

* 7. Listar  nombre, apellido, DNI, teléfono y dirección de clientes que no compraron el producto con nombre ‘ProductoX’ durante 2020.

            CompraProd2020 <= π nombre,apellido,DNI,telefono,direccion(σ(nombreP = ‘ProductoX’) ^ (Fecha <= 01/01/2020) ^ (Fecha>= 31/12/2020) (Cliente |X| Factura |X| Detalle |X| Producto))

            π nombre,apellido,DNI,telefono,direccion(Cliente - CompraProd2020)

* 8. Listar  nombre, apellido, DNI, teléfono y dirección de clientes que compraron el producto con nombre
‘Producto A’’ y no compraron el producto con nombre ‘Producto B’.

            CompraProdA <= π nombre,apellido,DNI,telefono,direccion(σ(nombreP = ‘ProductoA’) (Cliente |X| Factura |X| Detalle |X| Producto))

            CompraProdB <= π nombre,apellido,DNI,telefono,direccion(σ(nombreP = ‘ProductoB’) (Cliente |X| Factura |X| Detalle |X| Producto))

            π nombre,apellido,DNI,telefono,direccion(CompraProdA - CompraProdB)

* 9. Listar nroTicket, total, fecha, hora y DNI del cliente, de aquellas  facturas donde se haya comprado el
producto ‘Producto C’.

            π nroTicket,total,fecha,hora,DNI(σ(nombreP = ‘ProductoC’) (Cliente |X| Factura |X| Detalle |X| Producto))

* 10. Agregar un producto con id de producto 1000, nombre “Producto Z”, descripción “mi producto”, precio
$10000 y stock 1000. Se supone que el idProducto 1000 no existe

            Producto <= Producto U {(1000,"producto z", "mi Producto", 10000, 1000)}