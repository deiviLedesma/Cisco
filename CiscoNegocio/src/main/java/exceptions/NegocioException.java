/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author filor
 */
public class NegocioException  extends Exception {
     /**
     * Creates a new instance of <code>NegocioException</code> without
     * detail message.
     */
    public NegocioException() {
    }

    /**
     * Constructs an instance of <code>NegocioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NegocioException(String msg) {
        super(msg);

    }

    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }
}
