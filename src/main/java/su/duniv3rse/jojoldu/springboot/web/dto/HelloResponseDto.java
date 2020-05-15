package su.duniv3rse.jojoldu.springboot.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor// 선언된 모든 final필드가 포함된 생성자를 생성 (final이 없는 필드는 생성자에 포함 x)
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
