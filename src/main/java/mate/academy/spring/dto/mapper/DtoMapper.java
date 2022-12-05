package mate.academy.spring.dto.mapper;

public interface DtoMapper<T, D> {
    D toDto(T t);

    T toModel(D d);
}
