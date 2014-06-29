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

public class ConnectionListenner implements Runnable {

	/**
	 * Connection.
	 */
	private Socket conn;

	public ConnectionListenner(Socket socket) {
		conn = socket;
	} // end of the constructor

	@Override
	public void run() {
		BufferedReader reader;
		PrintWriter    writer;
		Request request;
		String  msg;
		Parser  p = new Parser();
		boolean quit = false;

		try {
			reader = new BufferedReader( new InputStreamReader(conn.getInputStream()) );
			writer = new PrintWriter( conn.getOutputStream() );

			while( !quit ) {
				try { // # # # # # # # # # # # # # # # # # # #
					msg = reader.readLine();
					request = p.parse( msg );
					
					if( request.method != EMethod.QUIT ) {
						
					} else {
						quit = true;
					}
				} catch (BadRequestException e) { // # # # # #
					writer.println( e.getMessage() );
				} // end of the try-catch
			} // end of the while

			writer.close();
			reader.close();
			conn.close();
		} catch (IOException e) {
			// TODO e.printStackTrace();
		} // end of the try-catch
	} // end of method

} // end of the class
