package com.june.loan.service;

import com.june.loan.dto.CounselDto;

public interface CounselService {

    CounselDto.Response create(CounselDto.Request request);
}
