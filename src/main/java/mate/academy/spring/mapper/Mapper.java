package mate.academy.spring.mapper;

import java.util.List;

public interface Mapper<F, T> {
    T map(F input);

    default List<T> mapAll(List<F> inputList) {
        return inputList.stream().map(this::map).toList();
    }
}
