package com.example.healthcare_mobsys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SuccessMessageActivity extends AppCompatActivity {

    private TextView successMessage;
    private Button btnConfirm, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_message);

        successMessage = findViewById(R.id.textViewSuccessMessage);
        Intent intent = getIntent();
        String successText = intent.getStringExtra("message");
        successMessage.setText(successText);

        btnConfirm = findViewById(R.id.buttonConfirm);
        btnCancel = findViewById(R.id.buttonCancel);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessMessageActivity.this, "Booking Confirmed", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SuccessMessageActivity.this, HomeActivity.class));
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessMessageActivity.this, "Booking Canceled", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SuccessMessageActivity.this, HomeActivity.class));
            }
        });
    }
}