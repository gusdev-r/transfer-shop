package com.gusdev.transfershop.domain;

import com.gusdev.transfershop.exceptions.TaxNumberException;
import com.gusdev.transfershop.exceptions.enums.ErrorCode;

public class TaxNumber {

    private String value;

    public TaxNumber(String taxNumber) throws Exception {
        setValue(taxNumber);
    }
    public TaxNumber() {

    }
    public String getValue() {
        return this.value;
    }
    public void setValue(String value) throws Exception {
        if (!isValid(value)) throw new TaxNumberException(ErrorCode.ON0001.getMessage(), ErrorCode.ON0001.getCode());
    }

    private Boolean cpfValidation(String cpf) {
        int sum = 0;
        for (int index = 0; index < 9; index++) {
            sum += (cpf.charAt(index) - '0') * (10 - index);
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) {
            firstDigit = 0;
        }
        if (cpf.charAt(9) - '0' != firstDigit) {
            return false;
        }
        sum = 0;
        for (int index = 0; index < 10; index++) {
            sum += (cpf.charAt(index) - '0') * (11 - index);
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) {
            secondDigit = 0;
        }
        return cpf.charAt(10) - '0' == secondDigit;
    }

    private Boolean cnpjValidation (String cnpj) {
        int[] weights0 = {5, 4, 3, 2, 9, 8 , 7, 6, 5, 4, 3, 2};
        int sum = 0;
        for (int index = 0; index < 12; index++) {
            sum += (cnpj.charAt(index) - '0') * weights0[index];
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) {
            firstDigit = 0;
        }
        int[] weights1 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        sum = 0;
        for (int index = 0; index < 13; index++) {
            sum += (cnpj.charAt(index) - '0') * weights1[index];
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) {
            secondDigit = 0;
        }
        return cnpj.charAt(12) - '0' == secondDigit;
    }

    private Boolean isValid(String taxNumber) throws Exception {
        if (taxNumber.replaceAll("[^0-9]", "").length() == 11
                || taxNumber.replaceAll("[^0-9]", "").length() == 14) {
            if (taxNumber.length() == 11) {
                return cpfValidation(taxNumber);
            } else {
                return cnpjValidation(taxNumber);
            }
        } else {
            throw new TaxNumberException(ErrorCode.ON0001.getMessage(), ErrorCode.ON0001.getCode());
        }
    }


}
