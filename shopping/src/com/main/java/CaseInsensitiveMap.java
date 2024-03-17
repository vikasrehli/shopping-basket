package com.main.java;

import java.util.Map;
import java.util.TreeMap;

public class CaseInsensitiveMap {
	private final Map<String, Integer> map;

	public CaseInsensitiveMap() {
		this.map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	}

	public void put(String key, Integer value) {
		map.put(key, value);
	}

	public Integer get(String key) {
		return map.get(key);
	}

	public boolean containsKey(String key) {
		return map.containsKey(key);
	}
}