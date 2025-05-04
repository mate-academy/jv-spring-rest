package mate.academy.spring.service;

public interface DtoMapper<A, B, C> {
    C toDto(A model);

    A toModel(B requestDto);
}
