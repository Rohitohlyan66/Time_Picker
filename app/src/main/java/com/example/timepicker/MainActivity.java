package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    TextView time;
    Button btn;

    int curr_hour, curr_minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = findViewById(R.id.time);
        btn = findViewById(R.id.btn);

        Calendar calendar = Calendar.getInstance();
        curr_hour = calendar.get(Calendar.HOUR);
        curr_minute = calendar.get(Calendar.MINUTE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        time.setText(hourOfDay + ":" + minute);


                    }
                }, curr_hour, curr_minute, false);

                dialog.show();
            }
        });

    }
}