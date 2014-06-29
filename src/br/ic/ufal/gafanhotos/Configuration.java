package br.ic.ufal.gafanhotos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * A classe {@code Configuration} é um mapa para os parâmetros de configuração
 * do servidor.
 * <br /><br />
 * Parâmetros suportados no momento
 * <pre>
 * 1) server.port = [number]
 * 2) server.log  = [true | false]
 * 3) server.snapshot = [true | false]
 * 4) server.snapshot.ml = [number]
 * </pre>
 */
public class Configuration {

	private HashMap<String, String> conf;

	private BufferedReader reader;

	/**
	 * Cria uma nova configuração padrão (arquivo rsc/default.conf)
	 * @throws IOException caso ocorra um erro de I/O.
	 */
	public Configuration() throws IOException {
		this("rsc/default.conf");
	} // end of the constructor

	/**
	 * Cria uma nova configuração segundo os parâmetros contidos
	 * no arquivo {@code file}.
	 * 
	 * @param file arquivo a ser lido
	 * @throws IOException caso ocorra um erro de I/O.
	 */
	public Configuration(String file) throws IOException {
		this( new File(file) );
	} // end of the constructor

	/**
	 * Cria uma nova configuração segundo os parâmetros contidos
	 * no arquivo {@code file}.
	 * 
	 * @param file arquivo a ser lido
	 * @throws IOException caso ocorra um erro de I/O.
	 */
	public Configuration(File file) throws IOException {
		reader = new BufferedReader( new FileReader(file) );
		conf   = new HashMap<String, String>();
		loadConfig();
	} // end of the constructor

	private void loadConfig() throws IOException {
		String line;
		String args[];
		final int KEY   = 0;
		final int VALUE = 1;
		
		while( (line = reader.readLine()) != null ) {
			// # é utilizado para indicar comentário
			if( !line.startsWith("#") ) {
				args = line.split(" = ");
				conf.put(args[KEY].trim(), args[VALUE].trim());
			}
		}
	} // end of the method

	/**
	 * Retorna um valor de parametrização do servidor
	 * @param key chave do valor.
	 * @return um valor de parametrização do servidor
	 */
	public String get(String key) {
		return conf.get( key );
	} // end of the method

} // end of the class
