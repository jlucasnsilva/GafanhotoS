package br.ic.ufal.gafanhotos.connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.ic.ufal.gafanhotos.Configuration;
import br.ic.ufal.gafanhotos.storage.IStorage;

public final class ThreadedServer {

	private boolean stop = false;

	private Configuration conf;
	private IStorage storage;
	
	public ThreadedServer(Configuration conf, IStorage storage) {
		this.storage = storage;
		this.conf    = conf;
	} // end of the constructor

	public void start() throws IOException {
		int port = Integer.parseInt( conf.get("server.port") );
		
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Socket          socket = null;
		ServerSocket    server;
		
		if( conf.get("server.backlog") != null ) {
			server = new ServerSocket(port, Integer.parseInt(conf.get("server.backlog")));
		} else {
			server = new ServerSocket( port );
		}
		
		while( !stop ) {
			socket = server.accept();
			
			threadPool.execute( new ConnectionHandler(socket, storage) );
		} // end of while
		
		threadPool.shutdown();
		server.close();
	} // end of the method

	public void stop() {
		stop = true;
	} // end of the method

	public boolean isRunning() {
		return !stop;
	} // end of the method

} // end of the class
