package com.test.mvvm.utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/*
Created By WANIRO-CONT On 12/13/2018  
*/
public class Space extends RecyclerView.ItemDecoration {
    private int mItemOffset;

    public Space(int itemOffset) {
        mItemOffset = itemOffset;
    }

    public Space(@NonNull Context context, @DimenRes int itemOffsetId) {
        this(context.getResources().getDimensionPixelSize(itemOffsetId));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildLayoutPosition(view) == 0)
            outRect.top = mItemOffset;
        outRect.left = mItemOffset;
        outRect.right = mItemOffset;
        outRect.bottom = mItemOffset;
    }
}
