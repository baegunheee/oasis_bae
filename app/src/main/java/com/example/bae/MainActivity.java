package com.example.bae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReport = (Button) findViewById(R.id.report);
        //when click 신고 button event
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make new intent that can display NewActivity on screen
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);

                //Request result using request code and move to NewActivity
                startActivityForResult(intent,1);

            }
        });

    }
}
