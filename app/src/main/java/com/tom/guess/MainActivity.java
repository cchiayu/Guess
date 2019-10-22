package com.tom.guess;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getSimpleName();
    int secret = new Random().nextInt(10) + 1;
    private ImageView result;
    private TextView number;
    private EditText num;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "secret" + secret);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        num = findViewById(R.id.num);

        result = findViewById(R.id.result_image);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setAlpha(1.0f);
                result.setVisibility((View.VISIBLE));

            }
        });
    }

    public void guess(View view) {
        int n = Integer.parseInt(num.getText().toString());
        num.setText(Integer.toString(n));
        if (n < secret) {
            Toast.makeText(MainActivity.this, "Bigger", Toast.LENGTH_SHORT).show();
            result.setVisibility((View.VISIBLE));
            result.setImageResource(R.drawable.smile);
        } else if (n > secret) {
            Toast.makeText(MainActivity.this, "Smaller", Toast.LENGTH_SHORT).show();
            result.setVisibility((View.VISIBLE));
            result.setImageResource(R.drawable.smile);
        } else {
            Toast.makeText(MainActivity.this, "You got it!", Toast.LENGTH_SHORT).show();
            result.setVisibility((View.VISIBLE));
            result.setImageResource(R.drawable.shock);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void zero(View view) {
        counter = 0;
        number.setText(String.valueOf(counter));
    }
}