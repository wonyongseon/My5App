package com.example.a510.my5app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btTest = (Button)findViewById(R.id.btTest);
        btTest.setOnClickListener(new View.OnClickListener() {//= 와 = new는 다름 new가 붙으면 메모리 할당당
           @Override
            public void onClick(View v) {
               StringTok sInput = new StringTok("sensor 1 10.23");
               parseCode(sInput);
            }
        });
    }

    public void parseCode(StringTok sInput) {//여기에 아두이노에서 받은값 처리
        StringTok sToken;
        //sToken = sInput.getToken();//구문분석 자세히
        sToken = sInput.getTokenWhite();//구문분석을 대충 공백으로 나눠서 분석
        if (sToken.toString().equals("sensor")){//구문에 sensor가 있으면 if문 실행
            sToken = sInput.getTokenWhite();//구문분석을 대충 공백으로 나눠서 분석
            int nId = sToken.atoi();//int로 바꿔주어야 됨
            //Toast.makeText(this, String.format("%d",nId), Toast.LENGTH_SHORT).show();//성공했는지 확인,int를 문자열로 바꿔주어야 하기 때문에 format사용
            double val = sToken.atof();
            storeData(nId,val);
            //Toast.makeText(this, String.format("%g",val), Toast.LENGTH_SHORT).show();//성공했는지 확인,int를 문자열로 바꿔주어야 하기 때문에 format사용,소수점g사용
        }
        //Toast.makeText(this, sToken.toString(), Toast.LENGTH_SHORT).show();//성공했는지 확인
    }

    public void storeData(int nId, double val){//아두이노에서 받은 값 저장

    }
}
