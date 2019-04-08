package com.square63.caremap.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.widget.Toast;

import com.square63.caremap.listeners.IPermissionsCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class PermissionsHelper {
    private final static int ALL_PERMISSIONS_RESULT = 107;
    private ArrayList permissions = new ArrayList();
    private ArrayList permissionsToRequest;
    private Activity context;
    private static final int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 5;
    private static final int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_LOCATION = 6;
    public PermissionsHelper(){

    }
    public PermissionsHelper(Activity context){
        this.context = context;
    }

    private void initPermissions() {
        permissions.add(CAMERA);
        permissions.add(WRITE_EXTERNAL_STORAGE);
        permissionsToRequest = findUnAskedPermissions(permissions);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


            if (permissionsToRequest.size() > 0)
                context.requestPermissions((String[]) permissionsToRequest.toArray(new String[permissionsToRequest.size()]), ALL_PERMISSIONS_RESULT);
        }

    }
    private ArrayList findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList result = new ArrayList();

        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }

        return result;
    }

    private boolean hasPermission(String permission) {
        if (canMakeSmores()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }

    private boolean canMakeSmores() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }
    public void checkCameraMultiplePermissions(IPermissionsCallback iPermissionsCallback) {
        if (Build.VERSION.SDK_INT >= 23) {
            List<String> permissionsNeeded = new ArrayList<String>();
            List<String> permissionsList = new ArrayList<String>();
            if(!addPermission(permissionsList, android.Manifest.permission.CAMERA))
            {
                permissionsNeeded.add("Camera");
            }

            if (!addPermission(permissionsList, android.Manifest.permission.READ_EXTERNAL_STORAGE))
            {
                permissionsNeeded.add("Read Storage");
            }

            if(!addPermission(permissionsList, android.Manifest.permission.WRITE_EXTERNAL_STORAGE))
            {
                permissionsNeeded.add("Write Storage");
            }



            if (permissionsList.size() > 0)
            {
                context.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
            }
            else{
                iPermissionsCallback.onPermissionsGranted();
            }
        }else {
            iPermissionsCallback.onPermissionsGranted();
        }

    }


    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults, IPermissionsCallback iPermissionsCallback) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS: {

                Map<String, Integer> perms = new HashMap<String, Integer>();
                // Initial
                perms.put(android.Manifest.permission.CAMERA, PackageManager.PERMISSION_GRANTED);
                perms.put(android.Manifest.permission.READ_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                perms.put(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);


                // Fill with results
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                if (perms.get(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                        && perms.get(android.Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED
                        && perms.get(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED) {
                    // All Permissions Granted
                    iPermissionsCallback.onPermissionsGranted();
                    return;
                } else {
                    // Permission Denied
                    if (Build.VERSION.SDK_INT >= 23) {
                        Toast.makeText(context, "Please permit all the permissions", Toast.LENGTH_LONG).show();
                        //finish();
                    }
                }
            }
            break;
            case REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_LOCATION:{
                Map<String, Integer> perms = new HashMap<String, Integer>();
                // Initial
                perms.put(Manifest.permission.ACCESS_COARSE_LOCATION, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);


                // Fill with results
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                if (perms.get(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED
                        ) {
                    // All Permissions Granted
                    iPermissionsCallback.onPermissionsGranted();
                    return;
                } else {
                    // Permission Denied
                    if (Build.VERSION.SDK_INT >= 23) {
                        iPermissionsCallback.onPermissionsGranted();
                        //finish();
                    }
                }

            }
            break;

        }
    }
    public void checkLocationMultiplePermissions(IPermissionsCallback iPermissionsCallback) {
        if (Build.VERSION.SDK_INT >= 23) {
            List<String> permissionsNeeded = new ArrayList<String>();
            List<String> permissionsList = new ArrayList<String>();
            if(!addPermission(permissionsList, android.Manifest.permission.ACCESS_FINE_LOCATION))
            {
                permissionsNeeded.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
            }

            if (!addPermission(permissionsList, Manifest.permission.ACCESS_COARSE_LOCATION))
            {
                permissionsNeeded.add( Manifest.permission.ACCESS_COARSE_LOCATION);
            }





            if (permissionsList.size() > 0)
            {
                context.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_LOCATION);
            }
            else{
                iPermissionsCallback.onPermissionsGranted();
            }
        }

    }




    private boolean addPermission(List<String> permissionsList, String permission) {
        if (Build.VERSION.SDK_INT >= 23)

            if (context.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(permission);

                // Check for Rationale Option
                if (!context.shouldShowRequestPermissionRationale(permission))
                    return false;
            }
        return true;
    }

}
