package br.ic.ufal.gafanhotos;

import java.io.IOException;

import br.ic.ufal.gafanhotos.connection.ThreadedServer;
import br.ic.ufal.gafanhotos.storage.BasicStore;
import br.ic.ufal.gafanhotos.storage.IStorage;
import br.ic.ufal.gafanhotos.storage.SnapshotingStorage;

public class MainGafanhotoS {

	public static void main(String[] args) throws IOException {
		Configuration conf;
		IStorage      storage;
		
		// Carrega configurações do servidor.
		if( args.length > 0 ) {
			// TODO parse command line input
			conf = new Configuration( args[0] );
		} else {
			conf = new Configuration();
		}
		
		System.out.println( "[      GAFANHOTOS      ]" );
		System.out.println( conf );
		System.out.println( "[     starting now     ]" );
		
		storage = new BasicStore();
		
		if( conf.get("storage.snapshot") != null
				&& conf.get("storage.snapshot.pathfile") != null
				&& conf.get("storage.snapshot").equals("true") ) {
			storage = new SnapshotingStorage(storage, conf.get("storage.snapshot.pathfile"));
		}
		
		ThreadedServer server = new ThreadedServer(conf, storage);
		
		server.start();
	} // end of the method

} // end of the class
