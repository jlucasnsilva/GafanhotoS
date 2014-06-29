package br.ic.ufal.gafanhotos;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Configuration  conf;
		
		// Carrega configurações do servidor.
		if( args.length > 1 ) {
			// TODO parse command line input
			conf = new Configuration(); // TODO argumentos
		} else {
			conf = new Configuration();
		}
		
		new GafanhoSServer( conf ).start();
	} // end of the method

} // end of the class
