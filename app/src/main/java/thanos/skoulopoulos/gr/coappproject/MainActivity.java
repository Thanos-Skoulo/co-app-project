package thanos.skoulopoulos.gr.coappproject;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView departureDate;
    private DatePickerDialog.OnDateSetListener dateSetListener;

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
                Calendar calendarDeparture = Calendar.getInstance();
                int year =calendarDeparture.get(Calendar.YEAR);
                int mounth = calendarDeparture.get(Calendar.MONTH);
                int day = calendarDeparture.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog =new DatePickerDialog(MainActivity.this, R.style.Theme_AppCompat_Light_Dialog,dateSetListener,year,mounth,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
    }
}
