package mate.academy.spring.mapper;

public interface Mapper<I, O, E> {
    E toModel(I request);

    O toDto(E entity);
}
