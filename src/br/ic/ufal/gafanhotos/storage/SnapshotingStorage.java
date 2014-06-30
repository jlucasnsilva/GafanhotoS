package br.ic.ufal.gafanhotos.storage;

import java.io.FileNotFoundException;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SnapshotingStorage extends ATemplateStorage {

	private ExecutorService thread;

	public SnapshotingStorage(IStorage storage, String path) throws FileNotFoundException {
		super( storage );
		thread = Executors.newFixedThreadPool( 1 );
		thread.execute( new SimpleSnapshoting(5, path, storage) );
	} // end of the constructor

	@Override
	protected void hookConcat(String key, String data, IStorage realStorage) {
		realStorage.concat(key, data);
	} // end of the method

	@Override
	protected void hookCopy(String key1, String key2, IStorage realStorage) {
		realStorage.copy(key1, key2);
	} // end of the method

	@Override
	protected void hookDelete(String key, IStorage realStorage) {
		realStorage.delete(key);
	} // end of the method
	
	@Override
	protected String hookGet(String key, IStorage realStorage) {
		return realStorage.get(key);
	} // end of the method

	@Override
	protected int hookLength(String key, IStorage realStorage) {
		return realStorage.length(key);
	} // end of the method

	@Override
	protected void hookPrepend(String key, String data, IStorage realStorage) {
		realStorage.prepend(key, data);
	} // end of the method

	@Override
	protected void hookSet(String key, String data, IStorage realStorage) {
		realStorage.set(key, data);
	} // end of the method

	@Override
	protected Set<String> hookKeySet(IStorage realStorage) {
		return realStorage.keySet();
	} // end of the method

} // end of the class
