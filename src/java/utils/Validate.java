package utils;

import exception.PhoneException;

public class Validate {

    public void checkNumber(String telephone) throws Exception {
        if (telephone.charAt(0) != '+') {
            throw new PhoneException("Номер начинается с +7");
        } else if (telephone.length() != 12) {
            throw new PhoneException("Введите +7 и 10 цифр");
        }
    }
}