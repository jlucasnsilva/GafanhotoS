package br.ic.ufal.gafanhotos.storage;

import java.util.Map;

public final class StorageFactory {

	private StorageFactory() { }

	public static IKVStorage newNonConcurrentStorage() {
		return null;
	} // end of the method

	public static IKVStorage newNonConcurrentStorage(Map<String, byte[]> m) {
		return null;
	} // end of the method

} // end of the class
