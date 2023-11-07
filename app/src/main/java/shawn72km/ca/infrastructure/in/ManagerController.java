package shawn72km.ca.infrastructure.in;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import shawn72km.ca.port.in.manager.AddColumnUseCase;
import shawn72km.ca.port.in.manager.AddItemUseCase;
import shawn72km.ca.port.in.manager.ResetColumnUseCase;

@RequestMapping("/manager")
@RestController
@RequiredArgsConstructor
class ManagerController {
    private final AddColumnUseCase addColumnUseCase;
    private final ResetColumnUseCase resetColumnUseCase;
    private final AddItemUseCase addItemUseCase;

    @PostMapping("/column/add")
    public AddColumnUseCase.Result addColumn(ColumnBasicData data) {
        return addColumnUseCase.add(data.productName, data.price);
    }

    @PostMapping("/columns/{columnIndex}/reset")
    public ResetColumnUseCase.Result resetColumn(@PathVariable int columnIndex, ColumnBasicData data) {
        return resetColumnUseCase.reset(columnIndex, data.productName, data.price);
    }

    @PostMapping("/columns/{columnIndex}/add")
    public AddItemUseCase.Result addItem(@PathVariable int columnIndex) {
        return addItemUseCase.add(columnIndex);
    }

    static record ColumnBasicData(String productName, int price) { }
}
