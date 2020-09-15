package com.pyropy.gadstracker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SubmissionActivity extends AppCompatActivity {

    private Button submitBtn;
    private EditText firstName, lastName, email, link;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        submitBtn = (Button) findViewById(R.id.submit_btn);
        firstName = (EditText) findViewById(R.id.firstname);
        lastName = (EditText) findViewById(R.id.lastname);
        email = (EditText) findViewById(R.id.email);
        link = (EditText) findViewById(R.id.github);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        ActionBar uActionBar = getSupportActionBar();
        uActionBar.setHomeAsUpIndicator(R.drawable.back_btn);
        try {
            uActionBar.setDisplayHomeAsUpEnabled(true);
        }catch (NullPointerException npe){
            Log.d("AppBar", "No AppBar has been set");
        }

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitApp();
            }
        });
    }

    public void submitApp(){
        new SweetAlertDialog(SubmissionActivity.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Submission can only be done once!")
                .setConfirmText("Submit!")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        send(sDialog);
                    }
                })
                .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                    }
                })
                .show();
    }

    public void send(final SweetAlertDialog sDialog){
        String fname = firstName.getText().toString();
        String lname = lastName.getText().toString();
        String mail = email.getText().toString();
        String github = link.getText().toString();
        if (fname != null && lname !=null && mail != null && github != null){
            Call<Void> appSubmitCall = ApiClient.getUserService().submitApp(mail,fname,lname,github);
            appSubmitCall.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()){
                        sDialog
                                .setTitleText("Submited!")
                                .setContentText("Your Project has been Submitted!")
                                .setConfirmText("OK")
                                .setConfirmClickListener(null)
                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                    }else{
                        sDialog
                                .setTitleText("Oops...")
                                .setContentText("Something went wrong!")
                                .changeAlertType(SweetAlertDialog.ERROR_TYPE);
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    sDialog
                            .setTitleText("Oops...")
                            .setContentText("Something went wrong!")
                            .changeAlertType(SweetAlertDialog.ERROR_TYPE);

                }
            });
        }else{
            sDialog
                    .setTitleText("Oops...")
                    .setContentText("Something went wrong!")
                    .changeAlertType(SweetAlertDialog.ERROR_TYPE);
        }
    }
}