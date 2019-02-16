package com.example.kengo.hackathondemo;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraView extends SurfaceView implements SurfaceHolder.Callback, Camera.PictureCallback {
    private Camera mCamera = null;
    private  static final String SAVE_PICTURE_FOLDER = "/picture/CameraSample";

    public CameraView(Context context){
        super(context);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        // 保存用フォルダを作成
        File dirs = new File(SAVE_PICTURE_FOLDER);
        if (!dirs.exists()){
            dirs.mkdir();
        }
    }
    @Override
    public void onPictureTaken(byte[] data, Camera camera){
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd_kkmmss");
        String datName = "P" + date.format(new Date() + ".jpg");
        try {
            savePictureData(datName, data);
        }
        catch (Exception e){
            if (mCamera != null){
                mCamera.release();
                mCamera = null;
            }
        }
        mCamera.startPreview();
    }

    // 撮影画像を保存する
    private void savePictureData(String datName, byte[] data) throws Exception{
        FileOutputStream
    }
}
