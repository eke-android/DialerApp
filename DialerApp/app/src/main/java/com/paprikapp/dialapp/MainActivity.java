package com.paprikapp.dialapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "NUMBER";
    public final static int REQ_DIAL = 1;
    public final static int REQ_DIAL_IMPLICIT = 2;

    private Button implicitDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dial = (Button) findViewById(R.id.dial_button);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.number_editText);
                String message = editText.getText().toString();

                Intent intent = new Intent(MainActivity.this, DialerActivity.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivityForResult(intent, REQ_DIAL);
            }
        });

        implicitDial = (Button) findViewById(R.id.implicit_button);
        implicitDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.number_editText);
                String message = editText.getText().toString();
                Uri number = Uri.parse("tel:" + message);

                String title = "Choose app";
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                Intent chooser = Intent.createChooser(callIntent, title);

                // Verify the intent will resolve to at least one activity
                if (callIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(chooser, REQ_DIAL_IMPLICIT);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_DIAL) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Result Ok", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Result Cancel", Toast.LENGTH_LONG).show();
            }
        }

        if (requestCode == REQ_DIAL_IMPLICIT) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Implicit Result Ok", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Implicit Result Cancel", Toast.LENGTH_LONG).show();
            }
        }
    }
}
