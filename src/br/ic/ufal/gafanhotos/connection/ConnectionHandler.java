package br.ic.ufal.gafanhotos.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import br.ic.ufal.gafanhotos.exception.BadRequestException;
import br.ic.ufal.gafanhotos.glovinha.EMethod;
import br.ic.ufal.gafanhotos.glovinha.Parser;
import br.ic.ufal.gafanhotos.glovinha.Request;
import br.ic.ufal.gafanhotos.storage.IStorage;

public class ConnectionHandler implements Runnable {

	private IStorage ref;
	private Socket   socket;
	private String   addr;

	public ConnectionHandler(Socket socket, IStorage ref) {
		this.socket = socket;
		this.ref    = ref;
		this.addr   = socket.getInetAddress().toString();
	} // end of the constructor

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader( new InputStreamReader(socket.getInputStream()) );
			PrintWriter    writer = new PrintWriter(socket.getOutputStream(), true);
			Parser         parser = new Parser();
			Request        request = null;
			boolean        quit    = false;
			
			String req = null;
			String res = null;
			
			while( !quit ) {
				try {
					req = reader.readLine();
					request = parser.parse(req);
					
					if( request.method != EMethod.QUIT ) {
						res = process(request);
						
						writer.println( res );
					} else {
						writer.println("Quit: OK.");
						quit = true;
					}
				} catch (BadRequestException e) {
					writer.println( e.getMessage() );
				} // end of the try-catch
			} // end of the while
			
			writer.close();
			reader.close();
			socket.close();
		} catch (IOException e) {
			System.out.println( "Connection with " + addr + " terminated." );
		} // end of the try-catch
	} // end of the method

	private String process(Request request) {
		String response = request.method + " OK.";
		
		if( request.method == EMethod.CONCAT ) {
			ref.concat(request.key, request.data);
		} else if( request.method == EMethod.COPY ) {
			ref.copy(request.key, request.data);
		} else if( request.method == EMethod.DEL ) {
			ref.delete( request.key );
		} else if( request.method == EMethod.GET ) {
			response = ref.get( request.key );
		} else if( request.method == EMethod.LEN ) {
			response = ref.length( request.key ) + "";
		} else if( request.method == EMethod.PREPEND ) {
			ref.prepend(request.key, request.data);
		} else if( request.method == EMethod.SET ) {
			ref.set(request.key, request.data);
		}
		
		// TODO fazer melhor mensagens de resposta
		return response;
	} // end of the method

} // end of the class
