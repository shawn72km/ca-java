package shawn72km.ca.port.in.manager;

public interface AddColumnUseCase {
    Result add(String productName, int price);

    record Result(int columnIndex, String productName, int price, int numberOfRemaining) { } 
}
