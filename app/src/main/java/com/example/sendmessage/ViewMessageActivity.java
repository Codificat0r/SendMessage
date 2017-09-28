package com.example.sendmessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Esta clase recibe el mensaje de un usuario y lo muestra en pantalla.
 * @author Carlos Cruz Domínguez
 * <u>Conceptos aprendidos:</u>
 * <ul>
 *     <li>Concepto Context</li>
 *     <li>Paso de parámetros mediante el objeto Bundle</li>
 *     <li>Paso de mensajes entre dos actividades mediante la clase <a href="https://developer.android.com/reference/android/content/Intent.html">Intent</a></li>
 * </ul>
 */

public class ViewMessageActivity extends AppCompatActivity {

    private TextView txvViewMessage;
    private TextView txvViewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        txvViewMessage = (TextView) findViewById(R.id.txvViewMessage);
        txvViewUser = (TextView) findViewById(R.id.txvViewUser);

        //1. Recoger el intent que se ha enviado
        //getIntent();
        //2. Recoger el mensaje del Bundle
        //Bundle bundle = new Bundle();
        //3. Mostrar mensaje. Como ya esta en memoria, y el contexto de esta activity tiene parte
        //del otro porque lo hemos compartido en el intent, pero los contextos son diferentes de una
        //Activity a otra no volvemos a crear los objetos. Cogemos el intent, cogemos el bundle con
        //getExtras, y accedemos al string con su key.
        txvViewMessage.setText(getIntent().getExtras().getString("message"));
        //Recogemos el string de R, ya no es un layout o un elemento gráfico, ya no es id. Al ser una referencia
        //el R.string.txvViewUser, pues tenemos que recoger la cadena con getResources().getString().
        String viewUser = String.format(getResources().getString(R.string.txvViewUser), getIntent().getExtras().getString("user"));
        txvViewUser.setText(viewUser);
    }
}
