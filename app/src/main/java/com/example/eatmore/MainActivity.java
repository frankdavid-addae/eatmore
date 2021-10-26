package com.example.eatmore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout clWelcome;
    private TextView tvSignIn, tvSignUp, tvForgotPassword;
    private TextInputLayout tilConfirmPassword, tilPassword;
    private TextInputEditText etConfirmPassword;
    private Button btnSubmit;
    private boolean isSignUpSelected = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Eatmore);
        setContentView(R.layout.activity_main);

        clWelcome = findViewById(R.id.clWelcome);
        tvSignIn = findViewById(R.id.tvSignIn);
        tvSignUp = findViewById(R.id.tvSignUp);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tilPassword = findViewById(R.id.tilPassword);
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnSubmit = findViewById(R.id.btnSubmit);

        clWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clWelcome.setVisibility(View.GONE);
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSignUpSelected = false;
                tvSignIn.setBackground(getResources().getDrawable(R.drawable.text_selected));
                tvSignIn.setTextColor(getResources().getColor(R.color.white_card));

                tvSignUp.setBackground(getResources().getDrawable(R.drawable.text_unselected));
                tvSignUp.setTextColor(getResources().getColor(R.color.red));

                tvSignIn.setElevation(4);
                tvSignUp.setElevation(0);

                btnSubmit.setText("Sign In");
                tvForgotPassword.setVisibility(View.VISIBLE);
                tilPassword.setEndIconMode(TextInputLayout.END_ICON_PASSWORD_TOGGLE);
                tilConfirmPassword.setVisibility(View.GONE);
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSignUpSelected = true;
                tvSignUp.setBackground(getResources().getDrawable(R.drawable.text_selected));
                tvSignUp.setTextColor(getResources().getColor(R.color.white_card));

                tvSignIn.setBackground(getResources().getDrawable(R.drawable.text_unselected));
                tvSignIn.setTextColor(getResources().getColor(R.color.red));

                tvSignUp.setElevation(4);
                tvSignIn.setElevation(0);

                btnSubmit.setText("Sign Up");
                tvForgotPassword.setVisibility(View.GONE);
                tilConfirmPassword.setVisibility(View.VISIBLE);
                tilPassword.setEndIconMode(TextInputLayout.END_ICON_NONE);
                tilConfirmPassword.setEndIconMode(TextInputLayout.END_ICON_NONE);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSignUpSelected) {
                    Toast.makeText(MainActivity.this, "Signing up!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Signing in!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void toggleButton(boolean isSelected) {
        if (isSelected) {
            tvSignIn.setBackground(getResources().getDrawable(R.drawable.text_selected));
            tvSignIn.setTextColor(getResources().getColor(R.color.white_card));

            tvSignUp.setBackground(getResources().getDrawable(R.drawable.text_unselected));
            tvSignUp.setTextColor(getResources().getColor(R.color.red));

            tvSignIn.setElevation(4);
            tvSignUp.setElevation(0);
        } else {
            tvSignUp.setBackground(getResources().getDrawable(R.drawable.text_selected));
            tvSignUp.setTextColor(getResources().getColor(R.color.white_card));

            tvSignIn.setBackground(getResources().getDrawable(R.drawable.text_unselected));
            tvSignIn.setTextColor(getResources().getColor(R.color.red));

            tvSignUp.setElevation(4);
            tvSignIn.setElevation(0);
        }
    }
}