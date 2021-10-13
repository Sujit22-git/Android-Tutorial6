package com.example.tutorial6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView wuname;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        wuname = findViewById(R.id.txtwuanem);

        preferences = getSharedPreferences("MyShPre",MODE_PRIVATE);
        editor = preferences.edit();

        Intent i= getIntent();
        String s = i.getStringExtra("uname");
        wuname.setText("Welcome : " + s);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.logout:
                userLogout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void userLogout() {
        editor.remove("Login");
        editor.commit();
        Intent i = new Intent(getApplicationContext(),MainActivity2.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(),"User Not Login",Toast.LENGTH_SHORT).show();
    }
}