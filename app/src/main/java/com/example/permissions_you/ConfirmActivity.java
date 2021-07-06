package com.example.permissions_you;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvConfirmName;
    private TextView mTvConfirmEmail;
    private TextView mTvConfirmPhone;
    private TextView mTvConfirmSeats2;
    private TextView mTvConfirmDate2;
    private Button mBtnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        initViewsAndListeners();
        String FName = PreferenceHelper.getStringFromPreference(ConfirmActivity.this, "FName");
        String LName = PreferenceHelper.getStringFromPreference(ConfirmActivity.this, "LName");
        mTvConfirmName.setText(FName + " " + LName);
        String Email = PreferenceHelper.getStringFromPreference(ConfirmActivity.this, "Email");
        mTvConfirmEmail.setText(Email);
        String Phone = PreferenceHelper.getStringFromPreference(ConfirmActivity.this,"Phone");
        mTvConfirmPhone.setText(Phone);
        String Seats = PreferenceHelper.getStringFromPreference(ConfirmActivity.this,"Seats");
        mTvConfirmSeats2.setText(Seats);
        String Date = PreferenceHelper.getStringFromPreference(ConfirmActivity.this,"Date");
        mTvConfirmDate2.setText(Date);
    }

    private void initViewsAndListeners() {
        mTvConfirmName = findViewById(R.id.tvConfirmName);
        mTvConfirmEmail = findViewById(R.id.tvConfirmEmail);
        mTvConfirmPhone = findViewById(R.id.tvConfirmPhone);
        mTvConfirmSeats2 = findViewById(R.id.tvConfirmSeats2);
        mTvConfirmDate2 = findViewById(R.id.tvConfirmDate2);
        mBtnConfirm = findViewById(R.id.btnConfirm);
        mBtnConfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        new AlertDialog.Builder(ConfirmActivity.this)
                .setTitle("Tickets Booked")
                .setMessage("Event is confirmed on this date: "+ PreferenceHelper.getStringFromPreference(ConfirmActivity.this,"Date"))
                .show();
    }
}