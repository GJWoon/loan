package com.june.loan.sevice;


import com.june.loan.domain.Counsel;
import com.june.loan.dto.CounselDto;
import com.june.loan.repository.CounselRepository;
import com.june.loan.service.CounselServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class CounselServiceTest {

    @InjectMocks
    CounselServiceImpl counselService;

    @Mock
    private CounselRepository counselRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void Should_ReturnResponseOFNewCounselEntity_When_RequestCounsel(){

        Counsel entity = Counsel.builder()
                .name("JUNE")
                .cellPhone("010-6464-9722")
                .email("ab@naver.com")
                .memo("대출을 받고 싶어요")
                .zipCode("1234")
                .address("서울특별시 어디어디")
                .addressDetail("101동 101호")
                .build();

        CounselDto.Request request = CounselDto.Request.builder()
                .name("JUNE")
                .cellPhone("010-6464-9722")
                .email("ab@naver.com")
                .memo("대출을 받고 싶어요")
                .zipCode("1234")
                .address("서울특별시 어디어디")
                .addressDetail("101동 101호")
                .build();

        when(counselRepository.save(ArgumentMatchers.any(Counsel.class))).thenReturn(entity);

        CounselDto.Response actual = counselService.create(request);

        assertThat(actual.getName()).isSameAs(entity.getName());
    };

}
