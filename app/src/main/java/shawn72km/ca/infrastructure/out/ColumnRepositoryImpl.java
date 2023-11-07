package shawn72km.ca.infrastructure.out;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shawn72km.ca.application.domain.Column;
import shawn72km.ca.port.out.ColumnRepository;

@Repository
// FIXME: Naive repository
class ColumnRepositoryImpl implements ColumnRepository {
    private List<Column> internal = new ArrayList<Column>();

    @Override
    public Column get(int index) {
        if (index >= internal.size()) {
            throw new IllegalStateException();
        }
        return internal.get(index);
    }

    @Override
    public void add(Column column) {
        if (internal.size() != column.index()) {
            throw new IllegalStateException();
        }

        internal.add(column);
    }

    @Override
    public int size() {
        return internal.size();
    }
}
