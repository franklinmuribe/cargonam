/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.cargonam.service.exception;

import java.util.List;
import javax.xml.ws.WebFault;

/**
 *
 * @author furibe
 */

public class cargonamlException extends Exception {

    private SimpleExceptionBean faultBean;
    /**
     * Java type that goes as soapenv:Fault detail element.
     */
  

    public cargonamlException(String message, SimpleExceptionBean faultInfo) {
        super(message);
        faultBean  = faultInfo;
    }
    public cargonamlException(SimpleExceptionBean faultInfo) {
        super(faultInfo.getMessage());
        faultBean  = faultInfo;
    }

    public cargonamlException(String message, SimpleExceptionBean faultInfo, Throwable cause) {
        super(message, cause);
        faultBean  = faultInfo;
    }

    public cargonamlException(String message) {
        super(message);
    }
   
    
      public SimpleExceptionBean getFaultInfo(){
        return faultBean;
    }

}
