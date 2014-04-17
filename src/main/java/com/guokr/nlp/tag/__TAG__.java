package com.guokr.nlp.tag;

import com.guokr.nlp.seg.__SEG__;

public enum __TAG__ {

	INSTANCE;

	private TagWrapper tagger = new TagWrapper();

	public String tag(String text) {
		String result = null;
		try {
			text = __SEG__.INSTANCE.segment(text);
			result = tagger.tag(text);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return result;
	}

}
