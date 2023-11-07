package shawn72km.ca.port.in.manager;

public interface AddItemUseCase {
    Result add(int columnIndex);

    record Result(int columnIndex, int numberOfRemaining) { }
}
