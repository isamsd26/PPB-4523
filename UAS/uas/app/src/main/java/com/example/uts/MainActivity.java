package com.example.uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;




public class MainActivity extends AppCompatActivity {

    TextView reg;
    private Button button1;
    EditText inputEmail, inputPassword;
    String email,password;
    Button btnlogin;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        btnlogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ceklogin();
            }
        });
         reg = (TextView)findViewById(R.id.buatAkunbaru);
         reg.setOnClickListener(new OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(MainActivity.this, Register.class));
             }
         });

        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(),MainMenu.class);
            startActivity(intent1);
        });
    }

    private void ceklogin() {
        email = inputEmail.getText().toString();
        password = inputPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Login gagal, Cek User dan Password Anda!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}