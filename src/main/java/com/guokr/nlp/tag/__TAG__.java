package com.guokr.nlp.tag;

import java.lang.reflect.Method;

public enum __TAG__ {

    INSTANCE;

    private Class  clz    = __PKG__.INSTANCE.load("com.guokr.nlp.tag.TagWrapper");
    private Object tagger = __PKG__.INSTANCE.create("com.guokr.nlp.tag.TagWrapper");

    public String tag(String text) {
        String result = null;
        try {
            text = com.guokr.nlp.seg.__SEG__.INSTANCE.segment(text);
            Class[] argTypes = new Class[] { String.class };
            String[] args = new String[]{ text };
            Method mtd = this.clz.getDeclaredMethod("tag", argTypes);
            result = mtd.invoke(this.tagger, args).toString();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return result;
    }

}

