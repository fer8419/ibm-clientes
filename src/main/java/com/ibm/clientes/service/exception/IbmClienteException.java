/**
 * 
 */
package com.ibm.clientes.service.exception;

/**
 * Excepcion padre de la aplicacion
 * 
 * @author Edwin Cardona
 *
 */
public class IbmClienteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IbmClienteException(String msg, Throwable t) {
		super(msg, t);
	}

	public IbmClienteException(String msg) {
		super(msg);
	}

	public IbmClienteException(Throwable t) {
		super(t);
	}

}
