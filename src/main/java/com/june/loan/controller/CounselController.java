package com.june.loan.controller;


import com.june.loan.dto.CounselDto;
import com.june.loan.dto.ResponseDTO;
import com.june.loan.service.CounselService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/counsels")
public class CounselController extends AbstractController{

    private final CounselService counselService;

    @PostMapping
    public ResponseDTO<CounselDto.Response> create(@RequestBody CounselDto.Request request){
        return ok(counselService.create(request));
    }
}
