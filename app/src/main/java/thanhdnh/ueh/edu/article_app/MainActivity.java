package thanhdnh.ueh.edu.article_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity
        extends AppCompatActivity {

  private GridView gridUsers;

  private UserList userList;

  private UserAdapter userAdapter;

  @Override
  protected void onCreate(
          Bundle savedInstanceState
  ) {

    super.onCreate(savedInstanceState);

    setContentView(
            R.layout.activity_main
    );

    // ==========================================
    // GRID VIEW
    // ==========================================

    gridUsers =
            findViewById(
                    R.id.gridUsers
            );

    // ==========================================
    // USER LIST
    // ==========================================

    userList =
            UserData.createUserList();

    // ==========================================
    // ADAPTER
    // ==========================================

    userAdapter =
            new UserAdapter(
                    this,
                    userList.getUsers()
            );

    gridUsers.setAdapter(
            userAdapter
    );

    // ==========================================
    // CLICK USER
    // ==========================================

    gridUsers.setOnItemClickListener(
            (parent, view, position, id) -> {

              UserProfile user =
                      userList.getUser(
                              position
                      );

              Intent intent =
                      new Intent(
                              MainActivity.this,
                              ViewUserActivity.class
                      );

              intent.putExtra(
                      "id",
                      user.getId()
              );

              intent.putExtra(
                      "username",
                      user.getUsername()
              );


              intent.putExtra(
                      "email",
                      user.getEmail()
              );

              intent.putExtra(
                      "description",
                      user.getDescription()
              );

              intent.putExtra(
                      "avatar_url",
                      user.getAvatarUrl()
              );

              intent.putExtra(
                      "hobby",
                      user.getHobby()
              );

              startActivity(
                      intent
              );
            }
    );
  }
}