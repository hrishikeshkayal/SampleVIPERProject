package com.codeeden.sampleviperproject.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;


import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.codeeden.sampleviperproject.R;


/**
 * Created by imran khan on 01-05-2016.
 */
public class GLideDownloader {

//    public static void setGlideImage(Context context, CircleImageView imageView, String path) {
//        if (path == null)
//            return;
//        if (imageView == null)
//            return;
//
//        if (path.trim().length() > 0) {
//            Glide.with(context).load(path).placeholder(R.drawable.profile_icon)
//                    .error(R.drawable.profile_icon)
//                    .priority(Priority.HIGH)
//                    .diskCacheStrategy(DiskCacheStrategy.NONE)
//                    .skipMemoryCache(false).into(imageView);
//        } else {
//            imageView.setImageResource(R.drawable.register_ic_profile_pic_bg);
//        }
//    }

   /* public static void setGlideImage(final Context context, final CircleImageView imageView, String path, final ProgressBar progressBar) {
        progressBar.setIndeterminateDrawable(context.getResources().getDrawable(R.drawable.progress));
        if (path == null)
            return;

        if (imageView == null)
            return;

        if (path.trim().length() > 0) {
            progressBar.setVisibility(View.VISIBLE);
            Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.NONE)
                    .priority(Priority.HIGH)
                    .skipMemoryCache(true).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }
            }).into(imageView);
        } else {
            if (progressBar.isShown())
                progressBar.setVisibility(View.GONE);
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
        }
    }

    public static void setGlideImage(final Context context, final CircleImageView imageView, String path) {
        if (path == null)
            return;

        if (imageView == null)
            return;

        if (path.trim().length() > 0) {

            Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.NONE)
                    .priority(Priority.HIGH)
                    .skipMemoryCache(true).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {

                    imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                    return false;
                }
            }).into(imageView);
        } else {

            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
        }
    }

    public static void setGlideGifImageCache(final Context context, final ImageView imageView, String path) {

        if (path == null)
            return;

        if (imageView == null)
            return;

        if (path.trim().length() > 0) {
            Glide.with(context).load(path)
                    .asGif().diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .skipMemoryCache(false).listener(new RequestListener<String, GifDrawable>() {

                @Override
                public boolean onException(Exception e, String model, Target<GifDrawable> target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(GifDrawable resource, String model, Target<GifDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                    return false;
                }
            }).into(imageView);
        } else {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
        }
    }*/

    public static void setGlideGifLocalImageCache(final Context context, final ImageView imageView, String path) {

        if (path == null)
            return;

        if (imageView == null)
            return;


        if (path.trim().length() > 0) {
            Glide.with(context).load(getImage(path,context))
                    .asGif().diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .skipMemoryCache(false).listener(new RequestListener<Integer, GifDrawable>() {
                @Override
                public boolean onException(Exception e, Integer model, Target<GifDrawable> target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(GifDrawable resource, Integer model, Target<GifDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    return false;
                }
            }).into(imageView);
        } else {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
        }
    }

    public static int getImage(String imageName, Context context) {

        int drawableResourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());

        return drawableResourceId;
    }

    public static void setGlideGifImageCache(final Context context, final ImageView imageView, int path) {

        if (path == 0)
            return;

        if (imageView == null)
            return;

            Glide.with(context).load(path)
                    .asGif().diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .skipMemoryCache(false).listener(new RequestListener<Integer, GifDrawable>() {
                @Override
                public boolean onException(Exception e, Integer model, Target<GifDrawable> target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(GifDrawable resource, Integer model, Target<GifDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    return false;
                }
            }).into(imageView);

    }


    public static Bitmap drawableToBitmap (Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if(bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static void setGlideImage(final Context context, final ImageView imageView, String path) {
        if (path == null)
            return;

        if (imageView == null)
            return;

        if (path.trim().length() > 0) {

            Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.NONE)
                    .priority(Priority.HIGH)
                    .skipMemoryCache(true).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {

                    imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                    return false;
                }
            }).into(imageView);
        } else {

            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
        }
    }

    /*public static void setGlideImage(final Context context, final CircleImageView imageView, String path, final int defaultImage) {
        if (path == null)
            return;

        if (imageView == null)
            return;

        if (path.trim().length() > 0) {

            Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.NONE)
                    .priority(Priority.HIGH)
                    .skipMemoryCache(true).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {

                    imageView.setImageDrawable(context.getResources().getDrawable(defaultImage));
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                    return false;
                }
            }).into(imageView);
        } else {

            imageView.setImageDrawable(context.getResources().getDrawable(defaultImage));
        }
    }*/

    /*public static void setGlideImageCache(final Context context, final CircleImageView imageView, String path, final int defaultImage) {
        if (path == null)
            return;

        if (imageView == null)
            return;

        if (path.trim().length() > 0) {

            Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .skipMemoryCache(false).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {

                    imageView.setImageDrawable(context.getResources().getDrawable(defaultImage));
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                    return false;
                }
            }).into(imageView);
        } else {

            imageView.setImageDrawable(context.getResources().getDrawable(defaultImage));
        }
    }*/


    /*public static void setGlideImage(Context context, ImageView imageView, String path) {
        if (path == null)
            return;
        if (imageView == null)
            return;

        if (path.trim().length() > 0) {
            Glide.with(context).load(path).placeholder(R.drawable.profile_icon)
                    .error(R.drawable.profile_icon)
                    .priority(Priority.HIGH)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true).into(imageView);
        } else {
            imageView.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }*/

    public static void setGlideImage(final Context context, final ImageView imageView, String path, final ProgressBar progressBar) {
        //progressBar.setIndeterminateDrawable(context.getResources().getDrawable(R.drawable.progress));
        if (path == null)
            return;

        if (imageView == null)
            return;

        if (path.trim().length() > 0) {
            progressBar.setVisibility(View.VISIBLE);
            Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.NONE)
                    .priority(Priority.HIGH)
                    .skipMemoryCache(true).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }
            }).into(imageView);
        } else {
            if (progressBar.isShown())
                progressBar.setVisibility(View.GONE);
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
        }
    }
    public static void setGlideImageCache(final Context context, final ImageView imageView, String path, final ProgressBar progressBar) {
        //progressBar.setIndeterminateDrawable(context.getResources().getDrawable(R.drawable.progress));
        if (path == null)
            return;

        if (imageView == null)
            return;

        if (path.trim().length() > 0) {
            progressBar.setVisibility(View.VISIBLE);
            Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .skipMemoryCache(false).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }
            }).into(imageView);
        } else {
            if (progressBar.isShown())
                progressBar.setVisibility(View.GONE);
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
        }
    }

    public static void setGlideImageCache(final Context context, final ImageView imageView, String path) {

        if (path == null)
            return;

        if (imageView == null)
            return;

        if (path.trim().length() > 0) {
            Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .skipMemoryCache(false).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    return false;
                }
            }).into(imageView);
        } else {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
        }
    }

    /*public static void setGlideImageCache(final Context context, final CircleImageView imageView, String path) {

        if (path == null)
            return;

        if (imageView == null)
            return;

        if (path.trim().length() > 0) {
            Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .skipMemoryCache(false).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    *//*imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));*//*
                    return false;
                }
            }).into(imageView);
        } else {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
        }
    }*/
}
