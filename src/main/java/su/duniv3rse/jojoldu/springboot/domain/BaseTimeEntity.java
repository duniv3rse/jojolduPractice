package su.duniv3rse.jojoldu.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // JPA Entity 클래스들이 이 클래스를 상속할 경우 (createdDate, modifiedDate)도 컬럼으로 인식하게 한다.
@EntityListeners(AuditingEntityListener.class)  // 클래스에 Auditing 기능을 포함시킨다.
public abstract class BaseTimeEntity {

    @CreatedDate    // Entity 가 생성되어 자장될 때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate   // Entity 가 수정될 때 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;


}

