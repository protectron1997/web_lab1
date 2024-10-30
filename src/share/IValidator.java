package share;

public interface IValidator <T extends Number> {
    public boolean check(T input);
}
