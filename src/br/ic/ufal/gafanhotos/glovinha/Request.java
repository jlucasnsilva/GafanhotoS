package br.ic.ufal.gafanhotos.glovinha;

/**
 * A classe {@code Request} encapsula uma requisição do cliente.
 */
public class Request {

	/**
	 * Método a ser executado. Veja: {@link EMethod}.
	 */
	public final EMethod method;
	/**
	 * Chave da tabela.
	 */
	public final String  key;
	/**
	 * Valor associado à chave.
	 */
	public final String  data;

	/**
	 * Cria uma nova requisição.
	 * 
	 * @param method - Método a ser executado. Veja: {@link EMethod}.
	 * @param key - Chave da tabela.
	 * @param data - Valor associado à chave.
	 */
	public Request(EMethod method, String key, String data) {
		this.method = method;
		this.key    = key;
		this.data   = data;
	} // end of the constructor

	@Override
	public String toString() {
		return method + "(KEY:" + key + (data != null ? ", DATA:" + data + ")" : ")");
	} // end of the method

} // end of the class
