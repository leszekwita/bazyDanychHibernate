package pl.radzik.michal.bazydanychhibernate.mapper;

import org.springframework.stereotype.Component;
import pl.radzik.michal.bazydanychhibernate.dto.WeatherDto;
import pl.radzik.michal.bazydanychhibernate.model.Weather;

@Component
public interface WeatherMapper {

    Weather toDao (WeatherDto userDto);
}