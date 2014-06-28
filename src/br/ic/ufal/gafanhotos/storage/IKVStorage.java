package br.ic.ufal.gafanhotos.storage;

import java.util.Set;

public interface IKVStorage {

	/**
	 * <b>C</b> e <b>U</b> de <i>CRUD</i>: cria uma nova entrada na tabela.
	 * A ação de {@code update} caiu nesse método também.
	 */
	void put(String key, String data);

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
	void   delete(String key);

	/**
	 * Retorna um conjunto contendo todas as chaves.
	 */
	public Set<String> keySet();

} // end of the interface
