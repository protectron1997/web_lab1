package share;

public interface IValidator<T extends Number>{
    boolean check(T input);
}
