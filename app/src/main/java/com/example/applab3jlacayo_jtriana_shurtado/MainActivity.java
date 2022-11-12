package com.example.applab3jlacayo_jtriana_shurtado;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //declaramos las variables de los controles que vamos a utilizar
    EditText txtNum1;
    EditText txtNum2;
    Spinner opciones;
    TextView lblResultado;
    CheckBox chb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InicializarControles();
        this.IniciarSpinner();

    }

    private void InicializarControles() {
        txtNum1 = (EditText)findViewById(R.id.txtNum1);
        txtNum2 = (EditText)findViewById(R.id.txtNum2);
        lblResultado = (TextView)findViewById(R.id.lblRes);
        chb = findViewById(R.id.chbDialog);
    }
    private void IniciarSpinner(){

        opciones = findViewById(R.id.spnopciones);

        String [] Seleccion = {"Sumar", "Restar", "Multiplicar", "Dividir"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Seleccion);
        opciones.setAdapter(adapter);
    }

    public void Calcular(View view)
    {
        float n1 = Integer.parseInt(txtNum1.getText().toString());
        float n2 = Integer.parseInt(txtNum2.getText().toString());
        float resultado=0;

        try{
            switch (opciones.getSelectedItemPosition())
            {
                case 0:
                    resultado = n1 + n2 ;
                    break;

                case 1:
                    resultado = n1 - n2 ;
                    break;

                case 2:
                    resultado = n1 * n2 ;
                    break;

                case 3:
                    if (n2 !=0){
                    resultado = n1 / n2 ;
                    break;
                    }
                    else {
                        Toast.makeText(this,"No se puede introducir un 0", Toast.LENGTH_SHORT).show();
                    }
            }

            if(chb.isChecked()){
                AlertDialog.Builder di = new AlertDialog.Builder(MainActivity.this);
                di.setMessage("El resultado es: " + Float.toString(resultado))
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"Accion completada", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
            else {
                Float.toString(resultado);
                lblResultado.setText("El resultado es: " + resultado);
            }
        }

        catch (Exception e)
        {
            Toast.makeText(this,"Error en la suma de los datos" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        //bebe no prechioscho
        //No me quiere
        //Besitos 
    }
}