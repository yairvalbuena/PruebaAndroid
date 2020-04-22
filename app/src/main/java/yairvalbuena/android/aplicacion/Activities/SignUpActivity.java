package yairvalbuena.android.aplicacion.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import yairvalbuena.android.aplicacion.R;

public class SignUpActivity extends AppCompatActivity {

    private Button btnRegistro;
    private EditText email;
    private EditText password;
    private EditText passwordConfirm;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        btnRegistro = findViewById(R.id.resgistrar);
        email = findViewById(R.id.emailNew);
        password = findViewById(R.id.passwordNew);
        passwordConfirm = findViewById(R.id.passwordNewConfirm);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String Confirm = passwordConfirm.getText().toString();

                if(Password.equals(Confirm)){
                    SignUP(Email,Password);
                }
                else {
                    Toast.makeText(SignUpActivity.this, "Las constrasenas no coinciden", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void SignUP(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(SignUpActivity.this, "Registro Existoso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUpActivity.this, "Fallo el Registro", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
