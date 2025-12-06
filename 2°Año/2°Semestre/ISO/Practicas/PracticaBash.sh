# Practicando Bash
# Iterar sobre los home de los usuarios del sistema y listar su contenidio si tiene archivos de la extension pasada por 
parametro 
if [ $# -eq 0 ]; then 
    echo "Faltan parametros" 
    exit 1
fi

usuarios=$(cut -d : -f 1 /etc/passwd)

for usuario in $usuarios; do 
    if [ -d /home/$usuario ]; then # -d pregunta si es un directorio
        echo "Contenido de /home/$usuario con extension $1:" 
        find /home/$usuario -type f -name "*.$1"
    fi
done 

# Crear un reporte con la cantidad de archivos por usuario que tienen la extension pasada por parametro
if [ $# -eq 0 ]; then
    echo "Faltan parametros" 
    exit 1
fi

usuarios=$(cut -d : -f 1 /etc/passwd)
echo "Usuario Cantidad_de_Archivos" > reporte.txt
for usuario in $usuarios; do 
    if [ -d /home/$usuario ]; then # -d pregunta si es un directorio
        cantidad=$(find /home/$usuario -type f -name "*.$1" | wc -l) 
        if [ $cantidad -gt 0 ]; then 
            echo "$usuario $cantidad" >> reporte.txt 
        fi
    fi
done

# Crar un archivo con todos los nombres de usuarios y comprimirlo

usuario=$(cut -d : -f 1 /etc/passwd)
echo "$usuario" > usuarios.txt
tar -czf usuarios.tar.gz usuarios.txt 
# Si se quiere comprimir czf ( c: crear, z: comprimir con gzip, f: archivo), si se quiere empaquetar sin comprimir solo cf si se quiere empaquetar y comprimir cvzf (v: verbose)

# Comando grep para buscar dentro de archivos
grep "texto_a_buscar" archivo.txt

# Buscar recursivamente en todos los archivos de un directorio un texto
grep -r "texto_a_buscar" /ruta/del/directorio


    
# Ejercicio de parcial: Escriba un script que reciba una cantidad desconocida de parametros al momento de su invocacion (debe validar que lamenos se pase uno) Cada paremtro represnta la ruta de un archivo o directorio en el sistema. El script debera iterar todos los parametros recibidos y:
# Si el paramtro es un archivo existente ene l file system debera comprimir dejando el archiv comprimido en el lugar ddel original
# si el parametro es un directorio existente en el file system:
#   - Si tiene permiso de lectura debera empaquetarlo y comprimirlo 
#   - Si tiene perimiso de escritura debera eliminarlo junto con todo su contenido 
# - Si el aprametro no es un elemento del file system debverar contarlo e indicar la cantidad total al finalizar la ejecucion del script

if [ $# -eq 0 ]; then
    echo "Se debe pasar al menos un parametro"
    exit 1
fi

no_existen=0
for elemento in "$@"; do 
    if [ -f "$elemento" ]; then  # es un archivo
        tar -czf "$elemento.tar.gz" "$elemento"
        echo "Archivo $elemento comprimido a $elemento.tar.gz"
    elif [ -d "$elemento" ]; then # es un directorio
        if [ -r "$elemento" ]; then # tiene permiso de lectura
            tar -czf "$elemento.tar.gz" "$elemento"
            echo "Directorio $elemento empaquetado y comprimido a $elemento.tar.gz"
        fi
        if [ -w "$elemento" ]; then # tiene permiso de escritura
            rm -rf "$elemento"
            echo "Directorio $elemento eliminado"
        fi
    else
        no_existen=$((no_existen + 1))
    fi
done 

echo "Cantidad de elementos que no existen: $no_existen"

# Comandos utiles 
# wc -l : cuenta lineas
# cut -d : -f 1 /etc/passwd : corta el primer campo de un archivo delimitado por :
# find /ruta -type f -name "*.ext" : busca archivos con extension .ext en la ruta dada, si no se da ruta busca en el directorio actual
# tar -czf archivo.tar.gz carpeta_o_archivo : crea un archivo comprimido con gzip
# grep "texto" archivo : busca "texto" dentro de archivo
# grep -r "texto" /ruta : busca recursivamente "texto" en todos los archivos dentro de /ruta
# rm carpeta : elimina una carpeta y todo su contenido
# rm archivo : elimina un archivo
# pwd : muestra el directorio actual
# ls -l : lista archivos con detalles
# chmod +x archivo.sh : da permiso de ejecucion a un script
# chmod -r archivo.sh : da permiso de lectura a un archivo
# chmod -w archivo.sh : quita permiso de escritura a un archivo. Permisos a usuario especifico: chmod u+x archivo.sh (u: user, g: group, o: others, a: all)
# $0 : nombre del script
# $1, $2, ... : parametros pasados al script
# $# : cantidad de parametros pasados al script
# $@ : todos los parametros pasados al script como una lista
# if [ condicion ]; then ... fi : estructura condicional
# for var in lista; do ... done : estructura de bucle
# exit codigo : termina la ejecucion del script con el codigo dado (0: exito, !=0: error)
# Operadores aritmeticos en bash: +, -, *, /, %
# Comparaciones en bash: -eq, -ne, -gt, -lt, -ge, -le: igual, no igual, mayor que, menor que, mayor o igual, menor o igual
# Para comparar cadenas: =, !=, <, >, <=, >=
# Para comparar numeros enteros en expresiones aritmeticas: (( num1 > num2 ))

# Ejercicio 2 de parcial
# Realice un script que agrega todos los nombres de usuario del sistgema a un arreglo e implemente las siguiente funciones:
# - existe <Parametro>: Devuelve 0 si el usuario existene en el arreglo, 1 en caso contrario
# - eliminar_usuario<Paramtro1>: Elimina el usuario pasado como parametro del arreglo si existe. Caso contrario devuelve codigo de error 2
# - usuarios_con_patron <Parametro1>: Devuelve un arreglo con todos los usuarios que contienen el patron pasado como parametro. Si no hay usuarios que cumplan con el patron devuelve error con codigo 102
# - cantidad: Devuelve la cantidad total de usuarios en el arreglo. Si esta vacio deuvleve el error codigo 95
# - usuarios imprimie todos los nombres de los usuarios que estan en el arreglo. Si esta vacio error codigo 95

#!/bin/bash
usuarios=($(cut -d: -f1 /etc/passwd))
existe() {
    for usuario in "${usuarios[@]}"; do 
        if (( usuario == "$1" )); then 
            return 0
        fi
    done
    return 1
}

eliminar_usuario() {
    for i in "${!usuarios[@]}"; do 
        if (( usuarios[i] == "$1" )); then 
            unset 'usuarios[i]'
            return 0
        fi
    done
    return 2
}

usuarios_con_patron() {
    local patron="$1"
    local encontrados=()
    for usuario in "${usuarios[@]}"; do 
        if [[ "$usuario" == *"$patron"* ]]; then 
            encontrados+=("$usuario")
        fi
    done
    if (( ${#encontrados[@]} == 0 )); then 
        return 102
    fi
    echo "${encontrados[@]}"
    return 0
}

cantidad() {
    if (( ${#usuarios[@]} == 0 )); then 
        return 95
    fi
    echo "${#usuarios[@]}"
    return 0
}

imprimir_usuarios() {
    if (( ${#usuarios[@]} == 0 )); then 
        return 95
    fi
    for usuario in "${usuarios[@]}"; do 
        echo "$usuario"
    done
    return 0
}

# Ejemplo de uso de las funciones
imprimir_usuarios
echo "Cantidad de usuarios: $(cantidad)"
if existe "root"; then
    echo "El usuario root existe"
else
    echo "El usuario root no existe"
fi
eliminar_usuario "nobody"
echo "Usuarios con patron 'adm': $(usuarios_con_patron "adm")"
# Fin del script

# Ejemplo menu Select
#!/bin/bash
echo "Seleccione una opcion:"
select opcion in "Opcion 1" "Opcion 2" "Opcion 3" "Salir"; do 
    case $REPLY in
        1) echo "Selecciono Opcion 1";;
        2) echo "Selecciono Opcion 2";;
        3) echo "Selecciono Opcion 3";;
        4) echo "Saliendo..."; break;;
        *) echo "Opcion invalida";;
    esac
done
# Fin del script

# Mismo menu implementado con while y read
#!/bin/bash
while true; do
    echo "Seleccione una opcion:"
    echo "1) Opcion 1"
    echo "2) Opcion 2"
    echo "3) Opcion 3"
    echo "4) Salir"
    echo "Ingrese su opcion: "
    read opcion
    case $opcion in
        1) echo "Selecciono Opcion 1";;
        2) echo "Selecciono Opcion 2";;
        3) echo "Selecciono Opcion 3";;
        4) echo "Saliendo..."; break;;
        *) echo "Opcion invalida";;
    esac
done
# Fin del script