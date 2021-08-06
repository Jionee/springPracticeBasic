package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@Component Annotation이 붙은 애들을 다 찾아서 bean으로 등록해줌
@ComponentScan (
        //여기서부터 component scan 시작
        //basePackages = "hello.core.member", //member만 스캔 대상이다
        //AppConfigr같은 애들은 제외하기
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

@Configuration
public class AutoAppConfig {

}
