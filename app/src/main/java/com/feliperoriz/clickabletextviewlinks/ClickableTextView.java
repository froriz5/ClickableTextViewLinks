package com.feliperoriz.clickabletextviewlinks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * TextView that creates Spannable Click Listener on Substrings.
 * Only works for first unique substring match.
 * i.e. Hello Hello World; Only first Hello will be clickable.
 * Created by Felipe Roriz on 5/7/16.
 */
public class ClickableTextView extends TextView {

    private SpannableString mSpannableString;

    public ClickableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mSpannableString = new SpannableString(this.getText());
        this.setMovementMethod(LinkMovementMethod.getInstance());
        this.setText(mSpannableString);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        mSpannableString = SpannableString.valueOf(text.toString());
    }

    /**
     * Create clickable links with a list of {@link ClickableLink}
     * @param links List of {@link ClickableLink} to create links for.
     */
    public void addLinks(ClickableLink ... links) {
        for (ClickableLink link : links) {
            createLink(link);
        }
        this.setText(mSpannableString);
    }

    /**
     * Creates individual link with an optional link color.
     * @param link {@link ClickableLink} to create link.
     */
    public void createLink(@NonNull ClickableLink link) {
        String template = this.getText().toString();

        // Substring not contained in TextView text.
        if (!template.contains(link.getLink())) {
            return;
        }
        int startIndex = template.indexOf(link.getLink());
        int endIndex = startIndex + link.getLink().length();
        mSpannableString.setSpan(link.getClickableSpan(), startIndex, endIndex, 0);
        mSpannableString.setSpan(link.getForegroundColorSpan(), startIndex, endIndex, 0);
    }
}
