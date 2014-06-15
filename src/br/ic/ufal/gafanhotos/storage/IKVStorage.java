package br.ic.ufal.gafanhotos.storage;

public interface IKVStorage {

	void   put(String key, byte[] data);

	byte[] get(String key);

	void   delete(String key);

} // end of the interface
