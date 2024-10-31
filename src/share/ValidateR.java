package share;

import Exceptions.ValidateException;

public class ValidateR implements IValidator<Double>{
    @Override
    public boolean check(Double r) {
        boolean result = false;
        if (r >= 2 && r <= 5) {
            result = true;
        } else {
            throw new ValidateException("wrong r value ");
        }
        return result;
    }
}
