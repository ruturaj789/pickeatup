package com.raj.pickeatup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class VerifyOtp extends AppCompatActivity {


    private  String verificationid;
    private FirebaseAuth mauth;
    private ProgressBar progressBar;
    private EditText editText;
    SharedPreferences sp;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
    //    sp=(SharedPreferences)getSharedPreferences("Students",MODE_PRIVATE);

        mauth = FirebaseAuth.getInstance();

        progressBar=findViewById(R.id.progressbar);
        editText=findViewById(R.id.editTextCode);




        String phonenumber= getIntent().getStringExtra("phonenumber");





        sendVerificationcode(phonenumber);

        findViewById(R.id.buttonSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code= editText.getText().toString().trim();
                if((code.isEmpty() || code.length() < 6))
                {

                    editText.setError("Enter code......");
                    editText.requestFocus();
                    return;


                }
                verifycode(code);
            }

        });



    }


    private void verifycode(String code)
    {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationid,code);

        signInwithCredential(credential);


    }

    private void signInwithCredential(PhoneAuthCredential credential)
    {
        mauth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    String number= getIntent().getStringExtra("number");


              //    SharedPreferences.Editor ed = sp.edit();
              //    ed.putString("number", number);






                    Intent i= new Intent(VerifyOtp.this,Welcome.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    String otpverifiednumber= getIntent().getStringExtra("otpverifiednumber");
                    i.putExtra("otpverifiednumber",otpverifiednumber);


                    i.putExtra("number",number);

                    startActivity(i);



                }

                else {

                    Toast.makeText(VerifyOtp.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void sendVerificationcode(String number)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(number,60, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD,mcallback);



    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mcallback= new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verificationid = s;
        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null){
                progressBar.setVisibility(View.VISIBLE);
                verifycode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {

            Toast.makeText(VerifyOtp.this, e.getMessage(),Toast.LENGTH_SHORT).show();


        }
    };








}