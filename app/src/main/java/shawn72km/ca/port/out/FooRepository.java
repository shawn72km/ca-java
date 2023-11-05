package shawn72km.ca.port.out;

import shawn72km.ca.domain.domain1.Domain1;

public interface FooRepository {
    Domain1 get(String id);

    void save(Domain1 domain);
}
