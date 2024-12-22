package com.example.customdialog;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayActivity extends AppCompatActivity {

    private TextView txtName, txtEmail, txtContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display);

        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtContact = findViewById(R.id.txtContact);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            txtName.setText(bundle.getString("name"));
            txtEmail.setText(bundle.getString("email"));
            txtContact.setText(bundle.getString("contact"));
        }

    }
}