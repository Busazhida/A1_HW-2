package com.example.hw_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected EditText editText1;
    protected EditText editText2;
    protected Button button;
    protected TextView resultView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);
        resultView = (TextView) findViewById(R.id.result_view);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double A, B, C;

                String value1 = editText1.getText().toString();
                String value2 = editText2.getText().toString();

                A = Double.parseDouble(value1);
                B = Double.parseDouble(value2);
                C = A + B;
                String result = Double.toString(C);
                resultView.setText(result);
            }
        });
    }


    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String stateSaved = savedInstanceState.getString("saved_state");
        if (stateSaved == null) {
            Toast.makeText(MainActivity.this,
                    "onRestoreInstanceState:\n" +
                            "There is no saved state",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this,
                    "onRestoreInstanceState:\n" +
                            "You have saved state " + stateSaved,
                    Toast.LENGTH_LONG).show();
            resultView.setText(stateSaved);

        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String stateToSave = resultView.getText().toString();
        outState.putString("saved_state", stateToSave);
        Toast.makeText(MainActivity.this,
                "onSaveInstanceState:\n" +
                        "saved_state is " + stateToSave,
                Toast.LENGTH_LONG).show();
    }

}