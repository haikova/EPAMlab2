package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myapp_activity);

        Button send = (Button) findViewById(R.id.buttonSend);
        final EditText email = (EditText) findViewById(R.id.editTextEmail);
        final EditText title = (EditText) findViewById(R.id.editTextTitle);
        final EditText text = (EditText) findViewById(R.id.editTextMessage);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,
                        new String[] { email.getText().toString() });
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                        title.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT,
                        text.getText().toString());
                MyMainActivity.this.startActivity(Intent.createChooser(emailIntent,
                        "Send email"));
            }
        });
    }
}
