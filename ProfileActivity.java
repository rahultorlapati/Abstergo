package com.capstone.rahul.exity10;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ProfileActivity extends AppCompatActivity {

    EditText edittext;
    Calendar myCalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        myCalender = Calendar.getInstance();

        edittext = findViewById(R.id.editBirthday);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalender.set(Calendar.YEAR, year);
                myCalender.set(Calendar.MONTH, month);
                myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();


            }
        };

        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ProfileActivity.this, date, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        Spinner spinner = findViewById(R.id.spinner_height);

        String[] heights = new String[30];
        Integer i = 90;
        for (int j = 0; j < 30; i += 5, j++) {
            heights[j] = i.toString() + " cms";
        }

        final List<String> heightList = new ArrayList<>(Arrays.asList(heights));

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this, R.layout.spinner_item, heightList
        );

        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerAdapter);

        Spinner spinner2 = findViewById(R.id.spinner_current);

        String[] weights = new String[610];
        Integer k = 40;
        for (int l = 0;  l <650; k += 1, l++) {
            weights[l] = k.toString() + " lbs";
        }

        final List<String> weightlist = new ArrayList<>(Arrays.asList(weights));

        spinnerAdapter = new ArrayAdapter<>(
                this, R.layout.spinner_item, weightlist
        );

        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner2.setAdapter(spinnerAdapter);

    }

    private void updateLabel() {
        String myFormat = "MMMM dd, yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalender.getTime()));
    }
}
