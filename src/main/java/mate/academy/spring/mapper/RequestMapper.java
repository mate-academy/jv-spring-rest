package mate.academy.spring.mapper;

public interface RequestMapper<I,E> {
    E toModel(I request);
}
