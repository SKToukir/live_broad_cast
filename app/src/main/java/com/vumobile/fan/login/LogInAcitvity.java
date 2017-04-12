package com.vumobile.fan.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vumobile.ParentActivity;
import com.vumobile.celeb.R;

public class LogInAcitvity extends AppCompatActivity {

    private EditText etUserName, etUserPhone, etVerificationCode;
    private TextView txtBecomeCeleb, txtCopyright;
    private String uName, uPhone, verificationCode;
    private Button btnSubmitCode, btnLogInCont;
    TextInputLayout userphoneWrapper, usernameWrapper, userCodeWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_acitvity);

        initUI();

        isLogin();

    }

    private void isLogin() {

        if (Session.isLogin(LogInAcitvity.this,Session.CHECK_LOGIN)){
            Intent intent = new Intent (LogInAcitvity.this, ParentActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }

    private void initUI() {

        etVerificationCode = (EditText) findViewById(R.id.etVerificationCode);
        userCodeWrapper = (TextInputLayout) findViewById(R.id.userCodeWrapper);
        usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        userphoneWrapper = (TextInputLayout) findViewById(R.id.userphoneWrapper);
        btnSubmitCode = (Button) findViewById(R.id.btnSubmitCode);
        btnLogInCont = (Button) findViewById(R.id.btnLoginCont);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etUserPhone = (EditText) findViewById(R.id.etUserPhone);
        txtBecomeCeleb = (TextView) findViewById(R.id.txt_become_celeb);
        txtCopyright = (TextView) findViewById(R.id.txtCopyright);

    }

    public void btnLoginCont(View view) {

        uName = etUserName.getText().toString();
        uPhone = etUserPhone.getText().toString();

        if (uName.isEmpty()) {
            usernameWrapper.setError("Required");
        }else {
            usernameWrapper.setError(null);
        }

        if (uPhone.isEmpty()) {
            userphoneWrapper.setError("Required");
        }else {
            userphoneWrapper.setError(null);
        }

        if (usernameWrapper.getError()==null && userphoneWrapper.getError()==null){

            userphoneWrapper.setVisibility(View.GONE);
            txtBecomeCeleb.setVisibility(View.GONE);
            usernameWrapper.setVisibility(View.GONE);
            btnLogInCont.setVisibility(View.GONE);
            btnSubmitCode.setVisibility(View.VISIBLE);
            userCodeWrapper.setVisibility(View.VISIBLE);
        }

    }

    public void btnSubmitCode(View view) {

        verificationCode = etVerificationCode.getText().toString();

        if (verificationCode.isEmpty()){
            userCodeWrapper.setError("Required");
        }else {
            userCodeWrapper.setError(null);
        }

        if (userCodeWrapper.getError()==null){

            // TODO
            /*Hit server to check verification code.
            If verification code check success then go to home page*/

            new Session().saveData(uName,uPhone,true,LogInAcitvity.this);
            Intent intent = new Intent (LogInAcitvity.this, ParentActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
