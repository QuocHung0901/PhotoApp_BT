package thanhdnh.ueh.edu.article_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

  private Context context;

  private ArrayList<UserProfile> userList;

  private LayoutInflater inflater;

  public UserAdapter(
          Context context,
          ArrayList<UserProfile> userList
  ) {

    this.context = context;

    this.userList = userList;

    inflater = LayoutInflater.from(context);
  }

  @Override
  public int getCount() {

    return userList.size();
  }

  @Override
  public Object getItem(int position) {

    return userList.get(position);
  }

  @Override
  public long getItemId(int position) {

    return position;
  }

  @Override
  public View getView(
          int position,
          View convertView,
          ViewGroup parent
  ) {

    ViewHolder holder;

    if (convertView == null) {

      convertView =
              inflater.inflate(
                      R.layout.user_disp_tpl,
                      parent,
                      false
              );

      holder = new ViewHolder();

      holder.imgAvatar =
              convertView.findViewById(
                      R.id.imgAvatar
              );

      holder.txtUsername =
              convertView.findViewById(
                      R.id.txtUsername
              );

      holder.progressAvatar =
              convertView.findViewById(
                      R.id.progressAvatar
              );

      convertView.setTag(holder);

    } else {

      holder =
              (ViewHolder)
                      convertView.getTag();
    }

    UserProfile user =
            userList.get(position);

    holder.txtUsername.setText(
            user.getUsername()
    );

    Downloader.downloadWithProgress(
            context,
            user.getAvatarUrl(),
            holder.imgAvatar,
            holder.progressAvatar
    );


    return convertView;
  }

  private static class ViewHolder {

    ImageView imgAvatar;

    TextView txtUsername;

    ProgressBar progressAvatar;
  }
}