package com.example.bae;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class NewActivity2 extends AppCompatActivity {
    EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2); // create activity_new2 view
        phone = findViewById(R.id.textPhone);

        // button that begin to MainActivity
        // 설정버튼
        Button btnBegin=findViewById(R.id.beginbutton);
        btnBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NewActivity.class);
                Bundle bundle= new Bundle();


                //save data in arraylist
                ArrayList<String> info = new ArrayList<>();
                info.add(phone.getText().toString());
                bundle.putStringArrayList("info",info);
                // put data in bundle
                intent.putExtras(bundle);
                // after send bundle
                setResult(RESULT_OK, intent);
                //remove current activity and move to MainActivity
                finish();
            }

        });
    }
}

