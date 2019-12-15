package com.example.barcprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    public EditText emailId, pwdId, ageId;
    public Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.emailTextId);
        ageId = findViewById(R.id.ageTextId);
        signupBtn = findViewById(R.id.button);
        pwdId = findViewById(R.id.pwdTextId);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = pwdId.getText().toString();
                String age = ageId.getText().toString();

                if (email.isEmpty() || age.isEmpty() || pwd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(MainActivity.this, " failed", Toast.LENGTH_SHORT).show();
                            }
                            else {
//                                selectShows mFragment = new selectShows();
//                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                                transaction.replace(R.id.frame_layout, mFragment);
//                                transaction.commit();
                                startActivity(new Intent(MainActivity.this, SelectShows.class));

                            }
                        }

                    });


                }
            }
        });
    }

}
