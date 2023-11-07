package shawn72km.ca.application.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ColumnTest {
    @Test
    void testReset() {
        // given
        final var column = new Column(0, "COKE", 800);
        column.add(5);

        // when
        column.reset("PEPSI", 800);
        
        // then
        assertEquals(0, column.index());
        assertEquals("PEPSI", column.productName());
        assertEquals(800, column.price());
        assertEquals(0, column.numberOfRemaining());
    }

    @Test
    void testAdd() {
        // given
        final var column = new Column(0, "COKE", 800);

        // when
        column.add(2);

        // then
        assertEquals(0, column.index());
        assertEquals("COKE", column.productName());
        assertEquals(800, column.price());
        assertEquals(2, column.numberOfRemaining());
    }

    @Test
    void testTake() {
        // given
        final var column = new Column(0, "COKE", 800);
        column.add(2);

        // when
        column.take();

        // then
        assertEquals(0, column.index());
        assertEquals("COKE", column.productName());
        assertEquals(800, column.price());
        assertEquals(1, column.numberOfRemaining());
    }
}
