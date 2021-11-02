package com.botcamp.userside.Service;

import com.botcamp.userside.model.RequestLog;
import com.botcamp.userside.repository.RequestLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestLogService {
    private final RequestLogRepository requestLogRepository;

    public RequestLogService(RequestLogRepository requestLogRepository) {
        this.requestLogRepository = requestLogRepository;
    }

    public void test() {
        System.out.println(requestLogRepository.findAll());
    }

    public List<RequestLog> getRequestlogs() {
    return requestLogRepository.findAll();
    }
}
