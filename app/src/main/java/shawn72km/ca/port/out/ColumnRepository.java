package shawn72km.ca.port.out;

import shawn72km.ca.application.domain.Column;

public interface ColumnRepository {
    Column get(int index);

    void add(Column column);

    int size();
}
