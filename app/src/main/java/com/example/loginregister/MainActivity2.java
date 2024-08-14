package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginregister.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textViewSignIn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
//            startActivity(intent);
        });
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!fieldIsValid()){
                    Toast.makeText(MainActivity2.this,"Please" , Toast.LENGTH_LONG).show();
                    return;
                }
                if (!binding.txtPassword.getText().toString().equals(binding.txtCPassword.getText().toString())) {
                    Toast.makeText(MainActivity2.this,"Not Equals Password" , Toast.LENGTH_LONG).show();
                    return;
                }
                String name = binding.txtName.getText().toString();
                String email = binding.txtEmail.getText().toString();
                String password = binding.txtPassword.getText().toString();
//                String confirmPassword = binding.txtCPassword.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });

    }

    private boolean fieldIsValid() {
        return !TextUtils.isEmpty(binding.txtName.getText()) && !TextUtils.isEmpty(binding.txtEmail.getText()) &&
                !TextUtils.isEmpty(binding.txtPassword.getText()) &&  !TextUtils.isEmpty(binding.txtCPassword.getText());
    }
}



