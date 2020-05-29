package com.uisrael.juancantunia_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText Usuario, Contraseña;
    Button Validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Usuario=(EditText)findViewById(R.id.etUsuario);
        Contraseña=(EditText)findViewById(R.id.etContraesña);
        Validar= (Button) findViewById(R.id.btnValidar);
    }

    public void login(View view){
        String user="estudiante2020", password="uisrael2020";
        String logger=Usuario.getText().toString();
        String logger1=Contraseña.getText().toString();
        if(logger.equals(user)&&logger1.equals(password)){
            Toast.makeText(getApplicationContext(),"Inicio de Sesión datos correctos",Toast.LENGTH_SHORT).show();
            Intent intentEnvio = new Intent(Login.this, Registro.class);
            intentEnvio.putExtra("datoEnviado", Usuario.getText().toString());
            startActivity(intentEnvio);
        }
        else
            Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrectos",Toast.LENGTH_SHORT).show();
    }
}
