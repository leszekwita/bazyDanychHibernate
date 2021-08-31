package pl.radzik.michal.bazydanychhibernate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.radzik.michal.bazydanychhibernate.repository.WeatherRepository;
import pl.radzik.michal.bazydanychhibernate.model.Weather;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {


    private final WeatherRepository weatherRepository;

    @Override
    public void save(Weather weather) {
        weatherRepository.save(weather);
    }
}
