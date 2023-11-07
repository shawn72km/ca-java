package shawn72km.ca.application.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shawn72km.ca.application.domain.Column;
import shawn72km.ca.port.in.manager.AddColumnUseCase;
import shawn72km.ca.port.in.manager.ResetColumnUseCase;
import shawn72km.ca.port.out.ColumnRepository;

@Service
@RequiredArgsConstructor
public class ColumnManagementService implements
        AddColumnUseCase, 
        ResetColumnUseCase {
    private final ColumnRepository columnRepository;

    @Override
    public AddColumnUseCase.Result add(String productName, int price) {
        final var column = new Column(columnRepository.size(), productName, price);
        columnRepository.add(column);
        return new AddColumnUseCase.Result(column.index(), productName, price, column.numberOfRemaining());
    }

    @Override
    public ResetColumnUseCase.Result reset(int columnIndex, String productName, int price) {
        final var column = columnRepository.get(columnIndex);
        column.reset(productName, price);
        return new ResetColumnUseCase.Result(columnIndex, productName, price, column.numberOfRemaining());
    }
}
