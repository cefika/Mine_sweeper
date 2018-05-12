package com.example.kurs.aaaaaaaaaaaaa;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class IgraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igra);
        int nesto= getIntent().getIntExtra("broj",6);
        GridLayout glmrezapolja=(GridLayout)findViewById(R.id.glMreza);
        glmrezapolja.setColumnCount(nesto);
        for(int i=0;i<nesto*nesto;i++)
        {
            Button dugme=new Button(this);
            dugme.setText(i+"");
            GridLayout.LayoutParams gllp= new GridLayout.LayoutParams();
//            GridLayout.LayoutParams gllp=new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f),GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f));
            gllp.width= ViewGroup.LayoutParams.WRAP_CONTENT;
            gllp.height= ViewGroup.LayoutParams.WRAP_CONTENT;
            gllp.setGravity(Gravity.FILL_HORIZONTAL);
    //        gllp.columnSpec( GridLayout.spec(1));
            glmrezapolja.addView(dugme);
            dugme.setLayoutParams(gllp);
        }

        RelativeLayout.LayoutParams llp=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llp.addRule(RelativeLayout.CENTER_IN_PARENT);
        glmrezapolja.setLayoutParams(llp);
    }
}
