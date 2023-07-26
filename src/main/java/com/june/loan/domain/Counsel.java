package com.june.loan.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted=false")
public class Counsel extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long counselId;

    @Column(nullable = false,columnDefinition = "datetime COMMENT '신청일자'")
    private LocalDateTime appliedAt;

    @Column(nullable = false, columnDefinition = "varchar(12) COMMENT '상담 요청자'")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(23) COMMENT '전화번호'")
    private String cellPhone;

    @Column(columnDefinition = "varchar(50) COMMENT '상담 요청자 이메일'")
    private String email;

    @Column(columnDefinition = " text COMMENT '상담메모'")
    private String memo;

    @Column(columnDefinition = "varchar(50) COMMENT '주소'")
    private String address;

    @Column(columnDefinition = "varchar(50) COMMENT '상세 주소'")
    private String addressDetail;

    @Column(columnDefinition = "varchar(5) COMMENT '우편 번호'")
    private String zipCode;

    public void setAppliedAt(){
        this.appliedAt = LocalDateTime.now();
    }

}
