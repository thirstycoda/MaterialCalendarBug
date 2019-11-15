package com.sample;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.sample.trips.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextInputEditText fromDate = findViewById(R.id.date);

        setDateDialogControl(fromDate);
    }

    private void setDateDialogControl(TextInputEditText view) {
        view.setKeyListener(null);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(view);
            }
        });

        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showDatePicker(view);
                }
            }
        });
    }

    private void showDatePicker(TextInputEditText editText) {
        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Date");
        MaterialDatePicker<Long> picker = builder.build();

        picker.show(this.getSupportFragmentManager(), picker.toString());
    }
}