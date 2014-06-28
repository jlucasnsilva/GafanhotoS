package br.ic.ufal.gafanhotos.connection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Configuration {

	private HashMap<String, String> conf;

	private BufferedReader reader;

	public Configuration(String file) throws IOException {
		this( new File(file) );
	} // end of the constructor

	public Configuration(File file) throws IOException {
		reader = new BufferedReader( new FileReader(file) );
		conf   = new HashMap<String, String>();
		loadConfig();
	} // end of the constructor

	private void loadConfig() throws IOException {
		String line;
		String args[] = new String[2];
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

	public String get(String key) {
		return conf.get( key );
	} // end of the method

} // end of the class
