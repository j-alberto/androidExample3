package com.example.jarojas.exerciseintents;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import org.example.jarojas.exerciseintents.component.DatePickerCustom;

import static com.example.jarojas.exerciseintents.R.id;
import static com.example.jarojas.exerciseintents.R.string;

public class MainActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvPhone;
    private TextView tvEmail;
    private TextView tvDescription;
    private TextView tvBirthdate;
    private int day;
    private int month;
    private int year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (TextView) findViewById(id.tvName);
        tvPhone = (TextView) findViewById(id.tvPhone);
        tvEmail = (TextView) findViewById(id.tvEmail);
        tvDescription = (TextView) findViewById(id.tvDescription);
        tvBirthdate = (TextView) findViewById(id.tvBirthdate);

            setTextFromIntent(tvName, string.key_name);
            setTextFromIntent(tvPhone, string.key_phone);
            setTextFromIntent(tvEmail, string.key_email);
            setTextFromIntent(tvDescription, string.key_descr);
            setTextFromIntent(tvBirthdate, string.key_bdate);

            day = getIntent().getIntExtra(getString(string.key_bdate_day),0);
            month = getIntent().getIntExtra(getString(string.key_bdate_month),0);
            year = getIntent().getIntExtra(getString(string.key_bdate_year),0);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void clickNext(View view){
        Intent intent = new Intent(this, ConfirmActivity.class);

        intent.putExtra(getString(string.key_name), tvName.getText().toString());
        intent.putExtra(getString(string.key_phone), tvPhone.getText().toString());
        intent.putExtra(getString(string.key_email), tvEmail.getText().toString());
        intent.putExtra(getString(string.key_descr), tvDescription.getText().toString());
        intent.putExtra(getString(string.key_bdate), tvBirthdate.getText().toString());

        intent.putExtra(getString(string.key_bdate_day), day);
        intent.putExtra(getString(string.key_bdate_month), month);
        intent.putExtra(getString(string.key_bdate_year), year);

        startActivity(intent);
    }

    public void setTextFromIntent(TextView textView, int stringId){
        textView.setText(
                getIntent().getStringExtra(getString(stringId))
        );
    }

    public void showDatePickerDialog(View v) {
        DialogFragment dateDialog = new DatePickerCustom();
        dateDialog.show(getFragmentManager(), "datePicker");
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
