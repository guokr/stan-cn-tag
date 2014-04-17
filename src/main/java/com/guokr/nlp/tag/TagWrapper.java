package com.guokr.nlp.tag;

import com.guokr.protocol.Protocols;
import com.guokr.util.Settings;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class TagWrapper {

	static Protocols protocols = Protocols.INSTANCE;
	static Settings defaults = Settings.load("xcf:///tag/defaults.using.prop");

	private MaxentTagger tagger;

	public TagWrapper() {
		this(null);
	}

	public TagWrapper(Settings settings) {
		Settings props = new Settings(settings, defaults);
		String model = props.getProperty("model");
		try {
			tagger = new MaxentTagger(model);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	public String tag(String text) {
		return tagger.tagString(text).trim();
	}

}
