package br.ic.ufal.gafanhotos.storage;

import java.util.Set;

public interface IStorage {

	/**
	 * <b>C</b> e <b>U</b> de <i>CRUD</i>: cria uma nova entrada na tabela.
	 * A ação de {@code update} caiu nesse método também.
	 */
	void set(String key, String data);

	/**
	 * Retorna o conteúdo da chave {@code key}.
	 * Veja o método {@code get} de {@link java.util.HashMap}.
	 * 
	 * @return Retorna o conteúdo da chave {@code key}.
	 */
	String get(String key);

	/**
	 * Delete o conteúdo da chave {@code key}.
	 * Veja o método {@code remove} de {@link java.util.HashMap}.
	 */
	void delete(String key);

	/**
	 * Retorna um conjunto contendo todas as chaves.
	 */
	Set<String> keySet();

	/**
	 * Concatena a String em <i>key</i> com {@code value}.
	 * 
	 * 
	 * 
	 * @param key chave na tabela.
	 * @param value <i>string</i> a ser concatenada com a de <i>key</i>.
	 */
	default void concat(String key, String value) {
		String s = get( key ) + value;
		
		set(key, s);
	} // end of the method

	/**
	 * Concatena a String {@code value} com a em <i>key</i>.
	 * 
	 * @param key chave na tabela.
	 * @param value <i>string</i> a ser concatenada com a de <i>key</i>.
	 */
	default void prepend(String key, String value) {
		String s = value + get( key );
		
		set(key, s);
	} // end of the method

	/**
	 * Copia o valor em <i>key1</i> em <i>key2</i>.
	 * 
	 * @param key1 chave na tabela.
	 * @param key2 nova chave na tabela.
	 */
	default void copy(String key1, String key2) {
		set(key2, get( key1 ));
	} // end of the method

	/**
	 * Retorna o tamanho da {@code String} em <i>key</i>
	 * @param key - uma chave da tabela.
	 * @return - o tamanho da {@code String} em <i>key</i>
	 */
	default int length(String key) {
		return get(key).length();
	} // end of the method

} // end of the interface
