package shawn72km.ca.application.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Column {
    private final AtomicInteger numberOfRemaining = new AtomicInteger();

    private int index; // FIXME: Temporary ID
    private String productName;
    private int price;

    public Column(int index, String productName, int price) {
        this.index = index;
        this.productName = productName;
        this.price = price;
    }

    public int index() {
        return this.index;
    }

    public String productName() {
        return this.productName;
    }

    public int price() {
        return this.price;
    }

    public int numberOfRemaining() {
        return numberOfRemaining.get();
    }

    public void reset(String productName, int price) {
        this.productName = productName;
        this.price = price;

        set(0);
    }

    public int add(int numberOfItems) {
        final var newNumberOfRemaining = numberOfRemaining.get() + numberOfItems;
        if (newNumberOfRemaining < 0) {
            throw new IllegalStateException();
        }

        set(newNumberOfRemaining);
        return newNumberOfRemaining;
    }

    public int take() {
        return add(-1);
    }

    private void set(int newNumberOfRemaining) {
        final var current = numberOfRemaining.get();
        if (!numberOfRemaining.compareAndSet(current, newNumberOfRemaining)) {
            throw new IllegalStateException();
        }
    }
}
