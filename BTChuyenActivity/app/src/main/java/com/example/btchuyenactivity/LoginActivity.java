package com.example.btchuyenactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    // Khai báo các view
    private EditText userNameEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Ánh xạ các view từ layout XML
        userNameEditText = findViewById(R.id.editTextUserName);
        loginButton = findViewById(R.id.buttonLogin);

        // Thiết lập sự kiện click cho button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy tên người dùng từ EditText
                String userName = userNameEditText.getText().toString();

                // Tạo một Intent để chuyển sang ProfileActivity
                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);

                // Gửi dữ liệu (tên người dùng) sang ProfileActivity
                // "USER_NAME" là một key để định danh dữ liệu
                intent.putExtra("USER_NAME", userName);

                // Bắt đầu Activity mới
                startActivity(intent);
            }
        });
    }
}