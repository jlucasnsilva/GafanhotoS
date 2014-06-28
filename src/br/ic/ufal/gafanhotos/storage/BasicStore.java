package br.ic.ufal.gafanhotos.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Simples implementação {@code IKVStorage}. {@code BasicStore} é um
 * <i>façade</i> para {@link HashMap}.
 * @author João Lucas Nunes e Silva
 */
class BasicStore implements IKVStorage {

	private HashMap<String, String> map;

	/**
	 * Cria um novo {@code BasicStore} vazio.
	 */
	BasicStore() {
		map = new HashMap<>();
	} // end of the constructor

	/**
	 * Cria um novo {@code BasicStore} com todo o conteúdo de
	 * {@code m}.
	 */
	BasicStore(Map<String, String> m) {
		map = new HashMap<>( m );
	} // end of the constructor

	/**
	 * Cria um novo {@code BasicStore} vazio com capacidade inicial
	 * igual à {@code initialCapacity}
	 * @param initialCapacity - a capacidade inicial do novo {@code BasicStore}.
	 */
	BasicStore(int initialCapacity) {
		map = new HashMap<>( initialCapacity );
	} // end of the constructor

	/**
	 * <b>C</b> e <b>U</b> de <i>CRUD</i>: cria uma nova entrada na tabela.
	 * A ação de {@code update} caiu nesse método também.
	 */
	@Override
	public void put(String key, String data) {
		map.put(key, data);
	} // end of the method
	
	/**
	 * Retorna o conteúdo da chave {@code key}.
	 * Veja o método {@code get} de {@link java.util.HashMap}.
	 * 
	 * @return Retorna o conteúdo da chave {@code key}.
	 */
	@Override
	public String get(String key) {
		return map.get( key );
	} // end of the method

	/**
	 * Delete o conteúdo da chave {@code key}.
	 * Veja o método {@code remove} de {@link java.util.HashMap}.
	 */
	@Override
	public void delete(String key) {
		map.remove( key );
	} // end of the method

	/**
	 * Retorna um conjunto contendo todas as chaves.
	 * @return um conjunto contendo todas as chaves.
	 */
	@Override
	public Set<String> keySet() {
		return map.keySet();
	} // end of the method

} // end of the class
