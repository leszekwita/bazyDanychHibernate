package pl.radzik.michal.bazydanychhibernate.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import pl.radzik.michal.bazydanychhibernate.model.Root;
import pl.radzik.michal.bazydanychhibernate.dto.WeatherDto;
import pl.radzik.michal.bazydanychhibernate.mapper.WeatherMapper;
import pl.radzik.michal.bazydanychhibernate.service.WeatherService;

import java.text.SimpleDateFormat;
import java.util.Date;


@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class AppConfig {

    private static final String URL = "http://api.weatherapi.com/v1/current.json?key=eefd1f537db44180b4b134806213108&q=Warsaw&aqi=no";

    private final WeatherService weatherService;

    private final WeatherMapper weatherMapper;

    @Scheduled(cron = "0 0/30 * * * ?")
    public void cronJobSch() {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setTemp(getWeather().getCurrent().getTemp_c());
        weatherService.save(weatherMapper.toDao(weatherDto));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        log.info("Java cron job expression {} ", strDate);
    }

    private Root getWeather() {
        RestTemplate restTemplate = new RestTemplate();
        Root forObject = restTemplate.getForObject(URL, Root.class);
        return forObject;
    }
}
