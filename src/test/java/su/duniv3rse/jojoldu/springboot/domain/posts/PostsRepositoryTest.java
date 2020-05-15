package su.duniv3rse.jojoldu.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)                // JUnit내장 실행자 대신 스코프에 정의된 실행자를 실행.
@SpringBootTest                             // 별다른 설정없이 사용시 h2 db 사용
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {

        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {

        String title = "테스트 게시글";
        String content = "테스트 본문";

        /*
            테이블 posts에 insert/update 쿼리를 실행함
            id 값이 있다면 update, 없다면 insert
         */
        postsRepository.save(Posts.builder()        // @Entity Posts에 정의된 @Builder생성자
                .title(title)
                .content(content)
                .author("duniv3rse")
                .build());

        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);

        assertThat(posts.getTitle()).isEqualTo(title);      // return된 값(only 문자열) 비교.
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
