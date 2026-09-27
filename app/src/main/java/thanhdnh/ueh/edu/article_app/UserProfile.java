package thanhdnh.ueh.edu.article_app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfile {

  private String id;
  private String username;
  private String email;
  private String description;

  // Chỉ lưu đường dẫn tới avatar
  private String avatarUrl;

  private String hobby;

  public UserProfile(
          String id,
          String username,
          String email,
          String description,
          String avatarUrl,
          String hobby
  ) {

    this.id = id;
    this.username = username;
    this.email = email;
    this.description = description;
    this.avatarUrl = avatarUrl;
    this.hobby = hobby;
  }

  public String getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getDescription() {
    return description;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public String getHobby() {
    return hobby;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }
}
