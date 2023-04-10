package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //컨버터 추가
        //기존에 컨버터를 안써도 @RequestParam에서 컨버팅이 잘된 이유는 스프링에 이미 기본 컨버터들이 등록되어있다.
        //그런데 추가적으로 컨버터를 등록하면 우선순위가 추가한 컨버터가 먼저 사용되어, 실제 컨버터 사용 로그를 보면 직접 만든 컨버터 사용하는 것을 볼 수 있다.

//        registry.addConverter(new StringToIntegerConverter()); 포맷터를 위해 주석처리
//        registry.addConverter(new IntegerToStringConverter()); 포맷터를 위해 주석처리
        registry.addConverter(new IpPortToStringConverter());
        registry.addConverter(new StringToIpPortConverter());

        //추가
        registry.addFormatter(new MyNumberFormatter());
    }
}
