package com.square63.caremap.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.square63.caremap.R;
import com.square63.caremap.listeners.IPickerCallBack;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


import static android.Manifest.permission.CAMERA;

public class ImagePickerHelper {

    private final int PICK_IMAGE_CAMERA = 1, PICK_IMAGE_GALLERY = 2;
    Bitmap myBitmap;
    private Bitmap bitmap;
    Uri picUri;
    private Activity context;
    private InputStream inputStreamImg;
    private File destination = null;

    private String imgPath = null;
    private IPickerCallBack iPickerCallBack;

    public ImagePickerHelper(){

    }
    public ImagePickerHelper(Activity context){
        this.context = context;

    }
    private Uri getCaptureImageOutputUri() {
        Uri outputFileUri = null;
        File getImage = context.getExternalCacheDir();
        if (getImage != null) {
            outputFileUri = Uri.fromFile(new File(getImage.getPath(), "profile.png"));
        }
        return outputFileUri;
    }

    private String getFilePathFromCursor() {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        if (picUri != null) {
            android.database.Cursor cursor = context.getContentResolver().query(picUri, filePathColumn, null, null, null);
            if (cursor == null)
                return null;

            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String filePath = cursor.getString(columnIndex);
            cursor.close();
            return filePath;
        }
        return null;
    }

    private float pxFromDp(float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    public void setImage(Intent data) {
        Bitmap bitmap;
        if (data != null) {
            if (getPickImageResultUri(data) != null) {
                picUri = getPickImageResultUri(data);
                File file = new File(getFilePathFromCursor());


                try {
                    myBitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), picUri);
                    myBitmap = rotateImageIfRequired(myBitmap, picUri);
                    myBitmap = getResizedBitmap(myBitmap, (int) pxFromDp(150f));
                    // profilePicture.setImageBitmap(myBitmap);


                } catch (IOException e) {
                    e.printStackTrace();
                }


            } else {


                bitmap = (Bitmap) data.getExtras().get("data");


                // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
                picUri = getImageUri(context, bitmap);
                File finalFile = new File(getRealPathFromURI(picUri));

                // CALL THIS METHOD TO GET THE ACTUAL PATH

                myBitmap = bitmap;


            }

        }
       // profile_image.setImageBitmap(myBitmap);
        iPickerCallBack.onImageSelected(myBitmap);
    }

    public Uri getPickImageResultUri(Intent data) {
        boolean isCamera = true;
        if (data != null) {
            String action = data.getAction();
            isCamera = action != null && action.equals(MediaStore.ACTION_IMAGE_CAPTURE);
        }


        return isCamera ? getCaptureImageOutputUri() : data.getData();
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    private static Bitmap rotateImageIfRequired(Bitmap img, Uri selectedImage) throws IOException {

        ExifInterface ei = new ExifInterface(selectedImage.getPath());
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return rotateImage(img, 90);
            case ExifInterface.ORIENTATION_ROTATE_180:
                return rotateImage(img, 180);
            case ExifInterface.ORIENTATION_ROTATE_270:
                return rotateImage(img, 270);
            default:
                return img;
        }
    }

    private static Bitmap rotateImage(Bitmap img, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
        img.recycle();
        return rotatedImg;
    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 0) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    public void selectImage(IPickerCallBack iPickerCallBack) {
        try {
            this.iPickerCallBack = iPickerCallBack;
            PackageManager pm = context.getPackageManager();
            int hasPerm = pm.checkPermission(CAMERA, context.getPackageName());
            final CharSequence[] options = {context.getResources().getString(R.string.camera_take_photo),
                    context.getResources().getString(R.string.camera_gallery), context.getResources().getString(R.string.camera_cancel)};
            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
            builder.setTitle(context.getResources().getString(R.string.camera_select_option));
            builder.setItems(options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int item) {
                    if (options[item].equals(context.getResources().getString(R.string.camera_take_photo))) {
                        dialog.dismiss();
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        context.startActivityForResult(intent, PICK_IMAGE_CAMERA);
                    } else if (options[item].equals(context.getResources().getString(R.string.camera_gallery))) {
                        dialog.dismiss();
                        Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        context.startActivityForResult(pickPhoto, PICK_IMAGE_GALLERY);
                    } else if (options[item].equals(context.getResources().getString(R.string.camera_cancel))) {
                        dialog.dismiss();
                    }
                }
            });
            builder.show();

        } catch (Exception e) {
            Toast.makeText(context, context.getResources().getString(R.string.error_some_thing_went_wrong), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        inputStreamImg = null;
        if (requestCode == PICK_IMAGE_CAMERA) {
            try {
                // picUri = data.getData();
                bitmap = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bytes);
                picUri = getImageUri(context, bitmap);
                Log.e("Activity", "Pick from Camera::>>> ");

                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
                destination = new File(Environment.getExternalStorageDirectory() + "/" +
                        context.getString(R.string.app_name), "IMG_" + timeStamp + ".jpg");
                FileOutputStream fo;
                try {
                    destination.createNewFile();
                    fo = new FileOutputStream(destination);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                imgPath = destination.getAbsolutePath();
               // profile_image.setImageBitmap(bitmap);
                iPickerCallBack.onImageSelected(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (requestCode == PICK_IMAGE_GALLERY) {

            try {
                Uri imgUri = data.getData();
                bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), imgUri);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 10, bytes);
                Log.e("Activity", "Pick from Gallery::>>> ");
                //picUri = getImageUri(context, bitmap);
                //imgPath = getRealPathFromURI(picUri);
                //destination = new File(imgPath.toString());
               // profile_image.setImageBitmap(bitmap);
                setImage(data);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
