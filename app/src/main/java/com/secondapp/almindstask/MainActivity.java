package com.secondapp.almindstask;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainLayout,minusLayout,plusLayout,countLayout,cartLayout;
    ImageView minus, delete;
    TextView countTv;
    int count =1;
    String counts="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout=findViewById(R.id.mainLayout);
        minusLayout=findViewById(R.id.minusLayout);
        plusLayout=findViewById(R.id.plusLayout);
        countLayout=findViewById(R.id.countLayout);
        cartLayout=findViewById(R.id.cartLayout);
        minus=findViewById(R.id.minusIv);
        delete=findViewById(R.id.deleteIv);
        countTv=findViewById(R.id.count);


        cartLayout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
               cartLayout.animate().translationX(1000);
               mainLayout.setVisibility(View.VISIBLE);

            }
        });
        minusLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                counts=String.valueOf(count);
                if (count<1){
                    minus.setVisibility(View.GONE);
                    delete.setVisibility(View.VISIBLE);
                    count=1;
                }
                else{

                    countTv.setText(counts);
                    minus.setVisibility(View.VISIBLE);
                    delete.setVisibility(View.GONE);

                }



            }
        });

        plusLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                counts=String.valueOf(count);

                if (count>=1){

                    countTv.setText(counts);
                    minus.setVisibility(View.VISIBLE);
                    delete.setVisibility(View.GONE);

                }




            }
        });






    }


}