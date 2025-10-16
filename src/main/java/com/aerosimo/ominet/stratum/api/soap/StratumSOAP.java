/******************************************************************************
 * This piece of work is to enhance stratum project functionality.            *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      StratumSOAP.java                                                *
 * Created:   09/10/2025, 23:35                                               *
 * Modified:  09/10/2025, 23:35                                               *
 *                                                                            *
 * Copyright (c)  2025.  Aerosimo Ltd                                         *
 *                                                                            *
 * Permission is hereby granted, free of charge, to any person obtaining a    *
 * copy of this software and associated documentation files (the "Software"), *
 * to deal in the Software without restriction, including without limitation  *
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,   *
 * and/or sell copies of the Software, and to permit persons to whom the      *
 * Software is furnished to do so, subject to the following conditions:       *
 *                                                                            *
 * The above copyright notice and this permission notice shall be included    *
 * in all copies or substantial portions of the Software.                     *
 *                                                                            *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,            *
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES            *
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND                   *
 * NONINFINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT                 *
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,               *
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING               *
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE                 *
 * OR OTHER DEALINGS IN THE SOFTWARE.                                         *
 *                                                                            *
 ******************************************************************************/

package com.aerosimo.ominet.stratum.api.soap;

import com.aerosimo.ominet.stratum.core.models.ProofPoint;
import com.aerosimo.ominet.stratum.dao.impl.StratumResponseDTO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.ws.BindingType;
import jakarta.xml.ws.soap.SOAPBinding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * SOAP endpoint for card validation.
 */
@WebService(
        name = "ValidateCardService",
        serviceName = "ValidateCardService",
        portName = "ValidateCardPort",
        targetNamespace = "https://aerosimo.com/api/ws"
)
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class StratumSOAP {

    private static final Logger log = LogManager.getLogger(StratumSOAP.class);

    @WebMethod(operationName = "validateCard")
    @WebResult(name = "cardNetwork", partName = "stratumResponse")
    public StratumResponseDTO validateCard(
            @XmlElement(required = true)
            @WebParam(name = "CardLongNumber", partName = "stratumRequest") String CardLongNumber
    ) {
        log.info("Validating card number: {}", CardLongNumber);
        return ProofPoint.verify(CardLongNumber.replaceAll("-", ""));
    }
}