package com.utopia.core.util;

public interface CacheLoader<K,V> {

	public V load(K k);
}
