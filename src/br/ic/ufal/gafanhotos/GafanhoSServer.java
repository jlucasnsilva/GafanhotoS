package br.ic.ufal.gafanhotos;

import br.ic.ufal.gafanhotos.connection.ConnectionsHandler;
import br.ic.ufal.gafanhotos.connection.Server;
import br.ic.ufal.gafanhotos.storage.IStorage;

/**
 * O servidor de armazenamentos de dados.
 */
public class GafanhoSServer {

	private Configuration conf;

	/**
	 * Cria um novo {@code GafanhoSServer}.
	 * 
	 * @param conf 0 configurações do servidor.
	 */
	public GafanhoSServer(Configuration conf) {
		this.conf = conf;
	} // end of the class

	/**
	 * Inicia e executa o servidor.
	 */
	public void start() {
		IStorage storage;
		Server   glovinhaServer;
		ConnectionsHandler csHandler;
		
		
	} // end of the method

} // end of the class
