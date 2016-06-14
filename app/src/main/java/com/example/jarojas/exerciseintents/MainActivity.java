package com.example.jarojas.exerciseintents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import static com.example.jarojas.exerciseintents.R.id;
import static com.example.jarojas.exerciseintents.R.string;

public class MainActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvPhone;
    private TextView tvEmail;
    private TextView tvDescription;
    private DatePicker dpBirthdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (TextView) findViewById(id.tvName);
        tvPhone = (TextView) findViewById(id.tvPhone);
        tvEmail = (TextView) findViewById(id.tvEmail);
        tvDescription = (TextView) findViewById(id.tvDescription);
        dpBirthdate = (DatePicker) findViewById(id.dpBirthdate);

        String name =  getIntent().getStringExtra(getString(R.string.key_name));

        if (name != null && !name.isEmpty()){
            setTextFromIntent(tvName, string.key_name);
            setTextFromIntent(tvPhone, string.key_phone);
            setTextFromIntent(tvEmail, string.key_email);
            setTextFromIntent(tvDescription, string.key_descr);

            int day = getIntent().getIntExtra(getString(string.key_bdate_day),1);
            int month = getIntent().getIntExtra(getString(string.key_bdate_month),1);
            int year = getIntent().getIntExtra(getString(string.key_bdate_year),1900);
            dpBirthdate.updateDate(year, month, day);
        }



    }

    public void clickNext(View view){
        Intent intent = new Intent(this, ConfirmActivity.class);

        intent.putExtra(getString(string.key_name), tvName.getText().toString());
        intent.putExtra(getString(string.key_phone), tvPhone.getText().toString());
        intent.putExtra(getString(string.key_email), tvEmail.getText().toString());
        intent.putExtra(getString(string.key_descr), tvDescription.getText().toString());

        intent.putExtra(getString(string.key_bdate_day), dpBirthdate.getDayOfMonth());
        intent.putExtra(getString(string.key_bdate_month), dpBirthdate.getMonth());
        intent.putExtra(getString(string.key_bdate_year), dpBirthdate.getYear());

        startActivity(intent);
    }

    public void setTextFromIntent(TextView textView, int stringId){
        textView.setText(
                getIntent().getStringExtra(getString(stringId))
        );
    }
}
