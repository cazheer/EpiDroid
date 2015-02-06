package com.example.sparkh.epiandroid.API;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.lang.ref.WeakReference;

/**
 * AsyncTask to download an image from an URL and attach it to an ImageView.
 */
public class DownloadImage extends AsyncTask<String, Void, Bitmap> {

    /** The url from where to download the image. */
    private String url;

    /** Reference to the view which should receive the image */
    private final WeakReference<ImageView> imageRef;

    /**
     * Constructor.
     *
     * @param imageView The ImageView which will receive the image.
     */
    public DownloadImage(ImageView imageView, String url) {
        this.imageRef = new WeakReference<>(imageView);
        this.url = url;
    }

    /**
     * This function will be executed to download the image in a background
     * process.
     *
     */
    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            InputStream in = new java.net.URL(url).openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(in);
            return bitmap;
        } catch (Exception e) {
            Log.e("ImageDownload", e.getMessage());
        }
        return null;
    }

    /**
     * This function will be called after the image download and attaches
     * the bitmap to the ImageView.
     *
     */
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (isCancelled()) {
            bitmap = null;
        }

        if (imageRef != null) {
            ImageView imageView = imageRef.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

}