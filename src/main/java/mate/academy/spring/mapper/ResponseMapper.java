package mate.academy.spring.mapper;

public interface ResponseMapper<O, E> {
    O toDto(E model);
}
