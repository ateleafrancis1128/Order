package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int amount=1;
    int basePrice=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnminus = findViewById(R.id.btn_minus);
        Button btnplus = findViewById(R.id.btn_plus);
        final TextView tv = findViewById(R.id.tv_amount);
        final CheckBox Cream = findViewById(R.id.cream);
        final CheckBox ChocolateChips = findViewById(R.id.chocolatechips);
        final CheckBox Vanilla = findViewById(R.id.vanilla);
        Button btnOrder = findViewById(R.id.order);
        final TextView tvtq = findViewById(R.id.tq);

        btnminus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Do stuff
                if (amount > 1) {
                    amount--;
                    tv.setText(Integer.toString(amount));
                }
            }
        });


        btnplus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Do stuff
                amount++;
                tv.setText(Integer.toString(amount));
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int finalPrice = basePrice;
                if (Cream.isChecked()) {
                    finalPrice += 1;
                }

                if (ChocolateChips.isChecked()) {
                    finalPrice += 2;
                }

                if (Vanilla.isChecked()) {
                    finalPrice += 3;
                }

                finalPrice *= amount;

                Log.d("Final Price", Integer.toString(finalPrice));
                tvtq.setText("Thank You for your order. \n The total price is " + Integer.toString(finalPrice));


            }
        });
    }
}
