package com.example.sendmessage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {

    private EditText edtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        edtMessage = (EditText)findViewById(R.id.edtMessage);
    }

    public void getOnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnOk:
                //1. Recoger el mensaje

                //2. Crear un objeto Bundle y añadir el mensaje, con un conjunto de clave valor.
                Bundle bundle = new Bundle();
                bundle.putString("message",edtMessage.getText().toString());
                //3. Crear un objeto Intent. Tenemos que poner el contexto y la clase destinataria.
                //Por nomenclatura usamos el nombre de la clase tambien en el this. Accedemos al contexto
                //de la activity.
                Intent intent = new Intent(SendMessageActivity.this,ViewMessageActivity.class);
                //4. Añadir el Bundle al Intent
                intent.putExtras(bundle);
                //5. Iniciar la Activity ViewMessage
                startActivity(intent);
                break;
        }
    }
}
