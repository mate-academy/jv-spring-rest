package mate.academy.spring.service.mapper;

/**
 * Checkstyle didn't allow me to name generic parameters properly
 * and the first letter of Request and Response is the same,
 * so I decided to make a doc for this interface.
 *
 * @param <A> stands for modelRequestDto
 * @param <B> stands for modelResponseDto
 * @param <M> stands for model
 */
public interface Mapper<A, B, M> {
    B toDto(M model);

    M toModel(A modelRequestDto);
}
