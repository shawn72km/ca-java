package shawn72km.ca.adapter.in;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import shawn72km.ca.service.foo.FooUseCase;

@RestController
@RequiredArgsConstructor
class FooController {
    private final FooUseCase fooUseCase;

    @GetMapping("/foo")
    public FooUseCase.Result getFoo(@RequestParam String id) {
        return fooUseCase.doSomething(id);
    }
}
