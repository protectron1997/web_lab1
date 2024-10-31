package share;

import Exceptions.ValidateException;

public class ValidateY implements IValidator<Integer>{
    @Override
    public boolean check(Integer y) {
        boolean result = false;
        if (y >= -4 && y <= 4) {
            result = true;
        } else {
            throw new ValidateException("wrong y value ");
        }
        return result;
    }
}
