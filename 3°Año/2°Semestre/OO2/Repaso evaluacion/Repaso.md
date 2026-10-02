# Ejercicios Arboles

Escriba un pseudocódigo que permita detectar el code smell indicado considerando el código fuente escrito en pool, y el árbol generado con antr lab.

1.

```
f(x) {
   a = x ? 3 : 3 
}
```
Code Smell: Condicionales duplicados, ambas ramas del condicion son iguales.
Pseudocódigo:

```
1.Recorrer el arbol:
    i. Si el nodo es un condicional: 
        a. Comparar los subarboles siguientes (rama verdadera y rama falsa).
        b. Si son iguales, reportar code smell de condicionales duplicados.
```

2.

```
f(x) {
    a = 4;
    f(a);
    a = 5;
}
```
Code Smell: Parametro "x" no es utilizado en la función, lo que indica que el parámetro es innecesario.
Pseudocódigo:

```
1. Recorrer el arbol:
    i. Si el nodo es una función (def):
        b. Obtener la lista de parámetros de la función.
        c. Recorrer el cuerpo de la función para verificar si cada parámetro es utilizado.
        d. Si algún parámetro no es utilizado, reportar code smell de parámetro innecesario.
```

