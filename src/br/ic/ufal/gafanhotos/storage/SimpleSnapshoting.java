package br.ic.ufal.gafanhotos.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;

/**
 * Faz um simples <i>snapshoting</i> em disco do armazenamento.
 * Esse <i>snapshoting</i> é feito num arquivo de texto básica.
 */
public class SimpleSnapshoting implements Runnable {

	private final int MINUTE_TO_MILLI = 60000;

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
	private Writer out;

	/**
	 * Cria um novo {@code SimpleSnapshoting} que salva {@code store}
	 * no arquivo {@code file}.
	 * 
	 * @param file - arquivo de <i>output</i>.
	 * @param store - banco de dados a ser salvo.
	 * @throws FileNotFoundException - caso o arquivo de saída não possa ser aberto.
	 */
	public SimpleSnapshoting(int sleepM, String file, IStorage store) throws FileNotFoundException {
		this(sleepM, new File((new Date()) + " - " + file), store);
	} // end of the constructor

	/**
	 * Cria um novo {@code SimpleSnapshoting} que salva {@code store}
	 * no arquivo {@code file}.
	 * 
	 * @param file - arquivo de <i>output</i>.
	 * @param store - banco de dados a ser salvo.
	 * @throws FileNotFoundException - caso o arquivo de saída não possa ser aberto.
	 */
	private SimpleSnapshoting(int sleepM, File file, IStorage store) throws FileNotFoundException {
		this(sleepM, new PrintWriter(file), store);
	} // end of the constructor

	/**
	 * Cria um novo {@code SimpleSnapshoting} que salva {@code store}
	 * no arquivo {@code file}.
	 * 
	 * @param out - "escritor" de arquivo.
	 * @param store - banco de dados a ser salvo.
	 */
	private SimpleSnapshoting(int sleepM, Writer out, IStorage store) {
		this.sleepM = sleepM;
		this.out = out;
		this.store = store;
	} // end of the constructor

	@Override
	public void run() {
		try {
			Thread.sleep( sleepM * MINUTE_TO_MILLI );
			// TODO
			
			for(String key : store.keySet()) {
				
			} // end of the method
		} catch (InterruptedException e) {
			System.err.println("interrut expection");
		}
	} // end of the method

} // end of the class
