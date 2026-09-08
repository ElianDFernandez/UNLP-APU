# Semaforos 

Semaforo => instancia de un tipo de dato abstracto (O un objeto) con solo 2 operaciones (metoso) atomicas: P y V.

Internamente el valor de un semaforo es un evento no nefativo:
- V -> Señala la ocurrencia de un evento (incrementa el valor del semaforo)
- P -> Espera a que ocurra un evento (decrementa el valor del semaforo)





## Pracitca 

int cant = 0;
sem mutex = 1;

Process Chico[id: 1..N] {
    while (true) {
        P(mutex);
        --tomar caramelo
        cant++;
        V(mutex);
        --comer caramelo
    }
}

Hay C chicos y hay una bolsa con caramelos limitada a N caraemlos. Los chicos de a UNO van sacando de a UN caramelo y lo comen. Los chicos debem llevar la cuenta de cuantos caramelos se han tomado de la bolsa.

int cant = 0;
sem mutex = 1;

Process Chico[id: 1..C] {
    P(mutex);
    while (cant < N) {
        --tomar caramelo
        cant++;
        V(mutex);
        --comer caramelo
        P(mutex);
    }
    V(mutex);
}