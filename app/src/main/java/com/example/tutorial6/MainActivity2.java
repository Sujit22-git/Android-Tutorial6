package com.example.tutorial6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText uname,pass;
    Button login;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        uname = findViewById(R.id.txtuname);
        pass = findViewById(R.id.txtpass);
        login = findViewById(R.id.btnlogin);

        preferences = getSharedPreferences("MyShPre",MODE_PRIVATE);
        editor = preferences.edit();
        String s = preferences.getString("Login",null);

        if(s != null){
            Intent i = new Intent(MainActivity2.this, MainActivity3.class);
            i.putExtra("uname",s);
            startActivity(i);
            finish();
            Toast.makeText(getApplicationContext(),"Username : "+String.valueOf(s) ,Toast.LENGTH_SHORT).show();
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s2 = uname.getText().toString();
                editor.putString("Login",s2);
                editor.commit();
                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                i.putExtra("uname",s2);
                startActivity(i);
                finish();
                Toast.makeText(getApplicationContext(),"Username : "+String.valueOf(s2) ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}