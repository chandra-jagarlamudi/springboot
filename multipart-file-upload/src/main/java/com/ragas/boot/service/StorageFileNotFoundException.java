/**
 * 
 */
package com.ragas.boot.service;

/**
 * @author Chandra Jagarlamudi
 *
 */
public class StorageFileNotFoundException extends StorageException {

	public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
