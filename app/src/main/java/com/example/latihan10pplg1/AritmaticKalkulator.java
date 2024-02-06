package com.example.latihan10pplg1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AritmaticKalkulator extends AppCompatActivity {

    EditText txtangka1;
    EditText txtangka2;
    Spinner spoperator;
    TextView hasil;
    Button btncalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmatic_kalkulator);

        txtangka1 = findViewById(R.id.txtAngka1);
        txtangka2 = findViewById(R.id.txtAngka2);
        spoperator = findViewById(R.id.spOperator);
        hasil = findViewById(R.id.tvHasil);
        btncalculate = findViewById(R.id.btnCalculate);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtangka1.getText().toString().isEmpty() || txtangka2.getText().toString().isEmpty()){
                    Toast.makeText(AritmaticKalkulator.this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else{
                double number1 = Double.parseDouble(txtangka1.getText().toString());
                double number2 = Double.parseDouble(txtangka2.getText().toString());
                double result = 0;

                String text = spoperator.getSelectedItem().toString();
                switch (text) {
                    case "Tambah":
                        result = number1 + number2;
                        int resultint = (int)result;
                        hasil.setText(resultint+"");
                        break;
                    case "Kurang":
                        result = number1 - number2;
                        hasil.setText(Double.toString(result));
                        resultint = (int)result;
                        hasil.setText(resultint+"");
                        break;

                    case "Kali":
                        result = number1 * number2;
                        resultint = (int)result;
                        hasil.setText(resultint+"");
                        break;

                    case "Bagi":
                        if (number2 == 0) {
                            Toast.makeText(AritmaticKalkulator.this, "Pembagi tidak bolel 0", Toast.LENGTH_SHORT).show();
                        } else {
                            result = number1 / number2;
                            hasil.setText(Double.toString(result));
                        }
                        break;
                    default:
                        Toast.makeText(AritmaticKalkulator.this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();


                }}

            }
        });
    }

}