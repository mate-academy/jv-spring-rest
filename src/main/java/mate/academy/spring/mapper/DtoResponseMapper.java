package mate.academy.spring.mapper;

public interface DtoResponseMapper<T, D> {
    D toDto(T t);
}
