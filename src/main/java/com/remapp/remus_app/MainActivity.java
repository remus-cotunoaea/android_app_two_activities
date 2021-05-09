package com.remapp.remus_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn;
    private TextInputEditText editNombre, editCalendar, editTelefono, editEmail, editDescription;
    private int dia, mes, ano;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNombre      = (TextInputEditText) findViewById(R.id.ID_edit);
        editCalendar    = (TextInputEditText) findViewById(R.id.ID_calendar);
        editTelefono    = (TextInputEditText) findViewById(R.id.ID_telefono);
        editEmail       = (TextInputEditText) findViewById(R.id.ID_email);
        editDescription = (TextInputEditText) findViewById(R.id.ID_description);

        btn = (Button) findViewById(R.id.ID_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
            public void openActivity(){
                String nombreCompleto  = editNombre.getText().toString();
                String fechaNacimiento = editCalendar.getText().toString();
                String telefono        = editTelefono.getText().toString();
                String email           = editEmail.getText().toString();
                String description     = editDescription.getText().toString();

                Intent intento = new Intent(MainActivity.this, MainActivity2.class);
                intento.putExtra("keyNombre", nombreCompleto);
                intento.putExtra("keyFecha", fechaNacimiento);
                intento.putExtra("keyTelefono", telefono);
                intento.putExtra("keyEmail", email);
                intento.putExtra("keyDescription", description);
                startActivity(intento);
            }
        });

        editCalendar.setOnClickListener(this);
    }

    @Override
    public void onClick(View vvv) {
        if(vvv==editCalendar){
            final Calendar cal= Calendar.getInstance();
            dia = cal.get(Calendar.DAY_OF_MONTH);
            mes = cal.get(Calendar.MONTH);
            ano = cal.get(Calendar.YEAR);

            DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    editCalendar.setText(dayOfMonth+"/"+month+"/"+year);
                }
            }, dia,mes,ano);
            dpd.show();
        }
    }
}