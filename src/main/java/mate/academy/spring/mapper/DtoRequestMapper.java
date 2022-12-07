package mate.academy.spring.mapper;

public interface DtoRequestMapper<T, D> {
    T toModel(D d);
}
