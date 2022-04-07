package mate.academy.spring.service.mapper;

public interface Mapper<Req, Resp, M> {
    Resp toDto(M model);

    M toModel(Req modelRequestDto);
}
