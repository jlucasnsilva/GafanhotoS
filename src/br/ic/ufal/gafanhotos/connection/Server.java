package br.ic.ufal.gafanhotos.connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import br.ic.ufal.gafanhotos.Configuration;

public class Server {

	private boolean stop = false;

	private int port;

	public Server(Configuration conf) {
		port = Integer.parseInt( conf.get("server.port") );
	} // end of the constructor

	public void start() throws IOException {
		ServerSocket   server = new ServerSocket( port );
		Socket         socket = null;
		
		while( !stop ) {
			socket = server.accept();
			
			
		} // end of while
		
		server.close();
	} // end of the method

	public void stop() {
		stop = true;
	} // end of the method

} // end of the class
