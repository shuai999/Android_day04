package cn.novate.android_day04.simple1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import cn.novate.android_day04.R;

/**
 * Created by Administrator on 2018/7/3.
 */

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_01);

        iv = (ImageView) findViewById(R.id.iv);
        zoomPicture(iv) ;
    }


    /**
     * 缩放图片加载到内存中，并且显示到ImageView上
     */
    private void zoomPicture(ImageView iv) {
        // 1. 得到原图的分辨率
        Options opts = new Options();
        // 设置为true表示：只返回图片的分辨率，设置给 outWidth、outHeight
        opts.inJustDecodeBounds = true ;
        // sd卡下的 lp.jpg
        BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()
                + "/lp.jpg", opts);
        // 得到原图的分辨率
        int srcWidth = opts.outWidth ;
        int srcHeight= opts.outHeight ;

        // 2. 得到设备分辨率
        // 获取系统提供的窗口管理器
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        // 获取默认分辨率
        Display defaultDisplay = wm.getDefaultDisplay();

        // 得到设备屏幕分辨率
        int screenWidth = defaultDisplay.getWidth();
        int screenHeight = defaultDisplay.getHeight();

        // 3. 通过比较获取合适的比例值
        // 原图的宽3000,高是2262 屏幕的宽320,高480 3000/320=9 2262/480=5
        int scale = 1 ;
        int sx = srcWidth/screenWidth ;
        int sy = srcHeight/screenHeight ;

        // 通过比较得到大的比例值
        if(sx > sy && sx > 1){
            scale = sx;
        }
        if(sy > sx && sy > 1){
            scale = sy;
        }
        // 4. 根据比例值，缩放图片并加载到内存中
        // 设置为false，可以让BitmapFactory.decodeFile返回一个图片对象，加载内存
        opts.inJustDecodeBounds = false ;
        // 把比例值设置这个变量，就会按照这个比例值缩放图片
        opts.inSampleSize = scale ;
        Bitmap bm = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()
                + "/lp.jpg", opts);
        iv.setImageBitmap(bm);
    }

}
