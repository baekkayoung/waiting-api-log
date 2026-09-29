package com.hi.waiting_api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/waiting")
@RequiredArgsConstructor
public class WaitingController {

    private final WaitingService waitingService;

    @PostMapping
    public String register(@RequestBody WaitingRequest waitingRequest) {

        String name = waitingRequest.getName();
        String phone = waitingRequest.getPhone();

        try {
            return waitingService.registerWaiting(name, phone);
        } catch (IllegalArgumentException e) {
            return "웨이팅 등록에 실패했습니다: " + e.getMessage();
        }
    }
}
