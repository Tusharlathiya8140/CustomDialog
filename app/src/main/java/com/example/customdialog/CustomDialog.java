package com.example.customdialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomDialog extends Dialog {

    private EditText editName, editEmail, editContact;
    private Button btnSubmit;
    private Context context;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public CustomDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editContact = findViewById(R.id.editContact);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String email = editEmail.getText().toString();
                String contact = editContact.getText().toString();

                if (name.isEmpty() || email.isEmpty() || contact.isEmpty()) {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else if (!email.trim().matches(emailPattern)) {
                    editEmail.setError("valid Email ID Required");
                }
                else if (contact.trim().length()<10) {
                    editContact.setError("Invalid Contact");
                }
                else {
                    Intent intent = new Intent(context, DisplayActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", name);
                    bundle.putString("email", email);
                    bundle.putString("contact", contact);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                    dismiss();
                }
            }
        });
    }
}

