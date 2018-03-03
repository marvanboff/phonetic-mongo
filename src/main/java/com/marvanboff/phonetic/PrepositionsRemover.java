package com.marvanboff.phonetic;

import org.apache.commons.lang3.StringUtils;

public class PrepositionsRemover {

	private static final String REGEX_PT_BR_PREPOSITIONS_NAME = " (?i)de | (?i)dos | (?i)das | (?i)da | (?i)D[Áá] | (?i)e ";
	
	public static String remove(String value) {
		return StringUtils.replaceAll(value, REGEX_PT_BR_PREPOSITIONS_NAME, " ");
	}
	
}
