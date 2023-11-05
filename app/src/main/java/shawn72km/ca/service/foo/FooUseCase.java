package shawn72km.ca.service.foo;

public interface FooUseCase {
    Result doSomething(String id);

    record Result(String id, String message) { }
}
