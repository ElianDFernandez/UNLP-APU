# Ejercicio 1 

EBNF Gramatica para una funcion de C

G=(N,T,S,P)

P={
    <funcion> ::= <tipo> <identificador> ( <parametros> ) { <cuerpo> <retorno> }

    <tipo> ::= int | float | void | char | double | <identificador>

    <identificador> ::= <letra> { <letra> | <digito> | _ }

    <letra> ::= a | b | c | ... | z | A | B | C | ... | Z

    <digito> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

    <parametros> ::= <parametro> { , <parametro> }

    <parametro> ::= <tipo> <identificador>

    <cuerpo> ::= <sentencia> { <sentencia> }

    <sentencia> ::= <sentencia_if> | sentencia_while> | <sentencia_for> | <sentencia_asignacion> ;

    <retorno> ::= return <identificar> ; | return <valor> ;

    <valor> ::= {<digito>}+
}

N= { <funcion>, <tipo>, <identificador>, <letra>, <digito>, <parametros>, <parametro>, <cuerpo>, <sentencia>, <sentencia_if>, <sentencia_while>, <sentencia_for>, <sentencia_asignacion>, <retorno>, <valor> }

T= { int, float, void, char, double, a, b, c, ..., z, A, B, C, ..., Z, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, (, ), {, }, ;, return }

S= <funcion>

BNF

P={
    <funcion> ::= <tipo> <identificador> ( <parametros> ) { <cuerpo> <retorno> }

    <tipo> ::= int | float | void | char | double | <identificador>

    <identificador> ::= <letra> | <letra> <identificador> | <digito><identificador> | _ <identificador>

    <letra> ::= a | b | c | ... | z | A | B | C | ... | Z

    <digito> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

    <parametros> ::= <parametro> | <parametro> , <parametros>
    
    <parametro> ::= <tipo> <identificador>

    <cuerpo> ::= <sentencia> | <sentencia> <cuerpo>

    <sentencia> ::= <sentencia_if> | sentencia_while> | <sentencia_for> | <sentencia_asignacion> ;

    <retorno> ::= return <identificar> ; | return <valor> ;

    <valor> ::= <digito> | <digito> <valor>
}

