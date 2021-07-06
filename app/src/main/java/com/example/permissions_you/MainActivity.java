package com.example.permissions_you;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtMainFname;
    private EditText mEtMainLname;
    private EditText mEtMainEmail;
    private EditText mEtMainPhone;
    private Button mBtnMainNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewsAndListeners();
    }

    private void initViewsAndListeners() {
        mBtnMainNext = findViewById(R.id.btnMainNext);
        mEtMainFname = findViewById(R.id.etMainFname);
        mEtMainLname = findViewById(R.id.etMainLname);
        mEtMainEmail = findViewById(R.id.etMainEmail);
        mEtMainPhone = findViewById(R.id.etMainPhone);
        mBtnMainNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        PreferenceHelper.writeStringToPreference(MainActivity.this,"FName", mEtMainFname.getText().toString());
        PreferenceHelper.writeStringToPreference(MainActivity.this,"LName", mEtMainLname.getText().toString());
        PreferenceHelper.writeStringToPreference(MainActivity.this,"Email", mEtMainEmail.getText().toString());
        PreferenceHelper.writeStringToPreference(MainActivity.this,"Phone", mEtMainPhone.getText().toString());
        Intent bookTickets = new Intent(MainActivity.this, PreviewActivity.class);
        startActivity(bookTickets);
    }
}