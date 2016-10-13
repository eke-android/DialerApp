package hu.ekekft.dialerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DialerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);

        TextView numberText = (TextView) findViewById(R.id.number_textView);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String number = extras.getString(MainActivity.EXTRA_MESSAGE);
            numberText.setText(number);
        }else{
            numberText.setText(R.string.no_number);
        }
    }
}
