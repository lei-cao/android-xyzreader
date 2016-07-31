package com.example.xyzreader.ui;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.android.volley.toolbox.NetworkImageView;

public class AspectRatioImageView extends NetworkImageView {

    public AspectRatioImageView(Context context) {
        super(context);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(getBackground() == null || getBackground().getIntrinsicHeight()==0 || getBackground().getIntrinsicWidth()==0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width * getBackground().getIntrinsicHeight() / getBackground().getIntrinsicWidth();
        setMeasuredDimension(width, height);
    }
}