package com.example.tpdm_u1_ejercicio3;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button boton1, boton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1 = findViewById(R.id.boton);
        boton2 = findViewById(R.id.boton2);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                EditText edad = new EditText(MainActivity.this);

                edad.setInputType(InputType.TYPE_CLASS_DATETIME);
                edad.setHint("Mayor a 0 menor de 100");

                alerta.setTitle("Con 1 objeto");
                alerta.setMessage("Escribe su edad: ");
                alerta.setView(edad);
                alerta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Su edad" + edad.getText());
                    }
                });
                alerta.show();
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearAlertaConVariosViews();
            }
        });
    }
private void crearAlertaConVariosViews(){
    AlertDialog.Builder muchosView = new AlertDialog.Builder(this);

  final View contenido =getLayoutInflater().inflate(R.layout.varios_objetos,null);

    muchosView.setTitle("Alerta muchos vies");
    muchosView.setMessage("Se muestra los views");
    muchosView.setView(contenido);
    muchosView.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            EditText nombre = contenido.findViewById(R.id.nombrepersona);
            RadioButton sol = contenido.findViewById(R.id.soltero);
            RadioButton cas= contenido.findViewById(R.id.casado);

            String mensaje = "Usted se llama "+ nombre.getText().toString();
            if (sol.isChecked()){
                mensaje += "\n y es SOLTERO(A)";
            }
            if (cas.isChecked()){
                mensaje += "\n y es CASADO(A)";
            }
            Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
nombre.setText("");
        }
    });
muchosView.show();
}
    }

