package com.marvanboff.phonetic;

public class PhoneticNormalizer {
	
	private String normalized;
	
	public PhoneticNormalizer(String normalize) {
		super();
		this.normalized = normalize;
	}

	public String normalize() {
		
		normalized = upperCase();
		normalized = replacePortugueseCaracters();
		normalized = replaceHRXSounds();
		normalized = replaceTHSounds();
		normalized = trim();
		
		return normalized;
	}
	
	/**
     *
     *    'LH' to '1'
     *    'RR' to '2'
     *    'NH' to '3'
     *    'Ç'  to 'SS'
     *    'CH' to 'X'
     **/
	private String replacePortugueseCaracters() {
		
		String replacedValue = normalized;
		
		replacedValue = replacedValue.replaceAll("[1|2|3|4|5|6|7|8|9|0]","");
	    replacedValue = replacedValue.replaceAll("[Ã|Á|Â]","A");
	    replacedValue = replacedValue.replaceAll("[É|Ê]","E");
	    replacedValue = replacedValue.replaceAll("[Í|Y]","I");
	    replacedValue = replacedValue.replaceAll("[Õ|Ó|Ô]","O");
	    replacedValue = replacedValue.replaceAll("[Ú|Ü]","U");
	    replacedValue = replacedValue.replaceAll("Ç","SS");
		
		return replacedValue;
	}
	
	/**
     *    replace
     *    -> "olho", "ninho", "carro", "exceção", "carroça"
     */
	private String replaceHRXSounds() {
		
		String replacedValue = normalized;
		
	    replacedValue = replacedValue.replaceAll("LH","1");
	    replacedValue = replacedValue.replaceAll("NH","3");
	    replacedValue = replacedValue.replaceAll("RR","2");
	    replacedValue = replacedValue.replaceAll("XC","SS");
	    
	    return replacedValue;
	}
	
	/**
     *    replace
     *    -> "schiffer", "theodora", "ophelia", etc..
     */
	private String replaceTHSounds() {
		
		String replacedValue = normalized;
		
		replacedValue = replacedValue.replaceAll("TH","T");
		replacedValue = replacedValue.replaceAll("PH","F");
	    
	    return replacedValue;
	}
	
	private String upperCase() {
	    return normalized.toUpperCase();
	}
	
	private String trim() {
		return normalized.trim();
	}
	
}
