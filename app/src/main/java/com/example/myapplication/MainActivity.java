package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView doubleTextValue = findViewById(R.id.text_double_value);
                String string_double_Value = doubleTextValue.getText().toString();

                TextView tripleTextValue = findViewById(R.id.text_tripple_value);
                String string_triple_value = tripleTextValue.getText().toString();

                TextView quadripleTextValue = findViewById(R.id.text_quadripple_value);
                String string_quadriple_value = quadripleTextValue.getText().toString();


                int originalDoubleValue = Integer.parseInt(string_double_Value);
                int originalTripleValue = Integer.parseInt(string_triple_value);
                int originalQuadripleValue = Integer.parseInt(string_quadriple_value);


                int doubleValue = MyWorker.doubleTheValue(originalDoubleValue);
                int tripleValue = MyWorker.tripleTheValue(originalDoubleValue);
                int quadripleValue = MyWorker.quadripleTheValue(originalDoubleValue);

                doubleTextValue.setText(Integer.toString(doubleValue));
                tripleTextValue.setText(Integer.toString(tripleValue));
                quadripleTextValue.setText(Integer.toString(quadripleValue));

                Snackbar.make(view, "Changed from ***** " + originalDoubleValue + " ****to****** " + doubleValue, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}