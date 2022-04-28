package com.example.exam2partialdam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class finaliza extends AppCompatActivity {
    TextView textView_name2;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String key_name = "name";
    private static final String Key_password = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finaliza);

        textView_name2 = findViewById(R.id.messagefinal);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(key_name,null);
        String password = sharedPreferences.getString(Key_password,null);

        if(name!=null || password !=null){
            if(!name.equals("")&&!password.equals("")){
                textView_name2.setText(name+" tu pago fue exitoso estamos, llevando tu pedido a tu diireccion \n GRACIAS POR TU PREFERENCIA");
            }
            else
                textView_name2.setText("Los datos que enviaste son incorrectos");
        }
    }
}