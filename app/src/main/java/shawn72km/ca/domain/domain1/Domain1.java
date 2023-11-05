package shawn72km.ca.domain.domain1;

import java.util.concurrent.atomic.AtomicLong;

public class Domain1 {
    private final String id;

    private final AtomicLong counter = new AtomicLong();

    public Domain1(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }

    public String message() {
        return "The current value is " + counter.incrementAndGet();
    }
}
