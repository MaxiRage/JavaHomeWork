package hw.Interfaces;

public interface ICashRepo {
    boolean transaction(int payment, long cardFrom, long cardTo);
}
