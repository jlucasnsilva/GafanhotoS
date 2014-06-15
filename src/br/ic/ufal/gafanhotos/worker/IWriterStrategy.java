package br.ic.ufal.gafanhotos.worker;

interface IWriterStrategy extends Runnable {

	public void write(String key, byte[] data);

} // end of the interface
