package com.example.bae;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;


public class NewActivity extends AppCompatActivity {

    private String phone1 = "112";
    private String phone2 = "01068524856";
    private String help = "도와주세요";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new); // create activity_new view


        // button that begin to MainActivity
        Button btnBegin = findViewById(R.id.beginbutton);
        btnBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                setResult(RESULT_OK, intent);
                //remove current activity and move to MainActivity
                finish();
            }
        });

        // when click call button event
        Button btnCall = findViewById(R.id.report_call);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission") // 오류나면 이거 지워보셈.
            @Override
            public void onClick(View view) {
                //parse() method of the Uri class to convert a number string into a Uri object
                try {
                    // 바로 전화걸기
                    //Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone1));
                    // 전화창 열기
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone1));
                    startActivity(intent);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // when click call button event
        Button btnText = findViewById(R.id.report_text);

        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SmsManager sms = SmsManager.getDefault();
                //sms.sendTextMessage(phone1, null, "도와주세요", null, null);
                try{
                    /*
                    // 문자창 열기
                    Intent intent = new Intent( Intent.ACTION_VIEW );
                    intent.setData( Uri.parse( "sms:"+ phone1) );
                    startActivity(intent);
                    */

                    // 문자 바로 보내기

                    //Uri smsUri = Uri.parse("sms:"+phone2); //  비상연락처
                    Uri smsUri = Uri.parse("sms:"+phone1); //112전화
                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO, smsUri);
                    sendIntent.putExtra("sms_body",help);
                    startActivity(sendIntent);
                    //Toast.makeText(getApplicationContext(), "전송 완료!", Toast.LENGTH_LONG).show();

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        // when click call button event
        Button btnPhone = findViewById(R.id.call_num);

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //parse() method of the Uri class to convert a number string into a Uri object
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + phone2));
                startActivity(intent);
            }
        });


        Button setting = findViewById(R.id.setting);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //make new intent that can display NewActivity2 on screen
                Intent intent = new Intent(getApplicationContext(), NewActivity2.class);

                //Request result using request code and move to NewActivity
                startActivityForResult(intent,1);
            }
        });
    }

    // result of the startActivityResult that response to request
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            Bundle bundle = data.getExtras();
            // get data in bundle by arraylist
            ArrayList<String> info = bundle.getStringArrayList("info");
            // update edittext to stringArray in bundle
            phone2=info.get(0);


        }
    }
}

