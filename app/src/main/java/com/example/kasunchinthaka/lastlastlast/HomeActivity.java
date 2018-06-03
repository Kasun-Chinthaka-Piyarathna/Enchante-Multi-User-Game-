package com.example.kasunchinthaka.lastlastlast;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kasunchinthaka.lastlastlast.db.LastLastDataSource;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSignIn, btnSignUp;
    private LastLastDataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDataSource = new LastLastDataSource(this);
        mDataSource.open();
        btnSignIn = (Button) findViewById(R.id.buttonSignIN);
        btnSignUp = (Button) findViewById(R.id.buttonSignUP);
        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    public void signIn(View V) {
        final Dialog dialog = new Dialog(HomeActivity.this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("WECOME TO ENCHANTE");
        final EditText editTextUserName = (EditText) dialog
                .findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword = (EditText) dialog
                .findViewById(R.id.editTextPasswordToLogin);
        Button btnSignIn = (Button) dialog.findViewById(R.id.buttonSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                USER.username = editTextUserName.getText().toString(); // String userName
                String password = editTextPassword.getText().toString();
                String storedPassword = mDataSource.getSingleEntry(USER.username);

                if (password.equals(storedPassword)) {
                    Toast.makeText(HomeActivity.this,
                            "Congrats: Login Successfull", Toast.LENGTH_LONG)
                            .show();
                    dialog.dismiss();
                    finish();
                    Intent main = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(main);
                } else {
                    Toast.makeText(HomeActivity.this,
                            "User Name or Password does not match",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        dialog.show();
    }

    @Override
    protected void onPause() {
        mDataSource.close();
        super.onPause();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonSignUP:
                finish(); // finish the current activity
                Intent intentSignUP = new Intent(getApplicationContext(),
                        SignUPActivity.class);
                startActivity(intentSignUP);
                break;
            case R.id.buttonSignIN:
                signIn(v);
                break;
        }
    }
}
