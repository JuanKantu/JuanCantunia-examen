package com.uisrael.juancantunia_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    Bundle userReceptado;
    EditText etNom, etMon, etCuo, datoUsuario;
    Button  btnCalcular, btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etNom = findViewById(R.id.etNombre);
        etMon = findViewById(R.id.etMontoInicial);
        etCuo = findViewById(R.id.etValorCuota);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnGuardar = findViewById(R.id.btnGuardar);

        datoUsuario = findViewById(R.id.etUsuario);
        userReceptado = getIntent().getExtras();
        String recibir = userReceptado.getString("datoEnviado");
        datoUsuario.setText(recibir);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            // Click button
            @Override
            public void onClick(View v) {
                if (etNom.getText().toString().length() != 0 && etMon.getText().toString().length() != 0) {

                    String q2 = etMon.getText().toString();
                    double value = Integer.parseInt(q2);
                    double res = ((1800 - value) / 3) + ((1800 - value) * 0.05);
                    String requestData = Double.toString(res);
                    etCuo.setText(requestData);
                    Toast.makeText(getApplicationContext(), "Su monto a pagar por tres meses es: " + requestData, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Campos obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNom.getText().toString().length() != 0 && etMon.getText().toString().length() != 0 && etCuo.getText().toString().length() != 0) {
                    String val1 = etNom.getText().toString();
                    String val3 = etCuo.getText().toString();
                    Intent intentEnvio = new Intent(Registro.this, Encuesta.class);
                    intentEnvio.putExtra("name", val1);
                    intentEnvio.putExtra("starting_amount", val3);
                    Toast.makeText(getApplicationContext(), "Informacion guardada con éxito", Toast.LENGTH_SHORT).show();
                    startActivity(intentEnvio);
                } else {
                    Toast.makeText(getApplicationContext(), "Campos obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
