package br.ic.ufal.gafanhotos.storage;

import java.util.Set;

/**
 * A classe abstrata {@code ATemplateStorage} funciona como um <i>wrapper</i> para um
 * {@link IStorage}. Cada método de {@code IStorage} é envolvido em um
 * <i>hook method</i>, que é um método abstrato.
 * <br />
 * Essa classe utilizada para promover variabilidade
 * <br /><br />
 * A classe implenta um <i>template method pattern</i>.
 */
public abstract class ATemplateStorage implements IStorage {

	IStorage realStorage;
	
	public ATemplateStorage(IStorage storage) {
		realStorage = storage;
	} // end of the constructor
	
	protected abstract void hookConcat(String key, String data, IStorage realStorage);
	protected abstract void hookCopy(String key1, String key2, IStorage realStorage);
	protected abstract void hookDelete(String key, IStorage realStorage);
	protected abstract String hookGet(String key, IStorage realStorage);
	protected abstract int hookLength(String key, IStorage realStorage);
	protected abstract void hookPrepend(String key, String data, IStorage realStorage);
	protected abstract void hookSet(String key, String data, IStorage realStorage);
	protected abstract Set<String> hookKeySet(IStorage realStorage);

	@Override
	public void set(String key, String data) {
		hookSet(key, data, realStorage);
	} // end of the method


	@Override
	public String get(String key) {
		return hookGet(key, realStorage);
	} // end of the method

	@Override
	public void delete(String key) {
		hookDelete(key, realStorage);
	} // end of the method

	@Override
	public void concat(String key, String value) {
		hookConcat(key, value, realStorage);
	} // end of the method

	@Override
	public void copy(String key1, String key2) {
		hookCopy(key1, key2, realStorage);
	} // end of the method

	@Override
	public int length(String key) {
		return hookLength(key, realStorage);
	} // end of the method

	@Override
	public void prepend(String key, String value) {
		hookPrepend(key, value, realStorage);
	} // end of the method

	@Override
	public Set<String> keySet() {
		return hookKeySet(realStorage);
	} // end of the method

} // end of the class
