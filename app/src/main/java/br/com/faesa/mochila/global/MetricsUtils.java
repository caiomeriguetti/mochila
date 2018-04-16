package br.com.faesa.mochila.global;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by wiliam on 4/16/18.
 */

public final class MetricsUtils {
    private MetricsUtils(){}

    public static int pxToDp(Context context, int px) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, context.getResources().getDisplayMetrics());
    }
}
