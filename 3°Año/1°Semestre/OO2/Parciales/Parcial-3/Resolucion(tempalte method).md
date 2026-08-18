Patrones OO2 - Parcial 27/06/2026

Una universidad necesita generar distintos informes académicos para sus alumnos. La generación de cualquier informe sigue siempre un mismo flujo general: recuperar los datos necesarios, realizar transformaciones sobre esos datos (por ejemplo filtrado u ordenamiento cuando corresponda), redactar el contenido del informe y finalmente exportarlo a un archivo. Dependiendo del tipo de informe, algunos pasos del proceso pueden no requerir ninguna acción adicional.

La generación de un informe se inicia indicando el legajo del alumno.

Se necesitan generar los siguientes informes:

Certificado de alumno regular: contiene los datos básicos del alumno (nombre, legajo, carrera y condición) junto con la cantidad de materias rendidas. El resultado se exporta en formato PDF.

Historia académica: contiene los datos básicos del alumno junto con el detalle de las materias rendidas (materia, nota y fecha), presentadas en orden cronológico. El resultado se exporta en formato PDF.

Informe de rendimiento: reutiliza la misma información presentada en la historia académica e incorpora además el promedio general del alumno. El resultado se exporta en formato CSV.

Se requiere extender el siguiente diseño utilizando el patrón Template Method para incorporar el mecanismo de generación de informes.

(El documento incluye un diagrama UML con las clases: RepositorioAcademico, Alumno, MateriaRendida, Informe y Exportador)

Patrones - Actividades:

Explique con sus palabras (entre 2 y 5 renglones) cuál es el objetivo del patrón elegido.

Realice el diagrama UML incorporando el patrón.

Indique en el diagrama UML los roles en las clases participantes.

¿Cuál o cuáles son los métodos plantilla en su solución?

¿Cuál o cuáles son los métodos gancho en su solución?

Implemente lo necesario para poder generar la historia académica de un alumno.

**Solución:**

1. El patron Template Method tiene como objetivo definir un esqueleto de un algoritmo en una operacion, dejando que los algunos pasos sean implementados por las subclases. Esto permite que las subclases redefinan ciertos pasos del algoritmo sin cambiar su estructura general.

2. Diagrama UML:

```plantuml
@startuml
class <<abstract>> GeneradorInforme {
    - repositorio: RepositorioAcademico
    + generarInforme(legajo: String): void
    + transformarDatos(alumno: Alumno, materias: List<MateriaRendida>): void
    + redactarInforme(alumno: Alumno, materias: List<MateriaRendida>): Informe
    + exportarInforme(informe: Informe): void
}

class GeneradorHistoriaAcademica {
    + transformarDatos(alumno: Alumno, materias: List<MateriaRendida>): void
    + redactarInforme(alumno: Alumno, materias: List<MateriaRendida>): Informe
    + exportarInforme(informe: Informe): void
}
GeneradorInforme <|-- GeneradorHistoriaAcademica

class GeneradorCertificadoAlumnoRegular {
    + transformarDatos(alumno: Alumno, materias: List<MateriaRendida>): void
    + redactarInforme(alumno: Alumno, materias: List<MateriaRendida>): Informe
    + exportarInforme(informe: Informe): void
}
GeneradorInforme <|-- GeneradorCertificadoAlumnoRegular

class GeneradorInformeRendimiento {
    + transformarDatos(alumno: Alumno, materias: List<MateriaRendida>): void
    + redactarInforme(alumno: Alumno, materias: List<MateriaRendida>): Informe
    + exportarInforme(informe: Informe): void
}
GeneradorHistoriaAcademica <|-- GeneradorInformeRendimiento

3. Roles en las clases participantes:

GeneradorInforme: Clase abstracta que define el esqueleto del algoritmo de generación de informes.

GeneradorHistoriaAcademica / GeneradorCertificadoAlumnoRegular / GeneradorInformeRendimiento: Clases concretas que implementan los pasos específicos del algoritmo de generación de informes.

4. Métodos plantilla en la solución:
- generarInforme(legajo: String): void

5. Métodos gancho en la solución:
- transformarDatos(alumno: Alumno, materias: List<MateriaRendida>): void
- redactarInforme(alumno: Alumno, materias: List<MateriaRendida>): Informe
- exportarInforme(informe: Informe): void

Los metodos Plantilla son aquellos que definen la estructura general del algoritmo, mientras que los métodos gancho son aquellos que permiten a las subclases personalizar ciertos pasos del algoritmo sin cambiar su estructura general.

6. 
```
// Template Method
class abstract GeneradorInforme {
    RepositorioAcademico repositorio;

    public GeneradorInforme(RepositorioAcademico repositorio) {
        this.repositorio = repositorio;
    }

    public void generarInforme(String legajo) {
        Alumno alumno = repositorio.buscarAlumno(legajo);
        List<MateriaRendida> materias = repositorio.obtenerMateriasRendidas(legajo);

        transformarDatos(alumno, materias);

        Informe informe = redactarInforme(alumno, materias);

        return exportarInforme(informe);
    }

    public abstract void transformarDatos(Alumno alumno, List<MateriaRendida> materias);
    public abstract Informe redactarInforme(Alumno alumno, List<MateriaRendida> materias);
    public abstract void exportarInforme(Informe informe);
}

public class GeneradorHistoriaAcademica extends GeneradorInforme {

    public GeneradorHistoriaAcademica(RepositorioAcademico repositorio) {
        super(repositorio);
    }r

    @Override
    public void transformarDatos(Alumno alumno, List<MateriaRendida> materias) {
        // Ordenar materias por fecha
        Collections.sort(materias, Comparator.comparing(MateriaRendida::getFecha));
    }

    @Override
    public Informe redactarInforme(Alumno alumno, List<MateriaRendida> materias) {
        Informe informe = new Informe();
        informe.agregeLinea("Nombre: " + alumno.getNombre());
        informe.agregeLinea("Legajo: " + alumno.getLegajo());
        informe.agregeLinea("Carrera: " + alumno.getCarrera());
        informe.agregeLinea("Materias rendidas:");
        for (MateriaRendida materia : materias) {
            informe.agregeLinea(" - " + materia.getNombre() + ": " + materia.getNota() + " (" + materia.getFecha() + ")");
        }
        return informe;
    }

    @Override
    public void exportarInforme(Informe informe) {
        ExportadorPDF exportador = new ExportadorPDF();
        exportador.exportar(informe);
    }
}
```