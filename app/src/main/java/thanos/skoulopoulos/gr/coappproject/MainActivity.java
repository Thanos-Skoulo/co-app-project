package thanos.skoulopoulos.gr.coappproject;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    public TextView departureDate;
    public TextView arrivalDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar =getSupportActionBar();
        actionBar.hide();

        departureDate = findViewById(R.id.tv_departure_date);

        departureDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CalendarPicker calendarPicker = new CalendarPicker(((MainActivity)view.getContext()));
                calendarPicker.setDate(view.getContext());
            }
        });

        Spinner spinner = findViewById(R.id.spinner_travel_as);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.travel_as, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

    @Override
    public void onDateSet(DatePicker datePicker, int day, int month, int year) {
        String date = day + "/" + month +"/" + year;
        departureDate.setText("Departure Date: " + date);
    }




}
