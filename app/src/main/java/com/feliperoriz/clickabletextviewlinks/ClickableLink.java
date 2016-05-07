package com.feliperoriz.clickabletextviewlinks;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;

/**
 * Model for creating a {@link ClickableSpan} with a given String and optional color.
 * Default Link Color is {@link Color#BLACK}
 * Created by Felipe Roriz on 5/7/16.
 */
public class ClickableLink {

    private String mLink;
    private ClickableSpan mClickableSpan;
    private ForegroundColorSpan mForegroundColorSpan;

    /**
     * Constructor for this {@link ClickableLink} with a link color of Black.
     * @param link String to wrap in a {@link ClickableSpan}.
     * @param clickableSpan {@link ClickableSpan} to define click logic.
     */
    public ClickableLink(@NonNull String link, @NonNull ClickableSpan clickableSpan) {
        this(link, clickableSpan, Color.BLACK);
    }

    /**
     * Constructor for this {@link ClickableLink}.
     * @param link String to wrap in a {@link ClickableSpan}.
     * @param clickableSpan {@link ClickableSpan} to define click logic.
     * @param color Link color.
     */
    public ClickableLink(@NonNull String link, @NonNull ClickableSpan clickableSpan, int color) {
        mLink = link;
        mClickableSpan = clickableSpan;
        mForegroundColorSpan = new ForegroundColorSpan(color);
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String mLink) {
        this.mLink = mLink;
    }

    public ClickableSpan getClickableSpan() {
        return mClickableSpan;
    }

    public void setClickableSpan(ClickableSpan mClickableSpan) {
        this.mClickableSpan = mClickableSpan;
    }

    public ForegroundColorSpan getForegroundColorSpan() {
        return mForegroundColorSpan;
    }

    public void setForegroundColorSpan(ForegroundColorSpan mForegroundColorSpan) {
        this.mForegroundColorSpan = mForegroundColorSpan;
    }

    @Override
    public String toString() {
        return "ClickableLink{" +
                "mLink='" + mLink + '\'' +
                ", mClickableSpan=" + mClickableSpan +
                ", mForegroundColorSpan=" + mForegroundColorSpan +
                '}';
    }
}
