package com.example.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    Paint paint = new Paint();

    int N = 10; // количество шариков
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];

    public MyView(Context context){
        super(context);
        for (int i = 0; i < N; i++){
            x[i] = (float)(Math.random() * 500);
            y[i] = (float)(Math.random() * 500);
            vx[i] = (float)(Math.random() * 6 - 3);
            vy[i] = (float)(Math.random() * 6 - 3);
        }
    }

    long lastTime = System.currentTimeMillis();

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.YELLOW);
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 20, paint);
        }
        // готовим массивы x и у для следущего кадра
        for (int i = 0; i < N; i++) {
            x[i] += vx[i];
            y[i] += vy[i];
            if (x[i] >= canvas.getWidth())
                x[i] = 0;
            else if (x[i] <=0 )
                x[i] = getWidth();
            if (y[i] >= canvas.getHeight())
                y[i] = 0;
            else if(y[i] <= 0)
                y[i] = getHeight();
        }

        //запрашиваем перерисовку
        invalidate();
    }
}