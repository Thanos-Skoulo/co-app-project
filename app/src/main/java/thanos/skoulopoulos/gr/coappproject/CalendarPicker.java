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

    public CalendarPicker(DatePickerDialog.OnDateSetListener dateSetListener) {
        this.dateSetListener = dateSetListener;
    }

    public void setDate(Context context) {
        Calendar calendarDeparture = Calendar.getInstance();
        int year = calendarDeparture.get(Calendar.YEAR);
        int month = calendarDeparture.get(Calendar.MONTH);
        int day = calendarDeparture.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, R.style.Theme_AppCompat_Light_Dialog, dateSetListener, year, month, day);
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        datePickerDialog.show();


    }
}
