package mate.academy.spring.service.mapper;

public interface GenericDtoMapper<RequestT, ResponseT, E> {
    ResponseT toDto(E entity);

    E toModel(RequestT requestDto);
}
