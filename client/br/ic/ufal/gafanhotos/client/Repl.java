package br.ic.ufal.gafanhotos.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import br.ic.ufal.gafanhotos.Configuration;

public class Repl {

	private Configuration conf;

	public Repl() throws IOException {
		conf = new Configuration();
	} // end of the constructor

	public void start() throws UnknownHostException, IOException {
		int     port   = Integer.parseInt( conf.get("server.port") );
		boolean quit   = false;
		Scanner scan   = new Scanner( System.in );
		Socket  socket = new Socket("localhost", port);
		String  input;
		
		PrintWriter    out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in  = new BufferedReader( new InputStreamReader(socket.getInputStream()) );

		while( !quit ) {
			System.out.print(">> ");
			input = scan.nextLine();
			
			if( input.equals("quit") ) {
				quit = true;
			} else {
				out.println( input );
				System.out.println("<< " + in.readLine());
			}
		} // end of while
		
		in.close();
		out.close();
		scan.close();
		socket.close();
	} // end of the method

} // end of the class
