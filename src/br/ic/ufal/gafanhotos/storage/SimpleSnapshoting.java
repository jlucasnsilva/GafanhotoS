package br.ic.ufal.gafanhotos.storage;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Faz um simples <i>snapshoting</i> em disco do armazenamento.
 * Esse <i>snapshoting</i> é feito num arquivo de texto básica.
 */
public class SimpleSnapshoting implements Runnable {

	private final int MINUTE_TO_MILLI = 60000;

	private boolean stop = false;
	
	/**
	 * Tempo entre cada <i>snapshot</i> em minutos;
	 */
	private int sleepM;
	/**
	 * Banco de dados a ser salvo em disco.
	 */
	private IStorage store;
	/**
	 * Stream para escrita do banco de dados.
	 */
	private String file;

	/**
	 * Cria um novo {@code SimpleSnapshoting} que salva {@code store}
	 * no arquivo {@code file}.
	 * 
	 * @param file - arquivo de <i>output</i>.
	 * @param store - banco de dados a ser salvo.
	 * @throws FileNotFoundException - caso o arquivo de saída não possa ser aberto.
	 */
	public SimpleSnapshoting(int sleepM, String path, IStorage store) throws FileNotFoundException {
		this.sleepM = sleepM;
		this.store  = store;
		this.file   = path;
	} // end of the constructor

	@Override
	public void run() {
		try {
			while( !stop ) {
				Thread.sleep( sleepM * MINUTE_TO_MILLI );
				File file = new File( this.file + " AT " + new Date() );
				PrintWriter out = new PrintWriter(file);
				
				for(String key : store.keySet()) {
					out.println(key + " :: " + store.get(key));
				} // end of the method
				
				out.close();
			} // end of the method
			
		} catch (InterruptedException e) {
			System.err.println("interrut expection");
		} catch (FileNotFoundException e) {
			System.err.println("Fail to take snapshot (" + new Date() + ")");
		}
	} // end of the method

	public void stopNow() {
		stop = true;
	} // end of the method

} // end of the class
