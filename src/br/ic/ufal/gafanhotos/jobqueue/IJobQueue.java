package br.ic.ufal.gafanhotos.jobqueue;

public interface IJobQueue {

	void execute(EMethod method, String key, byte[] data);

} // end of the interface
