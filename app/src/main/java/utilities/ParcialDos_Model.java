package utilities;

import java.util.Map;

/**
 * Clase de emulación de datos.
 */
public class ParcialDos_Model {

    public ParcialDos_Model(int numeroPregunta, String pregunta, Map<Integer, String> opciones, int respuestaCorrecta){
        this.NumeroPregunta = numeroPregunta;
        this.Pregunta = pregunta;
        this.Opciones = opciones;
        this.RespuestaCorrecta = respuestaCorrecta;
    }

    public int NumeroPregunta;
    public String Pregunta;
    public Map<Integer, String> Opciones;
    public int RespuestaCorrecta;
}
