package br.ic.ufal.gafanhotos.client;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Repl repl = new Repl();
		
		System.out.println("GafanhotoS\nStartint the REPL\n...this is client application for testing");
		
		repl.start();
	} // end of the method

} // end of class
