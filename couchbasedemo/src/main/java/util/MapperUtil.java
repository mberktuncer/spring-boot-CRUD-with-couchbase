package util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MapperUtil {

    public static <S, T> T map(S source, Class<T> targetClass) {
        try {
            T target = targetClass.getDeclaredConstructor().newInstance();
            Field[] fields = source.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Field targetField = targetClass.getSuperclass().getDeclaredField(field.getName());
                    targetField.setAccessible(true);
                    targetField.set(target, field.get(source));
                } catch (NoSuchFieldException e) {
                    // Eğer üst sınıfta değilse, hedef sınıfın kendi alanlarına bakın
                    try {
                        Field targetField = targetClass.getDeclaredField(field.getName());
                        targetField.setAccessible(true);
                        targetField.set(target, field.get(source));
                    } catch (NoSuchFieldException ignored) {
                        // Eğer alan bulunamazsa, yoksayabiliriz
                    }
                }
            }
            return target;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Error mapping object", e);
        }
    }

}
