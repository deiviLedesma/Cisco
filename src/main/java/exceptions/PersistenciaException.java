/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author filor
 */
public class PersistenciaException extends Exception{
    /**
     * Creates a new instance of <code>PersistenciaException</code> without
     * detail message.
     */
    public PersistenciaException() {
    }

    /**
     * Constructs an instance of <code>PersistenciaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PersistenciaException(String msg) {
        super(msg);

    }

    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }
}
