package mate.academy.spring.service;

public interface Mapper<M, R, Q> {
    R toDto(M model);

    M toModel(Q dto);
}
