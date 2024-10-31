package share;

import Exceptions.ValidateException;

public class ValidateX implements IValidator<Double>{


    @Override
    public boolean check(Double x) {
        boolean result = false;
        if (x >= -5 && x <= 3) {
            result = true;
        } else {
            throw new ValidateException("Wrong x value");
        }
        return result;
    }


}
