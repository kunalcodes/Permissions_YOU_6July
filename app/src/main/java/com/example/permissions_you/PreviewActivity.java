package com.example.permissions_you;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvPreviewName;
    private TextView mTvPreviewEmail;
    private TextView mTvPreviewPhone;
    private EditText mEtPreviewSeats;
    private EditText mEtPreviewDate;
    private Button mBtnPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViewsAndListeners();
        String FName = PreferenceHelper.getStringFromPreference(PreviewActivity.this, "FName");
        String LName = PreferenceHelper.getStringFromPreference(PreviewActivity.this, "LName");
        mTvPreviewName.setText(FName + " " + LName);
        String Email = PreferenceHelper.getStringFromPreference(PreviewActivity.this, "Email");
        mTvPreviewEmail.setText(Email);
        String Phone = PreferenceHelper.getStringFromPreference(PreviewActivity.this,"Phone");
        mTvPreviewPhone.setText(Phone);
    }

    private void initViewsAndListeners() {
        mBtnPreview = findViewById(R.id.btnPreview);
        mTvPreviewName = findViewById(R.id.tvPreviewName);
        mTvPreviewEmail = findViewById(R.id.tvPreviewEmail);
        mTvPreviewPhone = findViewById(R.id.tvPreviewPhone);
        mEtPreviewSeats = findViewById(R.id.etPreviewSeats);
        mEtPreviewDate = findViewById(R.id.etPreviewDate);
        mBtnPreview.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        PreferenceHelper.writeStringToPreference(PreviewActivity.this, "Seats", mEtPreviewSeats.getText().toString());
        PreferenceHelper.writeStringToPreference(PreviewActivity.this, "Date", mEtPreviewDate.getText().toString());
        Intent preview = new Intent(PreviewActivity.this, ConfirmActivity.class);
        startActivity(preview);
    }
}