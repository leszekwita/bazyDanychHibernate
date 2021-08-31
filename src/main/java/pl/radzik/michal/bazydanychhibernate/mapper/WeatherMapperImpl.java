package pl.radzik.michal.bazydanychhibernate.mapper;

import org.springframework.stereotype.Component;
import pl.radzik.michal.bazydanychhibernate.dto.WeatherDto;
import pl.radzik.michal.bazydanychhibernate.mapper.WeatherMapper;
import pl.radzik.michal.bazydanychhibernate.model.Weather;

@Component
public class WeatherMapperImpl implements WeatherMapper {

    @Override
    public Weather toDao(WeatherDto weatherDto) {
        return Weather.builder()
                .id(weatherDto.getId())
                .temp(weatherDto.getTemp())
                .build();
    }

}
