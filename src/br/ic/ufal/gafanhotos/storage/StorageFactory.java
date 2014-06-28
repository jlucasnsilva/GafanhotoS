package br.ic.ufal.gafanhotos.storage;

import java.util.Map;

/**
 * Fábrica de diferetes modelos de armazenamento e suas configurações.
 * 
 * @author João Lucas Nunes e Silva
 */
public final class StorageFactory {

	private StorageFactory() { }

	/**
	 * Cria uma nova estrutura de armazenamento para acesso <i>thread local</i>
	 * e <i>thread safe</i>.
	 * Veja {@link BasicStore}.
	 * 
	 * @return uma nova estrutura de armazenamento para acesso <i>thread local</i>
	 * e <i>thread safe</i>.
	 */
	public static IKVStorage newNonConcurrentStorage() {
		return new BasicStore();
	} // end of the method

	/**
	 * Cria uma nova estrutura de armazenamento para acesso <i>thread local</i>
	 * e <i>thread safe</i>. Todo o conteúdo de {@code m} será copiado para a
	 * nova estrutura de armazenamento.
	 * Veja {@link BasicStore}.
	 * 
	 * @return uma nova estrutura de armazenamento para acesso <i>thread local</i>
	 * e <i>thread safe</i>.
	 */
	public static IKVStorage newNonConcurrentStorage(Map<String, String> m) {
		return new BasicStore( m );
	} // end of the method

} // end of the class
