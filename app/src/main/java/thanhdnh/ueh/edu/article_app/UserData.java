package thanhdnh.ueh.edu.article_app;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserData {

    public interface OnUserDataLoadedListener {

        void onLoaded(UserList userList);

        void onError(Exception exception);
    }

    public static void loadData(
            String jsonUrl,
            OnUserDataLoadedListener listener
    ) {

        new Thread(() -> {

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {

                // =========================================
                // MỞ URL JSON
                // =========================================

                URL url = new URL(jsonUrl);

                connection =
                        (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");
                connection.setConnectTimeout(10000);
                connection.setReadTimeout(10000);

                connection.connect();

                // =========================================
                // ĐỌC NỘI DUNG JSON
                // =========================================

                reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        connection.getInputStream()
                                )
                        );

                StringBuilder json =
                        new StringBuilder();

                String line;

                while ((line = reader.readLine()) != null) {

                    json.append(line);
                }

                // =========================================
                // JSON -> USER LIST
                // =========================================

                Gson gson = new Gson();

                UserList userList =
                        gson.fromJson(
                                json.toString(),
                                UserList.class
                        );

                // =========================================
                // TRẢ KẾT QUẢ VỀ UI THREAD
                // =========================================

                new Handler(
                        Looper.getMainLooper()
                ).post(() -> {

                    listener.onLoaded(userList);
                });

            } catch (Exception e) {

                new Handler(
                        Looper.getMainLooper()
                ).post(() -> {

                    listener.onError(e);
                });

            } finally {

                try {

                    if (reader != null) {
                        reader.close();
                    }

                } catch (Exception ignored) {
                }

                if (connection != null) {
                    connection.disconnect();
                }
            }

        }).start();
    }
}