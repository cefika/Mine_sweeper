package com.example.kurs.aaaaaaaaaaaaa;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
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
        Display display = getWindowManager().getDefaultDisplay();
        int height= display.getHeight()/nesto-2;
        int width=display.getWidth()/nesto-2;
        for(int i=0;i<nesto*nesto;i++)
        {
            ImageButton dugme=new ImageButton(this);
            dugme.setBackgroundColor(Color.GRAY);
            //dugme.setImageDrawable(getResources().getDrawable(R.drawable.smajli));
            GridLayout.LayoutParams gllp= new GridLayout.LayoutParams();
            gllp.setMargins(2,2,2,2);
            gllp.height=height;
            gllp.width=width;
            dugme.setLayoutParams(gllp);
            glmrezapolja.addView(dugme);
        }
        RelativeLayout.LayoutParams llp=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llp.addRule(RelativeLayout.CENTER_IN_PARENT);
        glmrezapolja.setLayoutParams(llp);
    }

    public DisplayMetrics getDisplay(){
        return new DisplayMetrics();

    }
}
