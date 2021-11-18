package Day1118.demo01;

import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author 孙珑瑜
 * @version 211118
 * 元注解
 */
@Inherited
@Target({TYPE,FIELD,CONSTRUCTOR,METHOD})
public @interface AnnotationTest {

}
