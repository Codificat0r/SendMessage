package com.example.sendmessage;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.sendmessage.pojo.Message;

/**
 * Esta clase envía un mensaje de un usuario a otro.
 * @author Carlos Cruz Domínguez
 */

public class SendMessageActivity extends AppCompatActivity{

    private EditText edtMessage;
    private EditText edtUser;
    private Button btnOk;
    private Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        edtMessage = (EditText)findViewById(R.id.edtMessage);
        edtUser = (EditText)findViewById(R.id.edtUser);
        btnOk = (Button)findViewById(R.id.btnOk);
        //Vamos a ver otra manera de ejecutar codigo al clickar en el boton, con el evento onClick.
        //1. Registrar un Listener o Escuchador OnClickListener. Usamos una clase anonima.
        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                message = new Message(edtMessage.getText().toString(), edtUser.getText().toString());
                Bundle bundle = new Bundle();
                //bundle.putString("message",edtMessage.getText().toString());
                //bundle.putString("user", edtUser.getText().toString());
                //Al ser serializable la clase (implementar el interfaz serializable) podemos pasarla en el bundle. La
                //recogemos en la otra activity con getSerializable.
                bundle.putSerializable("message", message);
                Intent intent = new Intent(SendMessageActivity.this,ViewMessageActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
        );
        //Clear esa clase anonima es lo mismo que crear una class que implemente la interfaz View.OnClickListener:
        //class MyListener implements View.OnClickListener. Si nos pieden, por ejemplo, una app con 5 botones ya si
        //usamos una clase normal y le ponemos un new MyListener a cada boton.
        Log.d("com.example.sendmessage", "SendMessage: onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("com.example.sendmessage", "SendMessage: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("com.example.sendmessage", "SendMessage: onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("com.example.sendmessage", "SendMessage: onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("com.example.sendmessage", "SendMessage: onPause");
    }

    /*public void getOnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnOk:
                //1. Recoger el mensaje

                //2. Crear un objeto Bundle y añadir el mensaje, con un conjunto de clave valor.
                Bundle bundle = new Bundle();
                bundle.putString("message",edtMessage.getText().toString());
                bundle.putString("user", edtUser.getText().toString());
                //3. Crear un objeto Intent. Tenemos que poner el contexto y la clase destinataria.
                //Por nomenclatura usamos el nombre de la clase tambien en el this. Accedemos al contexto
                //de la activity, aprobechando que las Activity's heredan de Context. Le hemos mandado
                //parte de nuestro contexto de esta Activity a la otra. Usamos la clase, porque todavía no esta en memoria
                //entonces accedemos a la clase compilada.
                Intent intent = new Intent(SendMessageActivity.this,ViewMessageActivity.class);
                //4. Añadir el Bundle al Intent
                intent.putExtras(bundle);
                //5. Iniciar la Activity ViewMessage. Sabe que activity debe iniciar porque este metodo
                //iniciará la activity a la que se mande el intent.
                startActivity(intent);
                //Break del switch
                break;
        }
    }*/
}
