package com.example.trannguyenthanhduong_2110_contentprovider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Telephony;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button buttonReadMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewMessages);
        buttonReadMessages = findViewById(R.id.buttonReadMessages);

        buttonReadMessages.setOnClickListener(view -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED) {
                readSMS();
            } else {
                requestPermissionLauncher.launch(Manifest.permission.READ_SMS);
            }
        });
    }

    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    readSMS();
                } else {
                    textView.setText("Quyền đọc SMS bị từ chối!");
                }
            });

    private void readSMS() {
        List<String> smsList = new ArrayList<>();
        Cursor cursor = getContentResolver().query(Telephony.Sms.Inbox.CONTENT_URI, null, null, null, null);

        if (cursor != null) {
            int indexBody = cursor.getColumnIndex(Telephony.Sms.BODY);
            int indexAddress = cursor.getColumnIndex(Telephony.Sms.ADDRESS);

            while (cursor.moveToNext()) {
                String address = cursor.getString(indexAddress);
                String body = cursor.getString(indexBody);
                smsList.add("From: " + address + "\nMessage: " + body + "\n");
            }
            cursor.close();
        }

        textView.setText(String.join("\n\n", smsList));
    }
}
