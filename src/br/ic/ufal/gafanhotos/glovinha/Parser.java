package br.ic.ufal.gafanhotos.glovinha;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.ic.ufal.gafanhotos.exception.BadRequestException;

/**
 * Faz o <i>parsing</i> de uma requisição.<br /><br />
 * Modelo de uma requisição:<br />
 * <pre>[METHOD] [KEY] [?ARG]</pre><br />
 * Exemplo:<br />
 * <pre>
 * PUT dog.name "Xiirgsnorphmentrem"<br />
 * CONCAT dog.name ", o Dog"<br />
 * GET dog.name
 * </pre>
 */
public class Parser {

	/**
	 * Conjunto de todos os métodos recebem somente um
	 * argumento.
	 */
	private Set<String> methods1;
	/**
	 * Conjunto de todos os métodos recebem somente dois
	 * argumento.
	 */
	private Set<String> methods2;
	/**
	 * Mapeia K = {@code EMethod.<method>.name()} e V = {@code EMethod.<method>}.
	 */
	private Map<String, EMethod> emethods;

	private final int METHOD_IX = 0; 
	private final int KEY_IX    = 1; 
	private final int ARG_IX    = 2; 

	public Parser() {
		methods1 = new HashSet<>();
		methods2 = new HashSet<>();
		emethods = new HashMap<>();

		methods2.add( EMethod.CONCAT.name() );
		emethods.put( EMethod.CONCAT.name(), EMethod.CONCAT );
		
		methods2.add( EMethod.COPY.name() );
		emethods.put( EMethod.COPY.name(), EMethod.COPY );
		
		methods2.add( EMethod.SET.name() );
		emethods.put( EMethod.SET.name(), EMethod.SET );
		
		methods2.add( EMethod.PREPEND.name() );
		emethods.put( EMethod.PREPEND.name(), EMethod.PREPEND );
		
		// # # # # # # # # # # # # # # # # # # # #

		methods1.add( EMethod.DEL.name() );
		emethods.put( EMethod.DEL.name(), EMethod.DEL );
		
		methods1.add( EMethod.LEN.name() );
		emethods.put( EMethod.LEN.name(), EMethod.LEN );
		
		methods1.add( EMethod.GET.name() );
		emethods.put( EMethod.GET.name(), EMethod.GET );
		
	} // end of the constructor

	/**
	 * Faz o <i>parsing</i> de uma messagem recebida e retorna
	 * um {@link Request}.
	 * 
	 * @param req - a messagem recebida
	 * @return um {@link Request}.
	 * @throws BadRequestException caso a mensagem seja mal formada.
	 */
	public Request parse(String req) throws BadRequestException {
		String  args[]  = req.split(" ");
		Request request = null;

		if( methods1.contains(args[METHOD_IX].toUpperCase())
				|| methods2.contains(args[METHOD_IX].toUpperCase()) ) {

			switch( args.length ) {
			case 2:
				request = parse2(args[METHOD_IX].toUpperCase(), args[KEY_IX]); break;
			case 3:
				request = parse3(args[METHOD_IX].toUpperCase(), args[KEY_IX], args[ARG_IX]); break;
			default:
				throw new BadRequestException(
						args.length > 3 ? "too many parameters." : "too few parameters."
						);
			} // end of switch
		} else {
			throw new BadRequestException(args[METHOD_IX].toUpperCase() + ": such method doesn't exist.");
		} //end of if-else

		return request;
	} // end of the method

	/**
	 * Faz o <i>parsing</i> de uma messagem recebida e retorna
	 * um {@link Request}.
	 * 
	 * @param method - métodos DEL, LEN ou GET.
	 * @param key - chave na tabela.
	 * @return um {@link Request}.
	 * @throws BadRequestException caso a mensagem seja mal formada.
	 */
	private Request parse2(String method, String key) throws BadRequestException {
		EMethod m = emethods.get(method);
		
		if( methods1.contains(method) ) {
			return new Request(m, key, null);
		} else {
			throw new BadRequestException(method + ": wrong number of arguments.");
		}
	} // end of the method

	/**
	 * Faz o <i>parsing</i> de uma messagem recebida e retorna
	 * um {@link Request}.
	 * 
	 * @param method - métodos CONCAT, COPY, SET ou PREPEND.
	 * @param key - chave na tabela.
	 * @param value - valor associado a chave.
	 * @return um {@link Request}.
	 * @throws BadRequestException caso a mensagem seja mal formada.
	 */
	private Request parse3(String method, String key, String value) throws BadRequestException {
		EMethod m = emethods.get(method);
		
		if( methods2.contains(method) ) {
			return new Request(m, key, value);
		} else {
			throw new BadRequestException(method + ": wrong number of arguments.");
		}
	} // end of the method

} // end of the class
