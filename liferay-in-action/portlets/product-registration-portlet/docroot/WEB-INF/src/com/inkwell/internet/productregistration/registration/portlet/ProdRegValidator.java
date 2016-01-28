/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.inkwell.internet.productregistration.registration.portlet;

import com.inkwell.internet.productregistration.model.PRProduct;
import com.inkwell.internet.productregistration.model.PRRegistration;
import com.inkwell.internet.productregistration.model.PRUser;
import com.liferay.portal.kernel.util.Validator;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * This class is responsible for validating product registrations, users, and
 * the products themselves.
 *
 * @author rsezov
 */
public class ProdRegValidator {

    /**
     * Validates a RegUser object.
     *
     * @param user
     * @param errors
     * @return boolean
     */
    public static boolean validateUser(PRUser user, List errors) {

        boolean valid = true;

        if (Validator.isNull(user.getFirstName())) {
            errors.add("firstname-required");
            valid = false;
        }

        if (Validator.isNull(user.getLastName())) {
            errors.add("lastname-required");
            valid = false;
        }

        if (Validator.isNull(user.getAddress1()) ||
            Validator.isNull(user.getCity()) ||
            Validator.isNull(user.getState()) ||
            Validator.isNull(user.getPostalCode()) ||
            Validator.isNull(user.getCountry())) {

            errors.add("address-required");
            valid = false;
        }

        if (Validator.isNull(user.getEmail())) {
            errors.add("email-required");
            valid = false;
        }

        if (Validator.isNull(user.getPhoneNumber())) {
            errors.add("phone-number-required");
            valid = false;
        }
        else {

            if (!Validator.isPhoneNumber(user.getPhoneNumber())) {
                errors.add("phone-number-required");
                valid = false;
            }

        }

        if (Validator.isNotNull(user.getBirthDate())) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(user.getBirthDate());
            if (!Validator.isDate(
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.YEAR))) {
                errors.add("enter-valid-date");
                valid = false;
            }
        }
        else {
            errors.add("birthdate-required");
            valid = false;
        }

        if (Validator.isNull(user.getGender())) {
            errors.add("gender-required");
            valid = false;
        }

        if (Validator.isNull(user.getCompanyId())) {
            errors.add("missing-company-id");
            valid = false;
        }

        if (Validator.isNull(user.getGroupId())) {
            errors.add("missing-group-id");
            valid = false;
        }

        return valid;

    }

    /**
     * Validates a Registration object.
     *
     * @param registration
     * @param errors
     * @return
     */
    public static boolean validateRegistration(
        PRRegistration registration, List errors)
        throws Exception {

        boolean valid = true;

        if (Validator.isNull(registration.getCompanyId())) {
            errors.add("missing-company-id");
            valid = false;
        }

        if (Validator.isNull(registration.getGroupId())) {
            errors.add("missing-group-id");
            valid = false;
        }

        if (Validator.isNull(registration.getHowHear())) {
            errors.add("howhear-required");
            valid = false;
        }

        if (Validator.isNull(registration.getProductId())) {
            errors.add("product-type-required");
            valid = false;
        }

        if (Validator.isNull(registration.getSerialNumber())) {
            errors.add("serial-number-required");
            valid = false;
        }

        if (Validator.isNotNull(registration.getDatePurchased())) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(registration.getDatePurchased());
            if (!Validator.isDate(
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.YEAR))) {
                errors.add("enter-valid-date");
                valid = false;
            }
        }
        else {
            errors.add("date-purchased-required");
            valid = false;
        }

        if (Validator.isNull(registration.getWherePurchased())) {
            errors.add("where-purchased-required");
            valid = false;
        }

        if (registration.getProductId() == -1) {
            errors.add("product-type-required");
            valid = false;
        }

        return valid;

    }

    /**
     * Validates a Product object
     *
     * @param product
     * @param errors
     * @return boolean
     */
    public static boolean validateProduct(PRProduct product, List errors) {

        boolean valid = true;

        if (Validator.isNull(product.getProductName())) {
            errors.add("product-name-required");
            valid = false;
        }

        if (Validator.isNull(product.getSerialNumber())) {
            errors.add("serial-number-prefix-required");
            valid = false;
        }

        if (Validator.isNull(product.getCompanyId())) {
            errors.add("missing-company-id");
            valid = false;
        }

        if (Validator.isNull(product.getGroupId())) {
            errors.add("missing-group-id");
            valid = false;
        }

        return valid;
    }

}
