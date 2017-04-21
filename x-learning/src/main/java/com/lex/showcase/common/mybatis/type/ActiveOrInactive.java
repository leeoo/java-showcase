package com.lex.showcase.common.mybatis.type;

public enum ActiveOrInactive {
	
	ACTIVE("Active"),
	INACTIVE("Inactive");
	private final String value;
	
	ActiveOrInactive(String v) {
		value = v;
	}
	
	public String value() {
		return value;
	}

	public static ActiveOrInactive fromValue(String v) {
		for (ActiveOrInactive c : ActiveOrInactive.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
