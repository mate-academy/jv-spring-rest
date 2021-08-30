package mate.academy.spring.service.mapper;

public interface GenericDtoMapper<E, I, O> {
    I parse(E entity);

    E toModel(O responseDto);
}
