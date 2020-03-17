package utilities;

import java.util.HashMap;

/**
 * Clase de almacen de datos.
 */
public class ParcialDos_Data {

    /**
     * Constructor para inicializar la data de las preguntas.
     */
    public ParcialDos_Data(){
        this.preguntas = new ParcialDos_Model[5];
        this.preguntas[0] = new ParcialDos_Model(1, "¿setText es para?", new HashMap<Integer, String>() {{
            put(1, "Borrar texto");
            put(2, "Asignar texto");
            put(3, "Ocultar texto");
        }}, 2);

        this.preguntas[1] = new ParcialDos_Model(2, "¿getText es para?", new HashMap<Integer, String>() {{
            put(1, "Borrar texto");
            put(2, "Asignar texto");
            put(3, "Recuparar el texto");
        }}, 3);

        this.preguntas[2] = new ParcialDos_Model(3, "¿Toast es para?", new HashMap<Integer, String>() {{
            put(1, "Cerrar la app");
            put(2, "Mostrar mensajes");
            put(3, "Sumar números");
        }}, 2);

        this.preguntas[3] = new ParcialDos_Model(4, "¿Finish es para?", new HashMap<Integer, String>() {{
            put(1, "Borrar texto");
            put(2, "Declarar variables");
            put(3, "Cerrar actividad");
        }}, 3);

        this.preguntas[4] = new ParcialDos_Model(5, "¿TextView es para?", new HashMap<Integer, String>() {{
            put(1, "Mostrar texto");
            put(2, "Multiplicar");
            put(3, "Dividir");
        }}, 1);
    }

    public ParcialDos_Model[] preguntas;
}
