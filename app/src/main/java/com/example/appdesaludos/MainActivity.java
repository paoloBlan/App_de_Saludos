package com.example.appdesaludos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtEdad,txtCelular,txtCorreo;
    Button btnSaludo;
    String nombre;
    int edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre=findViewById(R.id.txtNombre);
        txtEdad=findViewById(R.id.txtEdad);
        txtCelular=findViewById(R.id.txtCelular);
        txtCorreo=findViewById(R.id.txtCorreo);
        btnSaludo=findViewById(R.id.btnSaludo);
        nombre="";
         edad=0;

        txtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence c, int i, int i1, int i2) {


                    if(c.length()>50){
                       txtNombre.setError("50 careacteres");
                       btnSaludo.setEnabled(false);
                    }

                    if(c.length()<=50){
                        btnSaludo.setEnabled(true);
                    }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtEdad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence c, int i, int i1, int i2) {


                    if (c.length() > 2) {
                        txtEdad.setError("edad incorrecta");

                        btnSaludo.setEnabled(false);

                    }
                    if(c.length()<=2){
                        btnSaludo.setEnabled(true);
                    }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txtCelular.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence c, int i, int i1, int i2) {
                    if(c.length()>0 && c.length()<9){
                        txtCelular.setError("9 digitos");
                        btnSaludo.setEnabled(false);
                    }
                    if(c.length()==9){
                        btnSaludo.setEnabled(true);
                    }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txtCorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence c, int i, int i1, int i2) {
                if(validarEmail(c.toString())){
                    btnSaludo.setEnabled(true);
                }else{
                    txtCorreo.setError("email no valido");
                    btnSaludo.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnSaludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(validarTexto(txtNombre)){
                        if(validarTexto(txtEdad)){
                            if(validarTexto(txtCelular)){
                                if(validarTexto(txtCorreo)){
                                    nombre=txtNombre.getText().toString();
                                    edad=Integer.parseInt(txtEdad.getText().toString());

                                    if(edad>=0 && edad<=2){
                                        Toast.makeText(MainActivity.this,"Hola "+nombre+" eres un bebe",Toast.LENGTH_LONG).show();
                                    }
                                    if(edad>=3 && edad<=12){
                                        Toast.makeText(MainActivity.this,"Hola "+nombre+" eres un niño",Toast.LENGTH_LONG).show();
                                    }
                                    if(edad>=13 && edad<=18){
                                        Toast.makeText(MainActivity.this,"Hola "+nombre+" eres un adolecente",Toast.LENGTH_LONG).show();
                                    }
                                    if(edad>=19 && edad<=50){
                                        Toast.makeText(MainActivity.this,"Hola "+nombre+" eres un adulto",Toast.LENGTH_LONG).show();
                                    }
                                    if(edad>=50){
                                        Toast.makeText(MainActivity.this,"Hola "+nombre+" eres un anciano",Toast.LENGTH_LONG).show();
                                    }

                                }
                            }
                        }
                    }


            }
        });


    }

    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public boolean validarTexto(EditText tex){
        if(tex.getText().toString().equals("")){
            tex.setError("campo vacio");
            return false;
        }else{
            return true;
        }
    }
}