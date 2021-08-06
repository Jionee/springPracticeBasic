package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
//어노테이션을 모아서 사용할 수 있음을 보여주는 예시
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {

}
