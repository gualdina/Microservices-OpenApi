package com.botcamp.userside.Service;

import com.botcamp.userside.model.RequestLog;
import com.botcamp.userside.model.Weather;
import com.botcamp.userside.provider.WeatherProvider;
import com.botcamp.userside.repository.RequestLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;


@Service
public class WeatherService {
    private final WeatherProvider weatherProvider;
    private final RequestLogRepository requestLogRepository;
    private final String user = "João";
    private final String userId = "askudb34332kdasdn";

    public WeatherService(WeatherProvider weatherProvider, RequestLogRepository requestLogRepository) {
        this.weatherProvider = weatherProvider;
        this.requestLogRepository = requestLogRepository;
    }

    public Weather findWeatherForCity(String city) {

        Weather weatherForCity = weatherProvider.getWeatherForCity(city);
        requestLogRepository.save( RequestLog
                .builder()
                .userName(user)
                .timeStamp(LocalTime.now())
                .requestedCity(city)
                .build());
        return weatherForCity;
    }
}
