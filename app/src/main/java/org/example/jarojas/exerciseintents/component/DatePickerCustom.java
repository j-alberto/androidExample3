package org.example.jarojas.exerciseintents.component;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.jarojas.exerciseintents.ConfirmActivity;
import com.example.jarojas.exerciseintents.MainActivity;
import com.example.jarojas.exerciseintents.R;

import java.util.Calendar;

/**
 * Created by jarojas on 15/06/16.
 */
public class DatePickerCustom extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);



        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
        MainActivity mainActivity = (MainActivity)getActivity();
        mainActivity.setDay(day);
        mainActivity.setMonth(month);
        mainActivity.setYear(year);


        TextView tvBirthDate = (TextView) getActivity().findViewById(R.id.tvBirthdate);
        tvBirthDate.setText(
                String.format("%s/%s/%s", day, month+1, year)
        );
    }
}
