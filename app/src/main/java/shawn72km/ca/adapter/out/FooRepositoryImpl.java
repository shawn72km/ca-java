package shawn72km.ca.adapter.out;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import shawn72km.ca.domain.domain1.Domain1;
import shawn72km.ca.port.out.FooRepository;

@Repository
class FooRepositoryImpl implements FooRepository {
    private Map<String, Domain1> internal = new HashMap<String, Domain1>();

    @Override
    public Domain1 get(String id) {
        return internal.get(id);
    }

    @Override
    public void save(Domain1 domain) {
        internal.put(domain.id(), domain);
    }
}
