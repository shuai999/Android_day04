package cn.novate.android_day04.simple4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import cn.novate.android_day04.R;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/7/3 16:40
 * Version 1.0
 * Params:
 * Description:    撕衣服
 *                 原理：在界面上放两张图片，没有穿衣服的放在下边，穿衣服的放在上边，手在滑动过程中，把手所到之处的像素点改变成透明色
*/

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_04);

        iv = (ImageView) findViewById(R.id.iv);

        // 1.得到原图;
        // 根据图片的资源ID得到图片对象
        Bitmap srcPic = BitmapFactory.decodeResource(getResources(),
                R.drawable.pre0);
        // 2.参考原图创建一个空白纸张;
        // 根据指定的宽,高,配置信息创建图片对象
        final Bitmap copyPic = Bitmap.createBitmap(srcPic.getWidth(),
                srcPic.getHeight(), srcPic.getConfig());
        // 3.参考空白纸张创建一个画板;
        Canvas canvas = new Canvas(copyPic);
        // 4.创建一个画笔;
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        // 5.使用画笔在画板上画画;
        // srcPic 参考的原图
        // matrix表示图形使用矩阵对象,里面封装处理图形的api
        // paint画画使用的画笔
        canvas.drawBitmap(srcPic, new Matrix(), paint);

        iv.setImageBitmap(copyPic);

        // 给imageView添加触摸的监听器
        iv.setOnTouchListener(new View.OnTouchListener() {
            /**
             * 触摸到imageView上 后调用这个方法 触发的动作:按下,移动,抬起 v 当前触摸的对象,imageview event
             * 事件对象,包含与事件相关的所有信息
             */
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                // 得到当前的动作
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN: // 按下

                        break;

                    case MotionEvent.ACTION_MOVE: // 移动
                        // 得到手移动到的像素点
                        int x = (int) event.getX();
                        int y = (int) event.getY();
                        // 把副本上的当前像素点改变成透明色
                        for(int i=-10; i<10; i++){
                            for(int j= -10; j<10; j++){
                                int r = (int) Math.sqrt(i*i+j*j);
                                if(r<10){
                                    copyPic.setPixel(x + i, y+j, Color.TRANSPARENT);
                                }
                            }
                        }
                        // 把修改后的图片显示在imageview上
                        iv.setImageBitmap(copyPic);

                        break;

                    case MotionEvent.ACTION_UP: // 抬起
                        break;
                }

                // 返回true表示当前事件已经结束了
                return true;
            }
        });

    }
}
