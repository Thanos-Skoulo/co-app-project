package thanos.skoulopoulos.gr.coappproject;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.security.PublicKey;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,AdapterView.OnItemSelectedListener {

    public TextView departureDate;
    public TextView arrivalDate;
    public TextView tvChildren;
    public TextView tvAdults;
    public TextView tvElders;
    public EditText numberOfChildren;
    public EditText numberOfAdults;
    public EditText numberOfElders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        departureDate = findViewById(R.id.tv_departure_date);
        final Switch layoutSwitch = (Switch) findViewById(R.id.switch1);
        final TextView tvTypeOfFlight = findViewById(R.id.tv_type_of_flight);
        Spinner spinnerTravelAs = findViewById(R.id.spinner_travel_as);
        Spinner spinnerMembershipType = findViewById(R.id.spinner_membership);
        tvChildren = findViewById(R.id.tv_children);
        tvAdults = findViewById(R.id.tv_adults);
        tvElders = findViewById(R.id.tv_elders);
        numberOfChildren = findViewById(R.id.et_number_of_children);
        numberOfAdults = findViewById(R.id.et_number_of_adults);
        numberOfElders = findViewById(R.id.et_number_of_elders);

        departureDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CalendarPicker calendarPicker = new CalendarPicker(((MainActivity) view.getContext()));
                calendarPicker.setDate(view.getContext());
            }
        });



        ArrayAdapter<CharSequence> adapterTravelAs = ArrayAdapter.createFromResource(this, R.array.travel_as, android.R.layout.simple_spinner_item);
        adapterTravelAs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTravelAs.setAdapter(adapterTravelAs);

        spinnerTravelAs.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapterMembershipType = ArrayAdapter.createFromResource(this, R.array.membership_type, android.R.layout.simple_spinner_item);
        spinnerMembershipType.setAdapter(adapterMembershipType);


        layoutSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    layoutSwitch.setTextOn("Πτηση Εξωτερικού");
                    String switchOn = layoutSwitch.getTextOn().toString();
                    tvTypeOfFlight.setText(switchOn);

                } else {
                    layoutSwitch.setTextOff("Πτήση Εσωτερικού");
                    String switchOff = layoutSwitch.getTextOff().toString();
                    tvTypeOfFlight.setText(switchOff);
                }
            }
        });


    }

    @Override
    public void onDateSet(DatePicker datePicker, int day, int month, int year) {
        String date = day + "/" + month + "/" + year;

        departureDate.setText(date);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



        adapterView.getItemAtPosition(i);
        if(i==0){
            tvChildren.setVisibility(view.GONE);
            numberOfChildren.setVisibility(view.GONE);
            tvAdults.setVisibility(view.VISIBLE);
            numberOfAdults.setVisibility(view.VISIBLE);
            tvElders.setVisibility(view.VISIBLE);
            numberOfElders.setVisibility(view.VISIBLE);
        }else if(i==1){
            tvChildren.setVisibility(view.VISIBLE);
            numberOfChildren.setVisibility(view.VISIBLE);
            tvAdults.setVisibility(view.VISIBLE);
            numberOfAdults.setVisibility(view.VISIBLE);
            tvElders.setVisibility(view.VISIBLE);
            numberOfElders.setVisibility(view.VISIBLE);
        }else{


        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}





