package cn.novate.android_day04.simple3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import cn.novate.android_day04.R;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/7/3 16:28
 * Version 1.0
 * Params:
 * Description:    平移、缩放、旋转、镜面、倒影
*/

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_03);

        iv = (ImageView) findViewById(R.id.iv);
    }

    public void scale(View v) {
        // 1.得到原图;
        // 根据图片的资源ID得到图片对象
        Bitmap srcPic = BitmapFactory.decodeResource(getResources(),
                R.drawable.meinv);
        // 2.参考原图创建一个空白纸张;
        // 根据指定的宽,高,配置信息创建图片对象
        Bitmap copyPic = Bitmap.createBitmap(srcPic.getWidth(),
                srcPic.getHeight(), srcPic.getConfig());
        // 3.参考空白纸张创建一个画板;
        Canvas canvas = new Canvas(copyPic);
        // 4.创建一个画笔;
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        // matrix表示图形使用矩阵对象,里面封装处理图形的api
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);

        // 5.使用画笔在画板上画画;
        // srcPic 参考的原图
        // matrix表示图形使用矩阵对象,里面封装处理图形的api
        // paint画画使用的画笔
        canvas.drawBitmap(srcPic, matrix, paint);

        iv.setImageBitmap(copyPic);
    }


    public void trans(View v) {
        // 1.得到原图;
        // 根据图片的资源ID得到图片对象
        Bitmap srcPic = BitmapFactory.decodeResource(getResources(),
                R.drawable.meinv);
        // 2.参考原图创建一个空白纸张;
        // 根据指定的宽,高,配置信息创建图片对象
        Bitmap copyPic = Bitmap.createBitmap(srcPic.getWidth(),
                srcPic.getHeight(), srcPic.getConfig());
        // 3.参考空白纸张创建一个画板;
        Canvas canvas = new Canvas(copyPic);
        // 4.创建一个画笔;
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        // matrix表示图形使用矩阵对象,里面封装处理图形的api
        Matrix matrix = new Matrix();

        matrix.setTranslate(30, 30);
        // 5.使用画笔在画板上画画;
        // srcPic 参考的原图
        // matrix表示图形使用矩阵对象,里面封装处理图形的api
        // paint画画使用的画笔
        canvas.drawBitmap(srcPic, matrix, paint);

        iv.setImageBitmap(copyPic);
    }

    public void rotate(View v) {
        // 1.得到原图;
        // 根据图片的资源ID得到图片对象
        Bitmap srcPic = BitmapFactory.decodeResource(getResources(),
                R.drawable.meinv);
        // 2.参考原图创建一个空白纸张;
        // 根据指定的宽,高,配置信息创建图片对象
        Bitmap copyPic = Bitmap.createBitmap(srcPic.getWidth(),
                srcPic.getHeight(), srcPic.getConfig());
        // 3.参考空白纸张创建一个画板;
        Canvas canvas = new Canvas(copyPic);
        // 4.创建一个画笔;
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        // matrix表示图形使用矩阵对象,里面封装处理图形的api
        Matrix matrix = new Matrix();
        matrix.setRotate(90, srcPic.getWidth()/2, srcPic.getHeight()/2);
        // 5.使用画笔在画板上画画;
        // srcPic 参考的原图
        // matrix表示图形使用矩阵对象,里面封装处理图形的api
        // paint画画使用的画笔
        canvas.drawBitmap(srcPic, matrix, paint);

        iv.setImageBitmap(copyPic);
    }


    public void jm(View v) {
        // 1.得到原图;
        // 根据图片的资源ID得到图片对象
        Bitmap srcPic = BitmapFactory.decodeResource(getResources(),
                R.drawable.meinv);
        // 2.参考原图创建一个空白纸张;
        // 根据指定的宽,高,配置信息创建图片对象
        Bitmap copyPic = Bitmap.createBitmap(srcPic.getWidth(),
                srcPic.getHeight(), srcPic.getConfig());
        // 3.参考空白纸张创建一个画板;
        Canvas canvas = new Canvas(copyPic);
        // 4.创建一个画笔;
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        // matrix表示图形使用矩阵对象,里面封装处理图形的api
        Matrix matrix = new Matrix();
        // 镜面
        matrix.setScale(-1.0f, 1.0f);
        // 把缩放后的平移效果立即显示出来
        matrix.postTranslate(srcPic.getWidth(), 0);

        // 5.使用画笔在画板上画画;
        // srcPic 参考的原图
        // matrix表示图形使用矩阵对象,里面封装处理图形的api
        // paint画画使用的画笔
        canvas.drawBitmap(srcPic, matrix, paint);

        iv.setImageBitmap(copyPic);
    }

    public void dy(View v) {
        // 1.得到原图;
        // 根据图片的资源ID得到图片对象
        Bitmap srcPic = BitmapFactory.decodeResource(getResources(),
                R.drawable.meinv);
        // 2.参考原图创建一个空白纸张;
        // 根据指定的宽,高,配置信息创建图片对象
        Bitmap copyPic = Bitmap.createBitmap(srcPic.getWidth(),
                srcPic.getHeight(), srcPic.getConfig());
        // 3.参考空白纸张创建一个画板;
        Canvas canvas = new Canvas(copyPic);
        // 4.创建一个画笔;
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        // matrix表示图形使用矩阵对象,里面封装处理图形的api
        Matrix matrix = new Matrix();
        // 镜面
        matrix.setScale(1.0f, -1.0f);
        // 把缩放后的平移效果立即显示出来
        matrix.postTranslate(0,srcPic.getHeight());

        // 5.使用画笔在画板上画画;
        // srcPic 参考的原图
        // matrix表示图形使用矩阵对象,里面封装处理图形的api
        // paint画画使用的画笔
        canvas.drawBitmap(srcPic, matrix, paint);

        iv.setImageBitmap(copyPic);
    }
}
