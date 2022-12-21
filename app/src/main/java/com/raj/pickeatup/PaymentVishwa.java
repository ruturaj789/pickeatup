package com.raj.pickeatup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raj.pickeatup.bakerystores.Bstore1;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class PaymentVishwa extends AppCompatActivity {

   // ImageView gpay, paytm, bhim,upi, cod;
    ImageView cod;

    final int UPI_PAYMENT = 0;

    DatabaseReference ref1;

    ArrayList<ProfileOfItemsInVishwa> list;

    RecyclerView rv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_vishwa);
    //    gpay=findViewById(R.id.gpay);
     //   upi=findViewById(R.id.upi);
        cod=findViewById(R.id.cod);
     //   paytm=findViewById(R.id.paytm);
    //    bhim=findViewById(R.id.bhim);
//        final String phoneno=getPhone();
       final String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();




      //  Glide.with(PaymentVishwa.this).load("https://firebasestorage.googleapis.com/v0/b/pickeatup-c2713.appspot.com/o/payementimages%2Fgpay.jpeg?alt=media&token=4c4e585f-c838-41a5-8291-d68f6fc51aa3").into(gpay);
      //  Glide.with(PaymentVishwa.this).load("https://firebasestorage.googleapis.com/v0/b/pickeatup-c2713.appspot.com/o/payementimages%2Fupiic.JPG?alt=media&token=1ecf7ed1-a67b-47e6-809f-c923f7067ba8").into(upi);
        Glide.with(PaymentVishwa.this).load("https://firebasestorage.googleapis.com/v0/b/pickeatup-c2713.appspot.com/o/payementimages%2Fcod.jpg?alt=media&token=b5275e04-52fc-4eea-bad4-d72426ac9de2").into(cod);
       // Glide.with(PaymentVishwa.this).load("https://firebasestorage.googleapis.com/v0/b/pickeatup-c2713.appspot.com/o/payementimages%2Fpaytm.jpeg?alt=media&token=ea3ddc0a-fe8e-481e-bfa0-2a53194ae5fe").into(paytm);
      //  Glide.with(PaymentVishwa.this).load("https://firebasestorage.googleapis.com/v0/b/pickeatup-c2713.appspot.com/o/payementimages%2Fbhimic.JPG?alt=media&token=c84e5649-344c-4f02-bf67-ab1a8bc3b651").into(bhim);


        cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                CharSequence options[] = new CharSequence[]{


                        "Cancel",               "Confirm Order"
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(PaymentVishwa.this);

                builder.setTitle("You have selected Cash On Delivery Method.");

                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (i==0){




                        }


                        if (i == 1) {


                            DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Order Confirmed");
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    if (!(snapshot.child(uidno).exists())) {

                                        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////



                                        Intent im = new Intent(PaymentVishwa.this, ThankYou.class);
                                        DatabaseReference delivaryboyref = FirebaseDatabase.getInstance().getReference().child("delivaryboy").child(uidno);


                                        String bstoreaddress_1=getIntent().getStringExtra("bstoreaddress_1");
                                        String bstorename_1=getIntent().getStringExtra("bstorename_1");
                                        String adress1=getIntent().getStringExtra("adress1");
                                        String adress2=getIntent().getStringExtra("adress2");
                                        String adress3=getIntent().getStringExtra("adress3");
                                        String city=getIntent().getStringExtra("city");
                                        String pincode=getIntent().getStringExtra("pincode");
                                        String receiversnumber=getIntent().getStringExtra("receiversnumber");
                                        String name=getIntent().getStringExtra("name");
                                        String lastname=getIntent().getStringExtra("lastname");
//                            String phno=getPhone();
                                        String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();

                                        String email=getIntent().getStringExtra("email");
                                        String storeid=getIntent().getStringExtra("storeid");
                                        String category=getIntent().getStringExtra("category");
                                        String totalp=getIntent().getStringExtra("totalprice");
                                        String otpverifiednumber= getPhone();
                                        String bstoretime=getIntent().getStringExtra("bstoretime");
                                        String latitude=getIntent().getStringExtra("latitude");
                                        String longitude=getIntent().getStringExtra("longitude");




                                        im.putExtra("totalprice",totalp);
                                        im.putExtra("category",category);
                                        im.putExtra("storeid",storeid);
                                        im.putExtra("name",name);





                                        String saveCurrentDate, saveCurrentTime;

                                        Calendar calForDate = Calendar.getInstance();

                                        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
                                        saveCurrentDate = currentDate.format(calForDate.getTime());


                                        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");


                                        saveCurrentTime = currentTime.format(calForDate.getTime());


                                        String mode="Cash On Delivery";




                                        Calendar calForDate2 = Calendar.getInstance();


                                        Calendar calForDate3 = Calendar.getInstance();


                                        SimpleDateFormat currentTime2 = new SimpleDateFormat("HH:mm a");
                                        String saveCurrentTime2 = currentTime2.format(calForDate2.getTime());




                                        SimpleDateFormat currentTime3 = new SimpleDateFormat("HH a");
                                        String   saveCurrentTime3 = currentTime3.format(calForDate3.getTime());



                                        String timeesec=saveCurrentDate+" "+saveCurrentTime2;


                                        String timeemin=saveCurrentDate+" "+saveCurrentTime3;




                                        String orderid= saveCurrentDate+" "+saveCurrentTime;

                                        //  delivaryboyref=FirebaseDatabase.getInstance().getReference().child("delivaryboy").child(phno);



                                        PayementVishwaHelper payementVishwaHelper = new PayementVishwaHelper(bstoreaddress_1,bstorename_1, adress1, adress2,adress3,city, pincode, receiversnumber,name,lastname,uidno,storeid,saveCurrentDate,saveCurrentTime,mode,totalp,email,otpverifiednumber,bstoretime,orderid,timeesec,timeemin,latitude,longitude);

                                        delivaryboyref.setValue(payementVishwaHelper);





                                        DatabaseReference adminref = FirebaseDatabase.getInstance().getReference().child("adminview");

                                        adminref.child("Confirmed Orders").child(orderid).setValue(payementVishwaHelper);

                                        DatabaseReference shopref=FirebaseDatabase.getInstance().getReference().child("shopkeeperview");

                                        shopref.child("Confirmed Orders").child(storeid).child(orderid).setValue(payementVishwaHelper);

                                        shopref.child("Confirmed Orders for ringtone").child(storeid).child(orderid).setValue(payementVishwaHelper);


                                        im.addFlags(im.FLAG_ACTIVITY_CLEAR_TASK | im.FLAG_ACTIVITY_CLEAR_TASK);

                                        notification();


                                        startActivity(im);

/////////////////////////////////////////////////////////


                                    }
                                    else{
                                        Snackbar.make(v, "Dear Customer, your order is already in progress", Snackbar.LENGTH_INDEFINITE)
                                                .setAction("View Order", new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {


                                                        Intent i = new Intent(PaymentVishwa.this, TrackOrder.class);


                                                        startActivity(i);

                                                    }
                                                }).show();
                                    }


                                    }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });


                            ////////////////////////////////

                        }
                    }


                });
                builder.show();

            }

        });

        final String totalp=getIntent().getStringExtra("totalprice");




//        gpay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                String amount = totalp;
//                String note = "PickEatUp Delivery";
//                String name = "PickEatUp";
//                String upiId ="paytmqr2810050501011vw0wu2md9kh@paytm";
//                payUsingUpi(amount, upiId, name, note);
//
//
//
//            }
//        });
//
//        paytm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //Getting the values from the EditTexts
//                String amount = totalp;
//                String note = "PickEatUp Delivery";
//                String name = "PickEatUp";
//                String upiId ="paytmqr2810050501011vw0wu2md9kh@paytm";
//                payUsingUpi(amount, upiId, name, note);
//
//
//            }
//        });
//
//        bhim.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //Getting the values from the EditTexts
//                String amount = totalp;
//                String note = "PickEatUp Delivery";
//                String name = "PickEatUp";
//                String upiId ="paytmqr2810050501011vw0wu2md9kh@paytm";
//                payUsingUpi(amount, upiId, name, note);
//
//            }
//        });
//
//        upi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                //Getting the values from the EditTexts
//                String amount = totalp;
//                String note = "PickEatUp Delivery";
//                String name = "PickEatUp";
//                String upiId ="paytmqr2810050501011vw0wu2md9kh@paytm";
//                payUsingUpi(amount, upiId, name, note);
//
//
//
//
//
//            }
//        });
//










    }
//    void paybyPaytm(String amount, String upiId, String name, String note)
//    {
//        Uri uri = Uri.parse("upi://pay").buildUpon()
//                .appendQueryParameter("pa", upiId)
//                .appendQueryParameter("pn", name)
//                .appendQueryParameter("tn", note)
//                .appendQueryParameter("am", amount)
//                .appendQueryParameter("cu", "INR")
//                .build();
//
//        JSONObject paytmParams = new JSONObject();
//
//        JSONObject body = new JSONObject();
//        body.put("requestType", "Payment");
//        body.put("mid", "ppiBbf20627615569409");
//        body.put("websiteName", "PICKEATUP");
//        body.put("orderId", "101");
//        body.put("callbackUrl", "https://<callback URL to be used by merchant>");
//
//        JSONObject txnAmount = new JSONObject();
//        txnAmount.put("value", amount);
//        txnAmount.put("currency", "INR");
//
//        JSONObject userInfo = new JSONObject();
//        userInfo.put("custId", "CUST_001");
//        body.put("txnAmount", txnAmount);
//        body.put("userInfo", userInfo);
//
//        /*
//         * Generate checksum by parameters we have in body
//         * You can get Checksum JAR from https://developer.paytm.com/docs/checksum/
//         * Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
//         */
//
//        String checksum = PaytmChecksum.generateSignature(body.toString(), "SEMTV7oyo4tyAHwc");
//
//        JSONObject head = new JSONObject();
//        head.put("signature", checksum);
//
//        paytmParams.put("body", body);
//        paytmParams.put("head", head);
//
//        String post_data = paytmParams.toString();
//
//        /* for Staging */
//        URL url = new URL("https://securegw-stage.paytm.in/theia/api/v1/initiateTransaction?mid=ppiBbf20627615569409&orderId=123");
//
//        /* for Production */
//// URL url = new URL("https://securegw.paytm.in/theia/api/v1/initiateTransaction?mid=YOUR_MID_HERE&orderId=ORDERID_98765");
//
//        try {
//    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//    connection.setRequestMethod("POST");
//    connection.setRequestProperty("Content-Type", "application/json");
//    connection.setDoOutput(true);
//
//    DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());
//    requestWriter.writeBytes(post_data);
//    requestWriter.close();
//    String responseData = "";
//    InputStream is = connection.getInputStream();
//    BufferedReader responseReader = new BufferedReader(new InputStreamReader(is));
//    if ((responseData = responseReader.readLine()) != null) {
//        System.out.append("Response: " + responseData);
//    }
//    responseReader.close();
//        } catch (Exception exception) {
//    exception.printStackTrace();
//        }
//
//
//    }


    void payUsingUpi(String amount, String upiId, String name, String note) {

        Uri uri = Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa", upiId)
                .appendQueryParameter("pn", name)
                .appendQueryParameter("tn", note)
                .appendQueryParameter("am", amount)
                .appendQueryParameter("cu", "INR")
                .build();


        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);

        // will always show a dialog to user to choose an app
        Intent chooser = Intent.createChooser(upiPayIntent, "Pay with");

        // check if intent resolves
        if(null != chooser.resolveActivity(getPackageManager())) {
            startActivityForResult(chooser, UPI_PAYMENT);
        } else {
            Toast.makeText(PaymentVishwa.this,"No UPI app found, please install one to continue",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        switch (requestCode) {
            case UPI_PAYMENT:
                if ((RESULT_OK == resultCode) || (resultCode == 11)) {

                    if (data != null) {
                        String trxt = data.getStringExtra("response");
                        Log.d("UPI", "onActivityResult: " + trxt);
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add(trxt);
                        upiPaymentDataOperation(dataList);
                    } else {
                        Log.d("UPI", "onActivityResult: " + "Return data is null");
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add("nothing");
                        upiPaymentDataOperation(dataList);
                    }
                } else {
                    Log.d("UPI", "onActivityResult: " + "Return data is null"); //when user simply back without payment
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add("nothing");
                    upiPaymentDataOperation(dataList);
                }
                break;
        }
    }

    private void upiPaymentDataOperation(ArrayList<String> data) {
        if (isConnectionAvailable(PaymentVishwa.this)) {
            String str = data.get(0);
            Log.d("UPIPAY", "upiPaymentDataOperation: "+str);
            String paymentCancel = "";
            if(str == null) str = "discard";
            String status = "";
            String approvalRefNo = "";
            String response[] = str.split("&");
            for (int i = 0; i < response.length; i++) {
                String equalStr[] = response[i].split("=");
                if(equalStr.length >= 2) {
                    if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                        status = equalStr[1].toLowerCase();
                    }
                    else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                        approvalRefNo = equalStr[1];
                    }
                }
                else {
                    paymentCancel = "Payment cancelled by user.";
                }
            }

            if (status.equals("success")) {
                //Code to handle successful transaction here.
                Toast.makeText(PaymentVishwa.this, "Transaction successful.", Toast.LENGTH_SHORT).show();
                Log.d("UPI", "responseStr: "+approvalRefNo);






                Intent i=new Intent(PaymentVishwa.this,ThankYou.class);


                String bstoreaddress_1=getIntent().getStringExtra("bstoreaddress_1");
                String bstorename_1=getIntent().getStringExtra("bstorename_1");
                String adress1=getIntent().getStringExtra("adress1");
                String adress2=getIntent().getStringExtra("adress2");
                String adress3=getIntent().getStringExtra("adress3");
                String city=getIntent().getStringExtra("city");
                String pincode=getIntent().getStringExtra("pincode");
                String receiversnumber=getIntent().getStringExtra("receiversnumber");
                String name=getIntent().getStringExtra("name");
                String lastname=getIntent().getStringExtra("lastname");
                String email=getIntent().getStringExtra("email");
                String otpverifiednumber= getPhone();
                String bstoretime=getIntent().getStringExtra("bstoretime");
                String latitude=getIntent().getStringExtra("latitude");
                String longitude=getIntent().getStringExtra("longitude");


//                String phno=getPhone();
                String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();

                String storeid=getIntent().getStringExtra("storeid");
                String category=getIntent().getStringExtra("category");
                String totalp=getIntent().getStringExtra("totalprice");
                i.putExtra("totalprice",totalp);
                i.putExtra("category",category);
                i.putExtra("storeid",storeid);
                i.putExtra("name",name);





                DatabaseReference delivaryboyref = FirebaseDatabase.getInstance().getReference().child("delivaryboy").child(uidno);



                String saveCurrentDate, saveCurrentTime;

                Calendar calForDate = Calendar.getInstance();

                SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
                saveCurrentDate = currentDate.format(calForDate.getTime());


                SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");


                saveCurrentTime = currentTime.format(calForDate.getTime());

                String orderid= saveCurrentDate+" "+saveCurrentTime;

                String mode="Online Payment";




                Calendar calForDate2 = Calendar.getInstance();


                Calendar calForDate3 = Calendar.getInstance();


                SimpleDateFormat currentTime2 = new SimpleDateFormat("HH:mm a");
               String saveCurrentTime2 = currentTime2.format(calForDate2.getTime());




                SimpleDateFormat currentTime3 = new SimpleDateFormat("HH a");
                String   saveCurrentTime3 = currentTime3.format(calForDate3.getTime());



                String timeesec=saveCurrentDate+" "+saveCurrentTime2;


                String timeemin=saveCurrentDate+" "+saveCurrentTime3;









                //delivaryboyref=FirebaseDatabase.getInstance().getReference().child("delivaryboy").child(phno);



                PayementVishwaHelper payementVishwaHelper = new PayementVishwaHelper(bstoreaddress_1,bstorename_1, adress1, adress2,adress3,city, pincode, receiversnumber,name,lastname,uidno,storeid,saveCurrentDate,saveCurrentTime,mode,totalp,email,otpverifiednumber,bstoretime,orderid,timeesec,timeemin,latitude,longitude);

                delivaryboyref.setValue(payementVishwaHelper);


                DatabaseReference adminref = FirebaseDatabase.getInstance().getReference().child("adminview");

                adminref.child("Confirmed Orders").child(orderid).setValue(payementVishwaHelper);

                DatabaseReference shopref=FirebaseDatabase.getInstance().getReference().child("shopkeeperview");

                shopref.child("Confirmed Orders").child(storeid).child(orderid).setValue(payementVishwaHelper);




                i.addFlags(i.FLAG_ACTIVITY_CLEAR_TASK | i.FLAG_ACTIVITY_CLEAR_TASK);

                notification();





                startActivity(i);



            }
            else if("Payment cancelled by user.".equals(paymentCancel)) {
                Toast.makeText(PaymentVishwa.this, "Payment cancelled by user.", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(PaymentVishwa.this, "Transaction failed.Please try again", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(PaymentVishwa.this, "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isConnectionAvailable(PaymentVishwa context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {

            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()
                    && netInfo.isConnectedOrConnecting()
                    && netInfo.isAvailable()) {

                return true;
            }
        }
        return false;
    }






    private void notification(){

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            NotificationChannel channel= new NotificationChannel("n","n", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager= getSystemService(NotificationManager.class);

            manager.createNotificationChannel(channel);

            NotificationCompat.Builder builder= new NotificationCompat.Builder(this,"n").setContentText("PickEatUp").setSmallIcon(R.drawable.pickeatupicon).setAutoCancel(false).setContentText("Your Order is sucessfully placed.");

            NotificationManagerCompat managerCompat= NotificationManagerCompat.from(this);

            managerCompat.notify(999,builder.build());
        }

    }


























    Activity activity = PaymentVishwa.this;
    String wantPermission = Manifest.permission.READ_PHONE_STATE;
    String wantPerm= Manifest.permission.CALL_PHONE;

    private static final int PERMISSION_REQUEST_CODE = 1;

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
                    Toast.makeText(activity,"ok", Toast.LENGTH_LONG).show();



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






}

