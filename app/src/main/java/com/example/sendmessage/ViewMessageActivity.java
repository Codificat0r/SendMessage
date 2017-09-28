package com.example.sendmessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ViewMessageActivity extends AppCompatActivity {

    private TextView txvViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        txvViewMessage = (TextView) findViewById(R.id.txvViewMessage);

        //1. Recoger el intent que se ha enviado
        //getIntent();
        //2. Recoger el mensaje del Bundle
        //Bundle bundle = new Bundle();
        //3. Mostrar mensaje. Como ya esta en memoria, y el contexto de esta activity tiene parte del otro porque lo hemos compartido en el intent,
        //pero los contextos son diferentes de una Activity a otra
        //no volvemos a crear los objetos. Cogemos el intent, cogemos el bundle con getExtras, y accedemos al
        //string con su key.
        txvViewMessage.setText(getIntent().getExtras().getString("message"));
    }
}
