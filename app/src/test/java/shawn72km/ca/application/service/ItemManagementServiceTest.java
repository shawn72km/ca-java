package shawn72km.ca.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import shawn72km.ca.application.domain.Column;
import shawn72km.ca.port.out.ColumnRepository;

public class ItemManagementServiceTest {
    ColumnRepository columnRepository = mock(ColumnRepository.class);
    ItemManagementService sut = new ItemManagementService(columnRepository);

    @Test
    void testAdd() {
        // given
        final var columnIndex = 0;

        final var column = new Column(columnIndex, "COKE", 800);
        column.add(5);

        when(columnRepository.get(columnIndex)).thenReturn(column);
        
        // when
        final var result = sut.add(columnIndex);

        // then
        assertEquals(columnIndex, result.columnIndex());
        assertEquals(6, result.numberOfRemaining());
    }
}
