package kr.inha.inti.iceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by KDH on 2017-07-24.
 */

public class VerifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        Button b = (Button)findViewById(R.id.button_login);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
               finish();
            }
        });
    }
}
