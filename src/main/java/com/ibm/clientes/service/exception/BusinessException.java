/**
 * 
 */
package com.ibm.clientes.service.exception;

/**
 * Excepcion para validaciones de reglas de negocio
 * 
 * @author Edwin Cardona
 *
 */
public class BusinessException extends IbmClienteException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(String msg, Throwable t) {
		super(msg, t);
	}

	public BusinessException(String msg) {
		super(msg);
	}

	public BusinessException(Throwable t) {
		super(t);
	}

}
