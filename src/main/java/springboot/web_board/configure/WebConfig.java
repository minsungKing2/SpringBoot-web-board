package springboot.web_board.configure;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    // 요청이 들어오는 url 패턴을 뜻 함. 즉, 클라이언트로부터 들어오는 요청을 말함.
    private String resourcePath = "/upload/**";

    // 실제 파일이 저장될 경로를 뜻 함.
    private String savePath = "file:///C:/Users/minpr/OneDrive/바탕 화면/취업/Back-End/Project/web-board/web-board/src/main/resources/upload_files/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcePath)
                .addResourceLocations(savePath);
    }
}
