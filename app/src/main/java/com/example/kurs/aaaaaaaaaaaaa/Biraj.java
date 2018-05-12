package com.example.kurs.aaaaaaaaaaaaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Biraj extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biraj);
    }

    public void igraj(View view) {
      int broj= Integer.parseInt((String)view.getTag());
        Intent intent=new Intent(this,IgraActivity.class);
        intent.putExtra("broj",broj);
        startActivity(intent);

    }
}
