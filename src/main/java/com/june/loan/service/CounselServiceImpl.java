package com.june.loan.service;

import com.june.loan.domain.Counsel;
import com.june.loan.dto.CounselDto;
import com.june.loan.repository.CounselRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CounselServiceImpl implements CounselService{

    private final CounselRepository counselRepository;
    private final ModelMapper modelMapper;

    @Override
    public CounselDto.Response create(CounselDto.Request request) {
        Counsel counsel = modelMapper.map(request, Counsel.class);
        counsel.setAppliedAt();
        Counsel createCounsel = counselRepository.save(counsel);

        return modelMapper.map(createCounsel, CounselDto.Response.class);
    }
}
