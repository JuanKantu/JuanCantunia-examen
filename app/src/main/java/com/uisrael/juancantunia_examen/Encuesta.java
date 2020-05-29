package com.uisrael.juancantunia_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Encuesta extends AppCompatActivity {

    Bundle datoRecibir, datoNombre;
    TextView userName;

    EditText et1, usuario;
    CheckBox cb1, cb2, cb3;
    RadioButton rB1, rB2;
    Button btnSendResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        userName = findViewById(R.id.etUsuario);
        usuario = findViewById(R.id.etNombre);

        et1 = findViewById(R.id.etNombre);

        rB1 = findViewById(R.id.rd1);
        rB2 = findViewById(R.id.rd2);
        cb1 = findViewById(R.id.ch1);
        cb2 = findViewById(R.id.ch2);
        cb3 = findViewById(R.id.ch3);
        btnSendResume = findViewById(R.id.btnEnviar);

        datoRecibir = getIntent().getExtras();
        String name = datoRecibir.getString("name");
        userName.setText(name);

        datoNombre = getIntent().getExtras();
        String name2 = datoNombre.getString("name");
        usuario.setText(name2);

        btnSendResume.setOnClickListener(new View.OnClickListener() {
            // Click button
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().length() != 0) {
                    Intent intentEnvio1 = new Intent(Encuesta.this, Resumen.class);
                    String message1 = "";
                    if (rB1.isChecked()) {
                        message1 += "Selecciono SI a su interes en otra lengua ";
                    } else if (rB2.isChecked()) {
                        message1 += "Selecciono NO a su interes en otra lengua ";
                    }
                    String message2 = "";
                    if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked()) {
                        message2 += "Selecciono este deporte: ";
                    }
                    if (cb1.isChecked()) {
                        message2 += "Fútbol";
                    }
                    if (cb2.isChecked()) {
                        message2 += " Natación";
                    }
                    if (cb2.isChecked()) {
                        message2 += " Atletismo";
                    }
                    String q1 = et1.getText().toString();
                    datoRecibir = getIntent().getExtras();
                    String name2 = datoRecibir.getString("name");
                    String starting_amount = datoRecibir.getString("starting_amount");
                    Intent intentEnvio = new Intent(Encuesta.this, Resumen.class);
                    intentEnvio.putExtra("q1", q1);
                    intentEnvio.putExtra("starting_amount", starting_amount);
                    intentEnvio.putExtra("q2", message1);
                    intentEnvio.putExtra("q3", message2);
                    intentEnvio.putExtra("name", name2);
                    startActivity(intentEnvio);
                    Toast.makeText(getApplicationContext(), "Envío de datos exitoso", Toast.LENGTH_SHORT).show();
                    startActivity(intentEnvio1);
                } else {
                    Toast.makeText(getApplicationContext(), "Campos obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
