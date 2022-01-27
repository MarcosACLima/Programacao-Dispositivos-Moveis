package com.example.desenhando;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MinhaView extends View {
    Paint caneta;
    Paint contorno;

    public MinhaView(Context context) {
        super(context);
        init();
    }

    private void init() {
        caneta = new Paint(Paint.ANTI_ALIAS_FLAG);
        caneta.setColor(Color.BLUE);
        caneta.setStyle(Paint.Style.FILL);
        caneta.setTextSize(70);

        contorno = new Paint(Paint.ANTI_ALIAS_FLAG);
        contorno.setColor(Color.BLACK);
        contorno.setStyle(Paint.Style.STROKE);
        contorno.setTextSize(70);
        contorno.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("Meu primeiro texto",20,80, caneta);

        canvas.drawCircle(100, 150, 50, caneta);
        canvas.drawCircle(100, 150, 50, contorno);

        canvas.drawRect(100, 250, 400, 400, caneta);
        canvas.drawRect(100, 250, 400, 400, contorno);

        canvas.drawLine(100, 450, 400, 600, contorno);
    }
}
