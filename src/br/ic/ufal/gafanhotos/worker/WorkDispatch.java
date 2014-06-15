package br.ic.ufal.gafanhotos.worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkDispatch {

	private final int NUMBER_OF_THREADS = 2;

	private IReaderStrategy reader;
	private IWriterStrategy writer;

	private ExecutorService threadPool;

	public WorkDispatch() {
		threadPool = Executors.newFixedThreadPool( NUMBER_OF_THREADS );
	} // end of the constructor

	public void put(String key, byte[] data) {
		
	} // end of the method

	public byte[] get(String key) {
		return null;
	} // end of the method

	public void delete(String key) {
		
	} // end of the method

} // end of the class
