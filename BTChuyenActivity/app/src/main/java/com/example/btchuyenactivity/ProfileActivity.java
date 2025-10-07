package com.example.btchuyenactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    // Khai báo các view
    private TextView profileNameTextView;
    private ImageButton settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Ánh xạ các view
        profileNameTextView = findViewById(R.id.textViewProfileName);
        settingsButton = findViewById(R.id.buttonSettings);

        // Nhận Intent đã khởi tạo Activity này
        Intent intent = getIntent();

        // Lấy dữ liệu được gửi từ LoginActivity thông qua key "USER_NAME"
        String userName = intent.getStringExtra("USER_NAME");

        // Kiểm tra xem dữ liệu có tồn tại và không rỗng không, sau đó hiển thị
        if (userName != null && !userName.isEmpty()) {
            profileNameTextView.setText(userName);
        }

        // Thiết lập sự kiện click cho nút Settings để quay về Login
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo intent để quay lại LoginActivity
                Intent backIntent = new Intent(ProfileActivity.this, LoginActivity.class);

                // Cờ này giúp xóa các activity trung gian và tạo task mới,
                // tránh việc bấm back lại quay về profile
                backIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(backIntent);
            }
        });
    }
}