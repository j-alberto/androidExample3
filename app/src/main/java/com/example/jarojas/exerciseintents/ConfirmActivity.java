package com.example.jarojas.exerciseintents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

import static com.example.jarojas.exerciseintents.R.id;
import static com.example.jarojas.exerciseintents.R.string;

public class ConfirmActivity extends AppCompatActivity {

    private String name;
    private int day, month, year;
    private String phone;
    private String email;
    private String description;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        name =  getIntent().getStringExtra(getString(R.string.key_name));
        year =  getIntent().getIntExtra(getString(R.string.key_bdate_year),1900);
        month =  getIntent().getIntExtra(getString(R.string.key_bdate_month),1);
        day =  getIntent().getIntExtra(getString(R.string.key_bdate_day),1);
        date = getIntent().getStringExtra(getString(string.key_bdate));
        phone =  getIntent().getStringExtra(getString(R.string.key_phone));
        email =  getIntent().getStringExtra(getString(R.string.key_email));
        description =  getIntent().getStringExtra(getString(R.string.key_descr));

        setTextForTextView(id.detail_tvName, name);
        setTextForTextView(id.detail_tvBirthdate, date);
        setTextForTextView(id.detail_tvPhone, phone);
        setTextForTextView(id.detail_tvEmail, email);
        setTextForTextView(id.detail_tvDescription, description);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void clickEdit(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(getString(string.key_name), name);
        intent.putExtra(getString(string.key_phone), phone);
        intent.putExtra(getString(string.key_email), email);
        intent.putExtra(getString(string.key_descr), description);
        intent.putExtra(getString(string.key_bdate), date);
        intent.putExtra(getString(string.key_bdate_day), day);
        intent.putExtra(getString(string.key_bdate_month), month);
        intent.putExtra(getString(string.key_bdate_year), year);
        startActivity(intent);
    }

    public void setTextForTextView(int id, String text){
        ((TextView)findViewById(id)).setText(text);
    }
}
