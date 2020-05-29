package com.uisrael.juancantunia_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {

    Bundle datoRecibir;
    TextView ttxtv1, ttxtv2, ttxtv3, ttxtv4, ttxtv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        ttxtv1 = findViewById(R.id.etres1);
        ttxtv2 = findViewById(R.id.etres2);
        ttxtv3 = findViewById(R.id.etres3);
        ttxtv4 = findViewById(R.id.etres4);
        ttxtv5 = findViewById(R.id.etres5);


        datoRecibir = getIntent().getExtras();
        String rp1 = datoRecibir.getString("name");
        String rp2 = datoRecibir.getString("starting_amount");
        String rp3 = datoRecibir.getString("name");
        String rp5 = datoRecibir.getString("q3");
        String rp6 = datoRecibir.getString("q2");


        ttxtv1.setText(rp1);
        ttxtv2.setText(rp2);
        ttxtv3.setText(rp3);
        ttxtv4.setText(rp5);
        ttxtv5.setText(rp6);

    }
}
