package com.raj.pickeatup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Otp extends AppCompatActivity {


    private Spinner spinner;
    private EditText editText;
    private Button conti;

    SharedPreferences sp;
    DatabaseReference reference1;



    String TAG = "PhoneActivityTAG";
    Activity activity = Otp.this;
    String wantPermission = Manifest.permission.READ_PHONE_STATE;
    private static final int PERMISSION_REQUEST_CODE = 1;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        spinner =findViewById(R.id.spinner);
        editText=findViewById(R.id.editText);
    //    sp=(SharedPreferences)getSharedPreferences("Student4",MODE_PRIVATE);

        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,CountryData.countryNames));

        if (!checkPermission(wantPermission)) {
            requestPermission(wantPermission);
        } else {

//
//            String phoneno= getPhone();
//
//
//                                   editText.setText(phoneno);
//


//            int i;
//
//
//            int lengthofstring=no.length();
//
//               for (i=0;i<lengthofstring;i++){
//                   if (i>=2){
//
//                   }
//
//               }






        }

        findViewById(R.id.conti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];

                String number = editText.getText().toString().trim();


                if (number.isEmpty() || number.length() < 10 || number.length()>10) {
                    editText.setError("Enter the Valid 10 digit mobile number");
                    editText.requestFocus();

    //                SharedPreferences.Editor ed = sp.edit();
    //                ed.putString("number1", editText.getText().toString());


                    return;
                }

                String phonenumber = "+" + code + number;





                Intent intent = new Intent(Otp.this, VerifyOtp.class);

                intent.putExtra("otpverifiednumber",number);
                intent.putExtra("phonenumber", phonenumber);
                startActivity(intent);


            }

        });



//
//        String name = "";
//        String lastname = "";
//        String adress1 = "";
//        String adress2 = "";
//        String adress3 = "";
//        String city = "";
//        String pincode = "";
//        String receiversnumber = "";
//        String email = "";
//        String phoneno=getPhone();
//
//        reference1= FirebaseDatabase.getInstance().getReference().child("adress").child(phoneno);
//
//
//
//        AdressVishwaHelper myhelper= new AdressVishwaHelper(name, lastname, adress1, adress2, adress3, city, pincode, receiversnumber, email);
//
//        reference1.setValue(myhelper);
















    }


    @Override
    protected void onStart() {

        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser()!= null) {

            Intent i = new Intent(Otp.this, Welcome.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(i);


        }
    }

    public String getPhone() {
        TelephonyManager phoneMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(activity, wantPermission) != PackageManager.PERMISSION_GRANTED)
        {
            return null;
        }
        return phoneMgr.getLine1Number();
    }

    private void requestPermission(String permission){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)){
            Toast.makeText(activity, "Phone state permission allows us to get phone number. Please allow it for additional functionality.", Toast.LENGTH_LONG).show();
        }
        ActivityCompat.requestPermissions(activity, new String[]{permission},PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {


                 //   Toast.makeText(this, "Login id:"+getPhone(), Toast.LENGTH_SHORT).show();

                    editText.setText(getPhone());

                } else
                    {

                    Toast.makeText(activity,"Permission Denied. We can't DETECT phone number.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private boolean checkPermission(String permission){
        if (Build.VERSION.SDK_INT >= 23) {
            int result = ContextCompat.checkSelfPermission(activity, permission);
            if (result == PackageManager.PERMISSION_GRANTED){
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    //   public static final  String userPhone="9112416062";

//       public static String getNumbers() {
//
//
//
//
//           return phonenumber;
//       }
}