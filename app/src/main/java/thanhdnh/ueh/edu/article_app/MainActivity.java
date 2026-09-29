package thanhdnh.ueh.edu.article_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private GridView gridUsers;

    private UserList userList;

    private UserAdapter userAdapter;

    private static final String USER_DATA_URL =
            "https://raw.githubusercontent.com/QuocHung0901/PhotoApp_BT/master/data/users.json";

    @Override
    protected void onCreate(
            Bundle savedInstanceState
    ) {

        super.onCreate(savedInstanceState);

        setContentView(
                R.layout.activity_main
        );
        gridUsers =
                findViewById(
                        R.id.gridUsers
                );

        gridUsers.setOnItemClickListener(
                (parent, view, position, id) -> {

                    if (userList == null) {
                        return;
                    }

                    UserProfile user =
                            userList.getUser(position);

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

                    startActivity(intent);
                }
        );

        loadUsers();
    }

    private void loadUsers() {

        UserData.loadData(
                USER_DATA_URL,

                new UserData.OnUserDataLoadedListener() {

                    @Override
                    public void onLoaded(
                            UserList loadedUserList
                    ) {

                        if (loadedUserList == null
                                || loadedUserList.getUsers() == null) {

                            Toast.makeText(
                                    MainActivity.this,
                                    "Dữ liệu JSON không hợp lệ",
                                    Toast.LENGTH_LONG
                            ).show();

                            return;
                        }

                        userList = loadedUserList;

                        userAdapter =
                                new UserAdapter(
                                        MainActivity.this,
                                        userList.getUsers()
                                );

                        gridUsers.setAdapter(
                                userAdapter
                        );
                    }

                    @Override
                    public void onError(
                            Exception exception
                    ) {

                        Toast.makeText(
                                MainActivity.this,
                                "Không tải được dữ liệu từ GitHub",
                                Toast.LENGTH_LONG
                        ).show();

                        exception.printStackTrace();
                    }
                }
        );
    }
}