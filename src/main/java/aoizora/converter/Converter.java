package aoizora.converter;

import java.util.List;

import static java.util.stream.Collectors.toList;

public interface Converter<S, T>
{
    T convert(S source);

    default List<T> convert(List<S> sources)
    {
        return sources.stream()
                .map(this::convert)
                .collect(toList());
    }
}
