package com.paprikapp.dialapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DialerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);

        TextView numberText = (TextView) findViewById(R.id.number_textView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String number = extras.getString(MainActivity.EXTRA_MESSAGE);
            numberText.setText(number);
        } else {
            numberText.setText(R.string.no_number);
        }

        Uri tel = getIntent().getData();
        if (tel != null) {
            numberText.setText(tel.getSchemeSpecificPart());
        }

        Button dialButton = (Button) findViewById(R.id.dial_button);
        dialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
