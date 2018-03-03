package com.marvanboff.phonetic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.language.Metaphone;
import org.apache.commons.lang3.StringUtils;

public class PhoneticEncoder {

	public static List<String> encode(String value) {
		if(StringUtils.isNotBlank(value)) {
			List<String> listEncode = new ArrayList<>();
			
			String normalized = PrepositionsRemover.remove(value);
			normalized = new PhoneticNormalizer(normalized).normalize();
			for (String piece : StringUtils.split(normalized)) {
				listEncode.add(new Metaphone().encode(piece));
			}
			return listEncode;
		}
		return null;
		
	}
	
}
