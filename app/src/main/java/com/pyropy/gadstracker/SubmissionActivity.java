package com.pyropy.gadstracker;

import androidx.appcompat.app.AppCompatActivity;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

public class SubmissionActivity extends AppCompatActivity {

    private Button submitBtn;
    private EditText firstName, lastName, email, link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        submitBtn = (Button) findViewById(R.id.submit_btn);
        firstName = (EditText) findViewById(R.id.firstname);
        lastName = (EditText) findViewById(R.id.lastname);
        email = (EditText) findViewById(R.id.email);
        link = (EditText) findViewById(R.id.github);

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