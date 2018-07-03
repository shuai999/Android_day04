package cn.novate.android_day04.simple2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
        setContentView(R.layout.activity_test_02);

        iv = (ImageView) findViewById(R.id.iv);

        copyBitmap(iv) ;
    }


    /**
     * 在内存中创建原图的副本
     */
    private void copyBitmap(ImageView iv) {
        // 1. 得到原图
        // 根据图片的资源id获取图片的对象
        Bitmap srcPic = BitmapFactory.decodeResource(getResources(), R.drawable.meinv);
        // 2. 参考原图创建一个空白纸张
        // 根据指定的宽、高，配置信息创建图片对象
        Bitmap copyPic = Bitmap.createBitmap(srcPic.getWidth(), srcPic.getHeight(), srcPic.getConfig());
        // 3. 参照空白纸张创建一个画板
        Canvas canvas = new Canvas(copyPic) ;
        // 4. 创建一个画笔
        Paint paint = new Paint() ;
        // 设置画笔颜色
        paint.setColor(Color.BLACK);
        // 5. 使用画笔在画板上边画画
        canvas.drawBitmap(srcPic , new Matrix() , paint);
        iv.setImageBitmap(copyPic);
    }
}
