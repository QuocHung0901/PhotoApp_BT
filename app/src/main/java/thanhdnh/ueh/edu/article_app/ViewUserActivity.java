package thanhdnh.ueh.edu.article_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_user);

        // ==========================================
        // ÁNH XẠ VIEW
        // ==========================================

        TextView txtUsername =
                findViewById(R.id.txtUsername);

        TextView txtId =
                findViewById(R.id.txtId);

        TextView txtEmail =
                findViewById(R.id.txtEmail);

        TextView txtDescription =
                findViewById(R.id.txtDescription);

        TextView txtHobby =
                findViewById(R.id.txtHobby);

        ImageView imgAvatar =
                findViewById(R.id.imgAvatar);

        ProgressBar progressAvatar =
                findViewById(R.id.progressAvatar);

        Button btnBack =
                findViewById(R.id.btnBack);

        // ==========================================
        // NHẬN DATA TỪ MAINACTIVITY
        // ==========================================

        String id =
                getIntent().getStringExtra("id");

        String username =
                getIntent().getStringExtra("username");

        String email =
                getIntent().getStringExtra("email");

        String description =
                getIntent().getStringExtra("description");

        String avatarUrl =
                getIntent().getStringExtra("avatar_url");

        String hobby =
                getIntent().getStringExtra("hobby");

        // ==========================================
        // HIỂN THỊ THÔNG TIN USER
        // ==========================================

        txtUsername.setText(username);

        txtId.setText(
                "ID: " + id
        );

        txtEmail.setText(
                "Email: " + email
        );

        txtDescription.setText(
                description
        );

        txtHobby.setText(
                hobby
        );



        // ==========================================
        // LOAD AVATAR
        // ==========================================

        Downloader.downloadWithProgress(
                this,
                avatarUrl,
                imgAvatar,
                progressAvatar
        );

        // ==========================================
        // BACK
        // ==========================================

        btnBack.setOnClickListener(
                view -> finish()
        );
    }
}