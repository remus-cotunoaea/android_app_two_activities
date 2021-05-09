package com.remapp.remus_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private Button btn;
    private TextView nombre, fecha, telefono, correo, description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre      = (TextView) findViewById(R.id.recibir_nombre);
        fecha       = (TextView) findViewById(R.id.recibir_fecha);
        telefono    = (TextView) findViewById(R.id.recibir_telefono);
        correo      = (TextView) findViewById(R.id.recibir_email);
        description = (TextView) findViewById(R.id.recibir_description);

        String nombreKey      = getIntent().getExtras().getString("keyNombre");
        String fechaKey       = getIntent().getExtras().getString("keyFecha");
        String telefonoKey    = getIntent().getExtras().getString("keyTelefono");
        String correoKey      = getIntent().getExtras().getString("keyEmail");
        String descriptionKey = getIntent().getExtras().getString("keyDescription");

        nombre.setText(nombreKey);
        fecha.setText("Fecha Nacimiento: " + fechaKey);
        telefono.setText("Tel: " + telefonoKey);
        correo.setText("Email: " + correoKey);
        description.setText("Descripcion: " + descriptionKey);

        btn = (Button) findViewById(R.id.ID_button_return);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnData = new Intent();
                setResult(RESULT_FIRST_USER, returnData);
                finish();
            }
        });

    }
}