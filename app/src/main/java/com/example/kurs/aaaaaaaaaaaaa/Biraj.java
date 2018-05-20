package com.example.kurs.aaaaaaaaaaaaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Biraj extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biraj);
    }

    public void igraj(View view) {
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg1);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.rg2);
        final String value =
                ((RadioButton)findViewById(rg.getCheckedRadioButtonId()))
                        .getTag().toString();


        final String value2 =
                ((RadioButton)findViewById(rg2.getCheckedRadioButtonId()))
                        .getTag().toString();
        int broj2=Integer.parseInt(value);
        int broj=Integer.parseInt(value2);
        Intent intent=new Intent(this,IgraActivity.class);
        intent.putExtra("broj",broj);
        intent.putExtra("broj2",broj2);
        startActivity(intent);

    }
}
