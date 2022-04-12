package com.me.boliplate_mvvm.utility.customfont;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

@SuppressLint("AppCompatCustomView")
public class BoldButton extends AppCompatButton {
    Context context;

    public BoldButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public BoldButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);
    }

    public BoldButton(Context context) {
        super(context);
        this.context = context;
        init(null);
    }

    private void init(AttributeSet attr) {
        if (attr != null) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/antipastobold.ttf");
            setTypeface(tf);
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

}
