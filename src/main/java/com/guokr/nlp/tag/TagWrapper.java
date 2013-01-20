package com.guokr.nlp.tag;

import java.util.Properties;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import com.guokr.util.Reflector;

public class TagWrapper {

    private static Class clzSettings = Reflector.classFor("com.guokr.util.Settings");
    private static Object defaults   = Reflector.callStaticly(clzSettings, "load", new Class[]{String.class}, new Object[]{"classpath:tag/defaults.using.prop"});

    private MaxentTagger tagger;

    public TagWrapper(Object settings) {
        Properties props = (Properties) Reflector.newInstance
            (clzSettings, new Class[]{Properties.class, Properties.class},
              new Object[]{settings, defaults});

        String model = props.getProperty("model");
        MaxentTagger mt = null;
        try {
            tagger = new MaxentTagger(model);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace(System.err);
        }
    }

    public TagWrapper() {
        new TagWrapper((Object)null);
    }

    public String tag(String text) {
        return tagger.tagString(text).trim();
    }

}
