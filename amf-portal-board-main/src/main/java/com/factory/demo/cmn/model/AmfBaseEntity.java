package com.factory.demo.cmn.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스가 BaseEntity를 상속 받는 경우 필드들(createdDate, modifiedDate)을 컬럼으로 인식하게 합니다.
@EntityListeners(AuditingEntityListener.class) // 본 Entity에 Auditing 기능을 포함시킵니다.
public abstract class AmfBaseEntity {

    @CreatedDate // Entity가 생성되어 저장될 때 시간을 자동으로 저장합니다.
    private LocalDateTime createdDate;

    @LastModifiedDate // Entity 값이 변경될 때 시간을 자동으로 저장합니다.
    private LocalDateTime modifiedDate;
}
