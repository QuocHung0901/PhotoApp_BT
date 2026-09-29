package thanhdnh.ueh.edu.article_app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {

  public static void downloadWithProgress(
          Context context,
          String imageUrl,
          ImageView imageView,
          ProgressBar progressBar
  ) {

    imageView.setImageDrawable(null);


    if (imageUrl == null
            || imageUrl.trim().isEmpty()) {

      if (progressBar != null) {
        progressBar.setVisibility(View.GONE);
      }

      return;
    }

    if (progressBar != null) {
      progressBar.setVisibility(View.VISIBLE);
    }


    if (imageUrl.startsWith("drawable/")) {

      String imageName =
              imageUrl.replace(
                      "drawable/",
                      ""
              );

      int resourceId =
              context.getResources()
                      .getIdentifier(
                              imageName,
                              "drawable",
                              context.getPackageName()
                      );

      if (resourceId != 0) {

        imageView.setImageResource(
                resourceId
        );
      }

      if (progressBar != null) {

        progressBar.setVisibility(
                View.GONE
        );
      }

      return;
    }
    if (imageUrl.startsWith(
            "android.resource://"
    )) {

      imageView.setImageURI(
              Uri.parse(imageUrl)
      );

      if (progressBar != null) {

        progressBar.setVisibility(
                View.GONE
        );
      }

      return;
    }
    new Thread(() -> {

      Bitmap bitmap = null;

      HttpURLConnection connection = null;

      InputStream inputStream = null;

      try {

        URL url =
                new URL(imageUrl);

        connection =
                (HttpURLConnection)
                        url.openConnection();

        connection.setDoInput(true);

        connection.setConnectTimeout(10000);

        connection.setReadTimeout(10000);

        connection.connect();

        inputStream =
                connection.getInputStream();

        bitmap =
                BitmapFactory.decodeStream(
                        inputStream
                );

      } catch (Exception e) {

        e.printStackTrace();

      } finally {

        try {

          if (inputStream != null) {
            inputStream.close();
          }

        } catch (Exception ignored) {
        }

        if (connection != null) {
          connection.disconnect();
        }
      }

      Bitmap finalBitmap = bitmap;

      // Chạy lại trên UI Thread
      imageView.post(() -> {

        if (finalBitmap != null) {

          imageView.setImageBitmap(
                  finalBitmap
          );
        }


        if (progressBar != null) {

          progressBar.setVisibility(
                  View.GONE
          );
        }
      });

    }).start();
  }

  public static void downloadWithProgress(
          Context context,
          String imageUrl,
          ImageView imageView
  ) {

    downloadWithProgress(
            context,
            imageUrl,
            imageView,
            null
    );
  }
}