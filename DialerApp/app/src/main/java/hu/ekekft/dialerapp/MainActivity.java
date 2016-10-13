package hu.ekekft.dialerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dial = (Button) findViewById(R.id.dial_button);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Teszt", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, DialerActivity.class);
                EditText editText = (EditText) findViewById(R.id.number_editText);
                String message = editText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                intent.putExtra("AUTO_CALL", true);
                startActivity(intent);
            }
        });
    }
}
