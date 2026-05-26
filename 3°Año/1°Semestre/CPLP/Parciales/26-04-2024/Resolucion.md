# Ejercicio 1

Gramatica BNF swtich en JAVA

G=(N,T,S,P)

P={
    <switch> ::= "switch" "(" <expresion> ")" "{" <cases> <default> "}" | "switch" "(" <expresion> ")" "{" <cases> "}" |  "switch" "(" <expresion> ")" "{" "}"

    <expresion> ::= <valor> | <valor><operador><expresion>

    <cases> ::= <case> | <case><cases>

    <default> ::= "default" ":" <sentencias>

    <identificador> ::= <letra> | <identificador><letra> | <identificador><digito> | <identificador> "_"

    <valor> ::= <digito> | <digito><valor> | <identificador>

    <operador> ::= "+" | "-" | "/" | "*"

    <case> ::= "case" <valor> ":" <sentencias>

    <setencias> ::= <sentencia> | <sentencia><setencias>

    <sentencia> ::= <sentencia_if> | <sentencia_for> | <sentencia_while> | ...

    <digito> ::= 0|1|2|3|4|5|6|7|8|9

    <letra> ::= A|...|Z|a|...|z
}

** Ejercico fuera de parcial

Gramatica BNF FOR en JAVA

P={
    <for> ::= "for" "(" <inicializacion> ";" <condicion> ";" <actualizacion> ")" "{" <cuerpo> "}"

    <inicializacion> ::= <identificador> "=" <valor> | <tipo> <identificador> "=" <valor>

    <condicion> ::= <identificador> <comparacion> <valor>

    <actualizacion> ::= <identificador> "++" | <identificador> "--" | <identificador> "=" <expresion>

    <expresion> ::= <termino> | <expresion> <op_suma> <termino>
    
    <termino>    ::= <factor> | <termino> <op_mult> <factor>
    
    <factor>     ::= <valor> | "(" <expresion> ")"
    
    <op_suma>    ::= "+" | "-"
    
    <op_mult>    ::= "*" | "/"

    <numero> ::= <digito> | <numero> <digito>

    <tipo> ::= "int" | "double" | "float"

    <identificador> ::= <letra> | <identificador> <letra> | <identificador> <digito> | <identificador> "_"

    <comparacion> ::= "==" | "!=" | ">" | "<" | "<=" | ">="

    <operador> ::= "+" | "-" | "*" | "/"

    <cuerpo> ::= <sentencia> | <cuerpo> <sentencia>

    <sentencia> ::= <sentencia_if> | <sentencia_for> | <sentencia_while> | ...

    <digito> ::= "0"|"1"|"2"|"3"|"4"|"5"|"6"|"7"|"8"|"9"

    <letra> ::= "A"|...|"Z"|"a"|...|"z"
}

Gramatica BNF de URL

P={
    <url> ::= <protocolo> "://" <dominio> <ruta_opcional>

    <protocolo> ::= "https" | "http" | "ftp"

    <dominio> ::= <palabra> "." <palabra> | <palabra> "." <dominio>

    <ruta_opcional> ::= "/" <ruta> | "/" | <vacio>

    <ruta> ::= <palabra> "/" <ruta> | <pagina>

    <pagina> ::= <archivo> | <archivo> "?" <parametros>

    <archivo> ::= <palabra> "." <extension> | <palabra>

    <parametros> ::= <palabra> "=" <palabra> | <palabra> "=" <palabra> "&" <parametros>

    <extension> ::= "com" | "ar" | "html" | "php" | "js" 

    <palabra> ::= <caracter> | <caracter> <palabra>

    <caracter> ::= <letra> | <digito> | "-" | "_"

    <digito> ::= "0"|"1"|"2"|"3"|"4"|"5"|"6"|"7"|"8"|"9"

    <letra> ::= "a"|...|"z"|"A"|...|"Z"

    <vacio> ::= 
}

