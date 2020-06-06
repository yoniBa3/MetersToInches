package com.yoni.meterstoinches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yoni.meterstoinches.utils.Utils;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public static final int METER = 123;
    public static final int INCH = 32434;
    private TextView tvHeader;
    private Context context;
    private EditText etMeterOrInch;
    private TextView tvAnswer;
    private int model = 0;
    private double scale = 2.4;
    private String meterMessage = "Meters To Inches";
    private String inchMessage = "Inches To Meters";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setPointer();
    }

    private void setPointer() {
        model = METER;
        tvHeader = findViewById(R.id.tvHeader);
        etMeterOrInch = findViewById(R.id.etMeterOrInch);
        tvAnswer = findViewById(R.id.tvAnswer);

        findViewById(R.id.btnConvert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String measurement = etMeterOrInch.getText().toString();
                if (!Utils.checkIfNumber(measurement)){
                    Toast.makeText(context, "This is not a number you can convert", Toast.LENGTH_SHORT).show();
                    return;
                }
                double number = Double.parseDouble(measurement);
                double num = 0.0;
                String answer = "The answer is: ";

                switch (model){
                    case METER:
                        num = number / scale;
                        break;
                    case INCH:
                        num = number * scale;
                }
                answer += new DecimalFormat("##.##").format(num);
                tvAnswer.setText(answer);
            }
        });

        findViewById(R.id.btnChangeMeasurementUnit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "";
                if (model == METER){
                    model = INCH;
                    message = inchMessage;
                }else {
                    model = METER;
                    message = meterMessage;
                }
                tvHeader.setText(message);
                tvAnswer.setText("");
                etMeterOrInch.setText("");
            }
        });

    }
}