package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText edtweight,edtHeightft,edtheightIn;
        Button btnCalculate;
        LinearLayout llMain;
        edtweight = findViewById(R.id.edtWeight);
        edtHeightft = findViewById(R.id.editHeightft);
        edtheightIn = findViewById(R.id.editHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int wt = Integer.parseInt(edtweight.getText().toString());
              int ft = Integer.parseInt(edtHeightft.getText().toString());
              int in = Integer.parseInt(edtheightIn.getText().toString());
              int totalIn = ft*12 + in;
              double totalCm =  (totalIn*2.53);
              double totalM = totalCm/100;
              double bmi = wt/(totalM*totalM);
              if(bmi>25){
                  txtResult.setText("you're overWeight");
                  llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
              }
              else if(bmi<18){
                  txtResult.setText("you're underWeight");
                  llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
              }
              else{
                  txtResult.setText("you're healthy");
                  llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
              }
            }
        });
    }
}