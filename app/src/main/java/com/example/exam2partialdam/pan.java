package com.example.exam2partialdam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class pan extends AppCompatActivity {
    EditText editText_producto;
    EditText editText_precio;
    EditText editText_cantidad;
    TextView textView_name;
    ImageButton next;
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
        setContentView(R.layout.activity_pan);

        editText_producto = findViewById(R.id.editnamepizza);
        editText_precio= findViewById(R.id.editpreciopizza);
        editText_cantidad = findViewById(R.id.editcantidadpizza);
        next = findViewById(R.id.imageButton3);
        textView_name = findViewById(R.id.message);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String namep= sharedPreferences.getString(key_nameproducto,null);
        String name = sharedPreferences.getString(key_name,null);
        String password = sharedPreferences.getString(Key_password,null);

        if(name!=null || password !=null){
            if(!name.equals("")&&!password.equals("")){
                textView_name.setText("Bienvenido "+name+" estas en la pantalla de pan");
            }
            else
                textView_name.setText("Los datos que enviaste son incorrectos");
        }
        if (namep !=null){
            Intent intent= new Intent (pan.this, pedido.class );
            startActivity(intent);
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString(key_nameproducto,editText_producto.getText().toString());
                editor.putString(Key_precio,editText_precio.getText().toString());
                editor.putString(Key_cantidad,editText_cantidad.getText().toString());
                editor.apply();

                Intent intent = new Intent( pan.this,pedido.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);

                Toast.makeText(pan.this, "complemento selecionado", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void backon (View view){
        Intent t = new Intent(this,MainActivity2.class);
        startActivity(t);
        overridePendingTransition(R.anim.left_in,R.anim.left_out);
    }
}