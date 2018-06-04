package com.liuxl.cartmall.core.mutidatasource.annotion;

import java.lang.annotation.*;

/**
 * 
 * 多数据源标识
 *
 * @author liuxl
 * @date 2017年3月5日 上午9:44:24
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface DataSource {

	String name() default "";
}