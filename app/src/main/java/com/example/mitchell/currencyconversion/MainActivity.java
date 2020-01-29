package com.example.mitchell.currencyconversion;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double euro = 0.871792;
    double can = 1.30807;
    double mex = 19.3011;
    double dol;
    String sym;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //coding for buttons
        final EditText dollars = findViewById(R.id.txtNumber);
        final RadioButton radioButton =  findViewById(R.id.radioButton);
        final RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dol = Double.parseDouble(dollars.getText().toString()); // converting number to string
                DecimalFormat tenth = new DecimalFormat("####.##"); // applying number format


                if (radioButton.isChecked()) {
                    if (dol < 100000) {
                        sym = "CAN$";
                        result.setText(sym + tenth.format(dol = dol * can));//tenth.format(dol = dol * can);
                    }else {
                        Toast.makeText(MainActivity.this, "Amount must be less then $100,000",
                                Toast.LENGTH_LONG).show();
                    }
                }if (radioButton2.isChecked()) {
                    if (dol < 100000) {
                        sym = "€";
                        result.setText(sym + tenth.format(dol = dol * euro));
                    }else {
                        Toast.makeText(MainActivity.this, "Amount must be less then $100,000",
                                Toast.LENGTH_LONG).show();
                    }
                }if(radioButton3.isChecked()) {
                    if (dol < 100000) {
                        sym = "MEX$";
                        result.setText(sym + tenth.format(dol = dol * mex));
                    }else  {
                        Toast.makeText(MainActivity.this, "Amount must be less then $100,000",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
