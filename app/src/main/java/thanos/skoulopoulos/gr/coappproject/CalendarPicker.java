package thanos.skoulopoulos.gr.coappproject;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class CalendarPicker {
    DatePickerDialog.OnDateSetListener dateSetListener;
    private static final String TAG = "CalendarPicker";
    public TextView departureDate;



    public void setDate(Context context) {


        Calendar calendarDeparture = Calendar.getInstance();
        int year = calendarDeparture.get(Calendar.YEAR);
        int month = calendarDeparture.get(Calendar.MONTH);
        int day = calendarDeparture.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(context, R.style.Theme_AppCompat_Light_Dialog, dateSetListener, year, month, day);
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        datePickerDialog.show();
    }

    public void dateSet() {
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int day, int month, int year) {
                month++;
//                Log.d(TAG, getString(R.string.ondatesetdate) + day + "/" + month + "/" + year);
                String departureDateSet = day + "/" + month + "/" + year;
                departureDate.setText("Departure Date: " + departureDateSet);

            }
        };
    }
}