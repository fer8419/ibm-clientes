/**
 * 
 */
package com.ibm.clientes.service.exception;

/**
 * Excepcion para cuando no se encuentra un recurso o una entidad en BD
 * 
 * @author Edwin Cardona
 *
 */
public class ResourceNotFoundException extends IbmClienteException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg, Throwable t) {
		super(msg, t);
	}

	public ResourceNotFoundException(String msg) {
		super(msg);
	}

	public ResourceNotFoundException(Throwable t) {
		super(t);
	}

}
