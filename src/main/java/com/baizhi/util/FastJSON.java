package com.baizhi.util;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

/**
 * 自定义FastJson的配置类
 * 配置使用fastJson框架
 */

@Configuration
public class FastJSON {

    /*@Bean //等价 <bean id="" class="">  方法的返回值是spring容器所管理的对象
    public HttpMessageConverters createHttpMessageConverters() {
        //1. 创建fastjson的消息转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //2. 初始化消息转换器
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 使用UTF-8的编码格式
        fastJsonConfig.setCharset(Charset.defaultCharset());
        // 设置序列化的特性 自动对json进行格式化
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //3. 将Fastjson消息转换器加入到spring的消息转换器的列表
        HttpMessageConverters converters = new HttpMessageConverters(fastJsonHttpMessageConverter);
        //4. 通过spring工厂负责消息转换器对象的创建和销毁
        return converters;
    }*/

}
