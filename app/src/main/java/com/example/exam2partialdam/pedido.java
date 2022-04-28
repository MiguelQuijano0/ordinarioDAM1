package com.example.exam2partialdam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class pedido extends AppCompatActivity {
    TextView textView_name2;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String key_name = "name";
    private static final String Key_password = "password";
    private static final String key_nameproducto = "pizza";
    private static final String Key_precio = "precio";
    private static final String Key_cantidad = "cantidad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        textView_name2 = findViewById(R.id.messagefinal);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(key_name,null);
        String password = sharedPreferences.getString(Key_password,null);
        String nameproducto = sharedPreferences.getString(key_nameproducto, null);
        String precio = sharedPreferences.getString(Key_precio, null);
        String cantidad = sharedPreferences.getString(Key_cantidad, null);


        int enterocantidad = Integer.parseInt(cantidad);
        int valor1 = Integer.parseInt(precio);
        int total =enterocantidad * valor1;

        if(name!=null || password !=null || nameproducto != null|| precio != null || cantidad != null){
            if(!name.equals("")&&!password.equals("")&&!nameproducto.equals("")&&!precio.equals("")&&!cantidad.equals("")) {
                textView_name2.setText( name +" ordeno "+cantidad+" " +nameproducto+" con precio de $" +precio +",\n su total a pagar es $"+total +" pesos \n se enviara a la direccion "+password+ "\n" );
            }
            else
                textView_name2.setText("Los datos que enviaste son incorrectos");
        }
    }
    public void backon (View view){
        Intent t = new Intent(this,MainActivity2.class);
        startActivity(t);
        overridePendingTransition(R.anim.left_out,R.anim.left_in);
    }
    public void finish (View view){
        Intent t = new Intent(this,finaliza.class);
        startActivity(t);
        overridePendingTransition(R.anim.left_in,R.anim.left_out);
    }
}