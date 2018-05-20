package com.example.kurs.aaaaaaaaaaaaa;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class IgraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igra);
        final  ArrayList<Boolean> niz =new ArrayList<>();
        final int nesto= getIntent().getIntExtra("broj",6);
        int nesto2=getIntent().getIntExtra("broj2",5);

        GridLayout glmrezapolja=(GridLayout)findViewById(R.id.glMreza);
        glmrezapolja.setColumnCount(nesto);
        Display display = getWindowManager().getDefaultDisplay();
        //int height= display.getHeight()/nesto-2;
        int width=display.getWidth()/nesto-2;
        Log.d("ss",width+" "+display.getWidth());

        for(int i=0;i<nesto*nesto;i++)
        {
            niz.add(false);

            final ImageButton dugme=new ImageButton(this);
            dugme.setBackgroundColor(Color.GRAY);
            //dugme.setImageDrawable(getResources().getDrawable(R.drawable.smajli));
            GridLayout.LayoutParams gllp= new GridLayout.LayoutParams();
            gllp.setMargins(1,1,1,1);
            gllp.height=width;
            gllp.width=width;
            dugme.setLayoutParams(gllp);
            glmrezapolja.addView(dugme);
            dugme.setTag(i);
            dugme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int trenutnapoz=(int)v.getTag();
                    int br=0;
                    if(niz.get(trenutnapoz))
                    {
                        v.setBackground(getResources().getDrawable(R.drawable.mina));
                    }
                    else
                    {
                        for(int i = trenutnapoz-nesto; i<=trenutnapoz+nesto;i+=nesto){
                            for(int j = -1; j <= 1; j++) {
                                if((trenutnapoz+j)/(trenutnapoz/nesto+1)<nesto
                                        && (trenutnapoz+j)/(trenutnapoz/nesto+1)>=0
                                        && niz.get(i+j)) {
                                    br++;
                                }
                                }
                            }
                        }
                        int resID=getResources().getIdentifier("d"+br,"drawable",getPackageName());
                        if(br!=0) {
                            v.setBackground(getResources().getDrawable(resID));
                        }
                    }
            });
        }
        for(int i=0;i<nesto2;i++)
        {
            niz.set(i,true);
        }
        Collections.shuffle(niz);
        RelativeLayout.LayoutParams llp=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        llp.addRule(RelativeLayout.CENTER_IN_PARENT);
        glmrezapolja.setLayoutParams(llp);
        Log.d("sssss",glmrezapolja.getWidth()+"");
    }

    public DisplayMetrics getDisplay(){
        return new DisplayMetrics();
    }
}
