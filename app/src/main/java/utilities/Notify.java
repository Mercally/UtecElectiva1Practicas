package utilities;

import android.content.Context;
import android.widget.Toast;

/**
 * Encapsula los métodos de notificación.
 */
public class Notify {

    /**
     * Muestra un Toast.makeText(...).show();.
     * @param context Contexto.
     * @param text Texto a mostrar.
     * @param duration Duración del Toast { Toast.LENGTH_LONG, Toast.LENGTH_SHORT }.
     */
    public static void Show(Context context, CharSequence text, int duration){
        Toast
                .makeText(context, text, duration)
                .show();
    }
}
