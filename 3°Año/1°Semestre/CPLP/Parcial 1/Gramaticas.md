# Gramaticas pedidas en Parciales

## SWITH en JAVA en BNF

G = (N, T, S, P)

P = {
    <switch> ::= "switch" "(" <expresion> ")" "{" <cuerpo> "}"

    <expresion> ::= <valor> | <expresion> <operador> <expresion> |
                    <identificador> "(" <parametros> ")" | <identificador> "()" |
                    "!"<identificador>

    <identificador> ::= <letra> | <letra> <resto_identificador>
    
    <resto_identificador> ::= <caracter> | <caracter> <resto_identificador>

    <caracter> ::= <letra> | <digito>

    <operador> ::= "+" | "-" | "*" | "/" | "<" | ">" | "!=" | "==" | "<=" | ">="

    <parametros> ::= <parametro> | <parametro> "," <parametros>

    <parametro> ::= <identificador> | <digito> | <caracter>

    <letra> ::= A | ... | Z | a | ... | z

    <digito> ::=  0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

    <cuerpo> ::= <casos> | <casos> <default> | <default>

    <casos> ::= <caso> | <caso> <casos>

    <caso> ::= "case" <valor> ":" <instrucciones>

    <default> ::= "default" ":" <instrucciones>

    <valor> ::= <digito> | "'" <letra> "'" | <identificador>

    <instrucciones> ::= <instruccion> | <instruccion> <instrucciones>

    <instruccion> ::= <sentencia> ";" | "break" ";"

    <sentencia> ::= <identificador> "=" <expresion> | <identificador> "(" <parametros> ")" | <identificador> "("")"
}

## SWITH en JAVA en EBNF

P = {
    <switch> ::= "switch" "(" <expresion> ")" "{" <cases> "}"
    
    <expresion> ::= <valor> | <expresion> <operador> <expresion> |
                <identificador> "(" <parametros> ")" | <identificador> "()" |
                "!"<identificador>
        
    <cases> ::= { <case> } [ <default> ]

    <case> ::= "case" <valor> ":" <instrucciones>

    <default> ::= "default" ":" <instrucciones>

    <valor> ::= <identificador> | "'" <letra> "'" | <numero>

    <numero> ::= <digito> { <digito> }

    <digito> ::= 0|1|2|3|4|5|6|7|8|9

    <letra> ::= A|...|Z|a|...|z

    <instrucciones> ::= {<instruccion>}

    <instruccion> ::= <sentencia> ";"| "break" ";"

    <setencia> ::= <identificador> "=" <valor> | <identificador> "(" <parametros> ")" | <identificador> "()"

    <parametros> ::= <parametro> { "," <parametro> }

    <parametro> ::= <identificador> | <valor>

    <identificador> ::= <letra> { <letra> | <digito> }

    <operador> ::= "+" | "-" | "*" | "/" | "<" | ">" | "!=" | "==" | "<=" | ">="
}

## Definicion de funcion en C con EBNF

P = {
    <funcion> ::= <tipo> <identificador> "(" [<parametros>] ")" "{" <instrucciones> <retorno> "}"

    <tipo> ::=  ("int" | "void" | "double" | "char" | <identificador>)

    <identificador> ::= <letra> {<letra> | <digito>}

    <parametros> ::= <parametro> {"," <parametro>}

    <parametro> ::= <tipo><identificador>

    <instrucciones> ::= {<instruccion>}

    <instruccion> ::= <instruccion_if> | <instruccion_for> | <instruccion_while> | <llamado_funcion> ";" | <asignacion> ";"

    <retorno> ::= "return" (<identificador> | <numero>) ";"

    <numero> ::= <digito> {<digito>}
}

