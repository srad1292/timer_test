package e.smr12.timertest;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private TextView start;
    private TextView elapsed;
    Chronometer chronometer;
    Button start_button, reset_button;
    long stopTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.timer_started);


        chronometer = (Chronometer)findViewById(R.id.chronometer);
        start_button = (Button)findViewById(R.id.start_button);
        reset_button = (Button)findViewById(R.id.reset_button);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateFormat df = new SimpleDateFormat("MM dd, yyyy: hh:mm");
                String date = df.format(Calendar.getInstance().getTime());

                start.setText(String.format("Start Time: %s", date));
                chronometer.setBase(SystemClock.elapsedRealtime() + stopTime);
                chronometer.start();
                start_button.setVisibility(View.GONE);
            }
        });


        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                stopTime = 2000;
                chronometer.stop();
                start_button.setVisibility(View.VISIBLE);
            }
        });

    }
}
