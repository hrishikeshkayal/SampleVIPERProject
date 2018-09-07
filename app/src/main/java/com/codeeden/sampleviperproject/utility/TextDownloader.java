package com.codeeden.sampleviperproject.utility;

import android.content.Context;
import android.text.Html;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by imran khan on 01-05-2016.
 */
public class TextDownloader {


    public static void setTxt(Context mContext, String txt, TextView textView) {

        if (textView == null)
            return;

        if (txt == null)
            return;

        if (txt.toString().trim().length() == 0)
            return;

        textView.setText(txt);
    }

    public static void setTxt(Context mContext, String txt, EditText textView) {

        if (textView == null)
            return;

        if (txt == null)
            return;

        if (txt.toString().trim().length() == 0)
            return;

        textView.setText(txt);
    }

    static String starts = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "<title></title>\n" +
            "</head>\n" +
            "<body>";
    static String end = "</body>\n" +
            "</html>";

    public static void setHtmlText(TextView text, String txt) {
        text.setText(Html.fromHtml(starts + txt + end));
    }

    public static String getEdtText(EditText editText) {
        return editText.getText().toString().trim();
    }
}
