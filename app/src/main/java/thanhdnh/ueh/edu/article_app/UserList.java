package thanhdnh.ueh.edu.article_app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserList {

  private ArrayList<UserProfile> users;

  public UserList() {

    users = new ArrayList<>();

  }


  public void addUser(UserProfile user) {

    users.add(user);

  }

  public UserProfile getUser(int position) {

    return users.get(position);

  }

  public int size() {

    return users.size();

  }

  public ArrayList<UserProfile> getUsers() {

    return users;

  }
}
