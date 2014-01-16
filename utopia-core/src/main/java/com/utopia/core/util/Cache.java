/**
 * 
 */
package com.utopia.core.util;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;


/**
 * @author salarkia
 *
 */
public class Cache<K,V> extends ConcurrentHashMap<K, V>{
	private static Logger logger=Logger.getLogger(Cache.class.getName());
//	private Map<K,V>map;
//
//	/**
//	 * 
//	 */
//	public Cache() {
//		this.map=new ConcurrentHashMap<K, V>();
//	}
//
//	/**
//	 * @param initialCapacity
//	 */
//	public Cache(int initialCapacity) {
//		this.map=new ConcurrentHashMap<K, V>(initialCapacity);
//	}
//
//	/**
//	 * @param m
//	 */
//	public Cache(Map<K,V> m) {
//			this.map=new ConcurrentHashMap<K, V>(m);
//	}
//
//	/**
//	 * @param initialCapacity
//	 * @param loadFactor
//	 */
//	public Cache(int initialCapacity, float loadFactor) {
//		this.map=new ConcurrentHashMap<K, V>(initialCapacity, loadFactor);
//	}
//	
//	public int size() {
//		return map.size();
//	}
//
//	public boolean isEmpty() {
//		return map.isEmpty();
//	}
//
//	
//
//
//
//	public V get(Object key) {
//			return map.get(key);
//	}
//
//	public void put(K key, V value) {
//			map.put(key, value);
//		
//	}
//
//	public V remove(K key) {
//		if(map!=null){
//			 return map.remove(key);
//		}else{
//			V value=null;
//			try {
//				value = localCache.get(key);
//			} catch (Exception e) {
//				logger.log(Level.WARNING,"",e);
//			}
//			localCache.invalidate(key);
//			return value;
//		}
//	}
//
//	public boolean containsKey(K key) {
//		return map.containsKey(key);
//	}
//
//	public Set<K> keySet() {
//		return map.keySet();
//	}
//
//	public Collection<V> values() {
//		return map.values();
//	}
//
//	public void clear(){
//		map.clear();
//	}


}
