package ru.sbt.synapse.simpleauth.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    @GetMapping("/")
    public String viewHomePage(){
        return "main";
    }

    @GetMapping("/sales-department")
    public String viewPurchasingPage(){
        return "sales-department";
    }

    @GetMapping("/accountant")
    public String viewAccountPage(){
        return "accountant";
    }

    @GetMapping("/warehouse")
    public String viewWarehousePage(){
        return "warehouse";
    }
}
