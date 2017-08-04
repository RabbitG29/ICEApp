package kr.inha.inti.iceapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import static kr.inha.inti.iceapp.R.layout.activity_verify;
import static kr.inha.inti.iceapp.R.layout.password_dialog;

/**
 * Created by KDH on 2017-07-24.
 */

public class VerifyActivity extends AppCompatActivity {
    final Context context = this;
    EditText inputId;
    EditText inputPassword;
    CheckBox autoLogin;
    CheckBox saveId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_verify);
        autoLogin = (CheckBox) findViewById(R.id.auto_login);
        saveId = (CheckBox) findViewById(R.id.save_id);
        inputId = (EditText) findViewById(R.id.input_idnumber);
        inputPassword = (EditText) findViewById(R.id.input_password);

        SharedPreferences sf = getSharedPreferences("PrefName", MODE_PRIVATE);
        String preId = sf.getString("id","");
        String prePassword = sf.getString("password","");
        inputId.setText(preId);
        inputPassword.setText(prePassword);

        Button login = (Button)findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //인증이 성공할 경우 메인 화면으로
                //인증이 실패할 경우 재로그인하게 해야함
                finish();
            }
        });

      Button question = (Button)findViewById(R.id.button_question);
        question.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("알림");
                alertDialogBuilder.setMessage("초기 비밀번호 : p학번\n로그인 후 변경 요망");
                alertDialogBuilder.create();
                alertDialogBuilder.show();
            }
        });

        Button forgetPassword = (Button)findViewById(R.id.button_password);
        forgetPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder adb = new AlertDialog.Builder(context);
                adb.setTitle("비밀번호 초기화");
                adb.setView(password_dialog);
                adb.create();
                adb.show();
            }
        });
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        if(autoLogin.isChecked() == true || saveId.isChecked() == true) {
            SharedPreferences prefs = getSharedPreferences("PrefName", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            String id = inputId.getText().toString();
            String password = inputPassword.getText().toString();
            editor.putString("id", id);
            editor.putString("password", password);
            editor.commit();
        }
    }
}
