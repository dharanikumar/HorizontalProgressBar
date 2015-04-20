package com.incredibleandros.rippleprogress.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;



public class ProgressLayout extends View {
	private SwipeProgressBar mProgressBar; //the thing that shows progress is going
	private static final float PROGRESS_BAR_HEIGHT = 4;
	private int mProgressBarHeight;
	private boolean mRefreshing = false;
	
	
	 private static final int[] LAYOUT_ATTRS = new int[] {
	        android.R.attr.enabled
	    };
	 
	public ProgressLayout(Context context) {
        this(context, null);
    }

    /**
     * Constructor that is called when inflating SwipeRefreshLayout from XML.
     * @param context
     * @param attrs
     */
    public ProgressLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        //mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

       // mMediumAnimationDuration = getResources().getInteger(
       //         android.R.integer.config_mediumAnimTime);

        setWillNotDraw(false);
        mProgressBar = new SwipeProgressBar(this);
        final DisplayMetrics metrics = getResources().getDisplayMetrics();
        mProgressBarHeight = (int) (metrics.density * PROGRESS_BAR_HEIGHT);
       

        final TypedArray a = context.obtainStyledAttributes(attrs, LAYOUT_ATTRS);
        setEnabled(a.getBoolean(0, true));
        a.recycle();
    }
    
    public void setColorScheme(int colorRes1, int colorRes2, int colorRes3, int colorRes4) {
        final Resources res = getResources();
        final int color1 = res.getColor(colorRes1);
        final int color2 = res.getColor(colorRes2);
        final int color3 = res.getColor(colorRes3);
        final int color4 = res.getColor(colorRes4);
        mProgressBar.setColorScheme(color1, color2, color3,color4);
    }
    
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        mProgressBar.draw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int width =  getWidth();
        final int height = getMeasuredHeight();
        double indicatorHeightPercent = 0.05; // 5%
        
        mProgressBar.setBounds(0, 0,  width, mProgressBarHeight);
        // normal  mProgressBar.setBounds(0, getChildAt(0).getTop(), width, mProgressBarHeight);
        // Full screen circular  mProgressBar.setBounds(0, 3, width, height);
        
    }
    
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       
    }

    
    public boolean isRefreshing() {
        return mRefreshing;
    }
    
    public void setRefreshing(boolean refreshing) {
        if (mRefreshing != refreshing) {
            mRefreshing = refreshing;
            if (mRefreshing) {
                mProgressBar.start();
                Log.e("Progress","Start"+mRefreshing);
            } else {
                mProgressBar.stop();
                Log.e("Progress","Stop"+mRefreshing);
            }
        }
    }

	
}
