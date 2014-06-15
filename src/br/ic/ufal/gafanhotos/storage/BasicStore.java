package br.ic.ufal.gafanhotos.storage;

import java.util.HashMap;
import java.util.Map;

/**
 * Simples implementação {@code IKVStorage}. {@code BasicStore} é um
 * <i>façade</i> para {@link HashMap}.
 * @author João Lucas Nunes e Silva
 */
class BasicStore implements IKVStorage {

	private HashMap<String, byte[]> map;

	BasicStore() {
		map = new HashMap<>();
	} // end of the constructor

	BasicStore(Map<String, byte[]> m) {
		map = new HashMap<>( m );
	} // end of the constructor

	BasicStore(int initialCapacity) {
		map = new HashMap<>(initialCapacity);
	} // end of the constructor

	@Override
	public void put(String key, byte[] data) {
		map.put(key, data);
	} // end of the method

	@Override
	public byte[] get(String key) {
		return map.get( key );
	} // end of the method

	@Override
	public void delete(String key) {
		map.remove( key );
	} // end of the method

} // end of the class
