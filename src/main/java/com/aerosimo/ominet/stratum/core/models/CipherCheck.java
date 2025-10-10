/******************************************************************************
 * This piece of work is to enhance stratum project functionality.            *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      CipherCheck.java                                            *
 * Created:   09/10/2025, 22:31                                               *
 * Modified:  09/10/2025, 22:31                                               *
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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CipherCheck {

    private static final Logger log;

    static {
        log = LogManager.getLogger(CipherCheck.class.getName());
    }

    /**
     * Validates a given credit card number using the Luhn algorithm.
     *
     * @param cardNumber The credit card number as a String.
     * @return true if the card number is valid according to the Luhn algorithm, false otherwise.
     */

    public static boolean checkCardNumber(String cardNumber) {
        // Check if the card number is null or empty
        log.info("Check if the card number is null or empty {}", cardNumber);
        if (cardNumber == null || cardNumber.isEmpty()) {
            return false;
        }

        // Check if the card number contains only digits
        log.info("Check if the card number contains only digits {}", cardNumber);
        if (!cardNumber.matches("\\d+")) {
            return false;
        }

        // Reverse the card number and convert to character array
        log.info("Reverse the card number and convert to character array {}", cardNumber);
        char[] cardDigits = new StringBuilder(cardNumber).reverse().toString().toCharArray();
        int sum = 0;

        for (int i = 0; i < cardDigits.length; i++) {
            int digit = Character.getNumericValue(cardDigits[i]);

            // Double every second digit (i.e., digits at odd indices)
            if (i % 2 == 1) {
                digit *= 2;
                // If the result is greater than 9, subtract 9
                if (digit > 9) {
                    digit -= 9;
                }
            }

            // Sum all the digits
            sum += digit;
        }

        // A valid card number will have a total sum that is a multiple of 10
        return sum % 10 == 0;
    }
}