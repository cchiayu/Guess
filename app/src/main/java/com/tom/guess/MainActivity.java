package com.tom.guess;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
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

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getSimpleName();
    int secret;
    private ImageView result;
    int counter;
    private EditText num;
    private TextView edCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        num = findViewById(R.id.num);
        edCounter = findViewById(R.id.counter);
        edCounter.setText(String.valueOf(counter));
        edCounter.setText(counter +"");
        result = findViewById(R.id.result_image);
        reset();
        Log.d(TAG, "secret" + secret);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //counter = " ";
               // number.setText(counter);
                //計數清零
            }
        });

    }
    public void reset(){
        secret = new Random().nextInt(10)+1;
        counter = 0;
        edCounter.setText(counter+"");
    }

    public void guess(View view) {
        int n = Integer.parseInt(num.getText().toString());
        counter++;
        edCounter.setText(counter+"");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();
            }
        };
        String message = " jo li hi";
        num.setText(Integer.toString(n));
        if (n < secret) {
            message = "Bigger";
            listener = null;

           /*new AlertDialog.Builder(MainActivity.this)
                    .setTitle("HEY!")
                    .setMessage("Bigger")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            secret = new Random().nextInt(10)+1;
                            counter = 0;
                            reset();
                        }
                    })
                    .show();*/
           // result.setVisibility((View.VISIBLE));
           // result.setImageResource(R.drawable.smile);
            //Toast.makeText(MainActivity.this, "Bigger", Toast.LENGTH_SHORT).show(); 彈窗通知

        } else if (n > secret) {
            message = "smaller";
            listener = null;
          /* new AlertDialog.Builder(MainActivity.this)
                    .setTitle("HEY!")
                    .setMessage("Smaller")
                    .setPositiveButton("OK",null)
                    .show();*/
            //Toast.makeText(MainActivity.this, "Smaller", Toast.LENGTH_SHORT).show();
           // result.setVisibility((View.VISIBLE));
            //result.setImageResource(R.drawable.smile);
        }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("HEY!")
                    .setMessage(message)
                    .setPositiveButton("OK",listener)
                    .show();
           // Toast.makeText(MainActivity.this, "You got it!", Toast.LENGTH_SHORT).show();
            //result.setVisibility((View.VISIBLE));
            //result.setImageResource(R.drawable.shock);



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

}