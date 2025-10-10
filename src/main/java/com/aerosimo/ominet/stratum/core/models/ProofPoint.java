/******************************************************************************
 * This piece of work is to enhance stratum project functionality.            *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      ProofPoint.java                                               *
 * Created:   09/10/2025, 22:44                                               *
 * Modified:  09/10/2025, 22:44                                               *
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

package com.aerosimo.ominet.stratum.core.models;

import com.aerosimo.ominet.stratum.dao.impl.StratumResponseDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ProofPoint class provides functionality to validate
 * credit card numbers using the Luhn algorithm and identify card types.
 */
public class ProofPoint {

    private static final Logger log;

    static {
        log = LogManager.getLogger(ProofPoint.class.getName());
    }

    static String isValid;
    static String cardType;
    static String message;

    public static StratumResponseDTO verify(String CardLongNumber) {

        if (CardLongNumber == null || CardLongNumber.isEmpty()) {
            log.error("Schema Validation failed because cardLongNumber is a required field but it is empty {}", CardLongNumber);
            return new StratumResponseDTO("false", "Unknown", "Card number is empty");
        } else if (CardLongNumber.length() <= 12 || CardLongNumber.length() > 19) {
            log.error("Schema Validation failed because cardLongNumber length is too short or too long {}", CardLongNumber);
            return new StratumResponseDTO("false", "Unknown", "Card number is too short or too long");
        } else {
            isValid = String.valueOf(CipherCheck.checkCardNumber(CardLongNumber));
            log.info("Validate Card Number is {}", isValid);
            cardType = LuhnWatch.checkCardType(CardLongNumber);
            log.info("Verify Card Type is {}", cardType);
            if (isValid.contains("true")) {message = "Card is valid";}
            else {message = "Card number is not valid";}
            return new StratumResponseDTO(isValid, cardType, message);
        }
    }
}