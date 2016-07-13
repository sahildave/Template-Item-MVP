package xyz.sahildave.trendy.util;

import android.support.annotation.StringDef;

/**
 * Created by sahil on 25/3/16.
 */
public class BaseConstants {
    @StringDef({TextType.PARAGRAPH, TextType.H1, TextType.H2, TextType.H3, TextType.H4,
            TextType.STRONG, TextType.LIST, TextType.INLINE_IMAGE})
    public @interface TextType {
        public static final String PARAGRAPH = "PARAGRAPH";
        public static final String H1 = "H1";
        public static final String H2 = "H2";
        public static final String H3 = "H3";
        public static final String H4 = "H4";
        public static final String STRONG = "STRONG";
        public static final String LIST = "LIST";
        public static final String INLINE_IMAGE = "INLINE-IMAGE";
    }
}
