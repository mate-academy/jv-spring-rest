package mate.academy.spring.service.mapper;

public interface Mapper<Req, Resp, Model> {
    Resp toDto(Model model);

    Model toModel(Req modelRequestDto);
}
