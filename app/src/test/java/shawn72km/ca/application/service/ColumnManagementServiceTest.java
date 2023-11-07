package shawn72km.ca.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import shawn72km.ca.application.domain.Column;
import shawn72km.ca.port.out.ColumnRepository;

public class ColumnManagementServiceTest {
    ColumnRepository columnRepository = mock(ColumnRepository.class);
    ColumnManagementService sut = new ColumnManagementService(columnRepository);

    @Test
    void testAdd() {
        // given
        when(columnRepository.size()).thenReturn(1);

        final var productName = "COKE";
        final var price = 800;
        
        // when
        final var result = sut.add(productName, price);

        // then
        assertEquals(1, result.columnIndex());
        assertEquals(productName, result.productName());
        assertEquals(price, result.price());
        assertEquals(0, result.numberOfRemaining());
    }

    @Test
    void testReset() {
        // given
        final var column = new Column(0, "COKE", 800);
        column.add(5);

        when(columnRepository.get(0)).thenReturn(column);

        // when
        var result = sut.reset(0, "PEPSI", 800);

        // then
        assertEquals(0, result.columnIndex());
        assertEquals("PEPSI", result.productName());
        assertEquals(800, result.price());
        assertEquals(0, result.numberOfRemaining());
    }
}
