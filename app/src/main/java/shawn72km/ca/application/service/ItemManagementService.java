package shawn72km.ca.application.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shawn72km.ca.application.domain.Column;
import shawn72km.ca.port.in.manager.AddItemUseCase;
import shawn72km.ca.port.out.ColumnRepository;

@Service
@RequiredArgsConstructor
class ItemManagementService implements AddItemUseCase {
    private final ColumnRepository columnRepository;

    @Override
    public Result add(int columnIndex) {
        Column column = columnRepository.get(columnIndex);
        final var numberOfItems = column.add(1);
        return new Result(columnIndex, numberOfItems);
    }
}
