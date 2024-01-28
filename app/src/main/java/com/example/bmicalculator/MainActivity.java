package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edweight,edFeet,edInch;
    Button buttonCal;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edweight=findViewById(R.id.edWeight);
        edFeet=findViewById(R.id.edFeet);
        edInch=findViewById(R.id.edInch);
        buttonCal=findViewById(R.id.buttonCal);
        tvResult=findViewById(R.id.tvResult);

        buttonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sweight=edweight.getText().toString();
                String sFeet=edFeet.getText().toString();
                String sInch=edInch.getText().toString();
                if(sweight.length()>0 && sFeet.length()>0 && sInch.length()>0){
                    //---------------------------------------------------------------
                    float weight=Float.parseFloat(sweight);
                    float Feet=Float.parseFloat(sFeet);
                    float inch=Float.parseFloat(sInch);

                    float height=(float) (Feet*0.3048+inch*0.0254);
                    float bmiIndex=weight/(height*height);
                    if(bmiIndex>24){
                        tvResult.setText("Your BMI Index is:"+bmiIndex+"\n Bhai tumi mota");
                    }else if(bmiIndex>18){
                        tvResult.setText("Your BMI Index is:"+bmiIndex+"\n Bhai tumi perfect");

                    }else{
                        tvResult.setText("Your BMI Index is:"+bmiIndex+"\n Bhai tumi under weight beshi beshi khou");

                    }
                    //----------------------------------------------------------------------

                }else {
                    tvResult.setText("please enter all filed");
                }




            }
        });


    }
}