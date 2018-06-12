import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SubmarineAnnotation {
    String submarineType();
    String[] innerClasses();
    long creationCostInRoubles();
}
