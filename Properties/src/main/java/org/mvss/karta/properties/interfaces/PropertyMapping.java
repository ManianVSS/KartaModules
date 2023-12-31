package org.mvss.karta.properties.interfaces;

import org.mvss.karta.Constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertyMapping {
    /**
     * The name of the property
     */
    String value() default Constants.EMPTY_STRING;

    /**
     * Alias for default value
     **/
    String name() default Constants.EMPTY_STRING;

    /**
     * The class type to map the property value.
     */
    Class<?> type() default Object.class;
}
