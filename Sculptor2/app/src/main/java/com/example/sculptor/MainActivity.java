package com.example.sculptor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView sculpture;
public int count = 999999;
int score_gold = 0 ;
private SharedPreferences count_pref;

private SharedPreferences gold_pref;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count_pref = getSharedPreferences("Count_pref", MODE_PRIVATE);
        count = count_pref.getInt("save_key_count", count);
        TextView textinput_counter = findViewById(R.id.textinput_counter);
        textinput_counter.setText(count+"");


        gold_pref = getSharedPreferences("Gold_pref", MODE_PRIVATE);
        score_gold = gold_pref.getInt("save_key_gold", score_gold);


        TextView gold_text = findViewById(R.id.gold);
        gold_text.setText(getString(R.string.txt_gold)+" "+score_gold);
        progressBar = findViewById(R.id.progress);
        progressBar.setProgress(count);
        sculpture = findViewById(R.id.sculpture);
        imegSet();
        sculpture.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    count = count-1 ;
                    textinput_counter.setText(count+"");
                    score_gold = score_gold + 1;
                    gold_text.setText(getString(R.string.txt_gold)+" "+score_gold);
                    progressBar.setProgress(count);
                    v.animate().scaleX(0.99f).scaleY(0.99f).setDuration(0);
                    imegSet();

                } else if (event.getAction()==MotionEvent.ACTION_UP) {
                    v.animate().scaleX(1f).scaleY(1f).setDuration(0);

                }
                return true;
            }
        });
        CardView tools = findViewById(R.id.tools);
        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = count_pref.edit();
                editor.putInt("save_key_count",count);
                editor.commit();

                SharedPreferences.Editor editor2 = gold_pref.edit();
                editor.putInt("save_key_gold",count);
                editor.commit();
            }
        } );
    }
    public void imegSet() {
        if(count > 999499){sculpture.setImageResource(R.drawable.img_20);}
        if(count <=  999499 & count > 998099 ){sculpture.setImageResource(R.drawable.img_19);}
        if(count <=  998099 & count > 995499 ){sculpture.setImageResource(R.drawable.img_18);}
        if(count <=  995499 & count > 990899 ){sculpture.setImageResource(R.drawable.img_17);}
        if(count <=  990899 & count > 983499 ){sculpture.setImageResource(R.drawable.img_16);}
        if(count <=  983499 & count > 972499 ){sculpture.setImageResource(R.drawable.img_15);}
        if(count <=  972499 & count > 957099 ){sculpture.setImageResource(R.drawable.img_14);}
        if(count <=  957099 & count > 936499 ){sculpture.setImageResource(R.drawable.img_13);}
        if(count <=  936499 & count > 909899 ){sculpture.setImageResource(R.drawable.img_12);}
        if(count <=  909899 & count > 876499 ){sculpture.setImageResource(R.drawable.img_11);}
        if(count <=  876499 & count > 835499 ){sculpture.setImageResource(R.drawable.img_10);}
        if(count <=  835499 & count > 786099 ){sculpture.setImageResource(R.drawable.img_9);}
        if(count <=  786099 & count > 727499 ){sculpture.setImageResource(R.drawable.img_8);}
        if(count <=  727499 & count > 658899 ){sculpture.setImageResource(R.drawable.img_7);}
        if(count <=  658899 & count > 579499 ){sculpture.setImageResource(R.drawable.img_6);}
        if(count <=  579499 & count > 488499 ){sculpture.setImageResource(R.drawable.img_5);}
        if(count <=  488499 & count > 385099 ){sculpture.setImageResource(R.drawable.img_4);}
        if(count <=  385099 & count > 268499 ){sculpture.setImageResource(R.drawable.img_3);}
        if(count <=  268499 & count > 137899 ){sculpture.setImageResource(R.drawable.img_2);}
        if(count <=  137899 & count > 0 ){sculpture.setImageResource(R.drawable.img_1);}
        if(count <= 0){sculpture.setImageResource(R.drawable.img_0);}




    }



}