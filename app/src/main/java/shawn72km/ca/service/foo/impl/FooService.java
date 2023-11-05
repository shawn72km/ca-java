package shawn72km.ca.service.foo.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shawn72km.ca.domain.domain1.Domain1;
import shawn72km.ca.port.out.FooRepository;
import shawn72km.ca.service.foo.FooUseCase;

@Service
@RequiredArgsConstructor
class FooService implements FooUseCase {
    private final FooRepository fooRepository;

    @Override
    public Result doSomething(String id) {
        var domain1 = fooRepository.get(id);
        if (domain1 == null) {
            domain1 = new Domain1(id);
            fooRepository.save(domain1);
        }
        return new Result(domain1.id(), domain1.message());
    }
}
