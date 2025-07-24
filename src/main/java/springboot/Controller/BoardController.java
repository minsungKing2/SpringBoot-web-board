package springboot.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import springboot.dto.BoardDTO;
import springboot.service.BoardService;

@Controller // 컨트롤러 클래스라는 것을 스프링이 알 수 있게 함.
@RequiredArgsConstructor // 초기화 되지 않은 final 필드를 자동으로 생성자 주입해줌.
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/save") // post 요청을 받아서 해당 메서드로 매핑해줌.
    public void save(BoardDTO boardDTO) {
        boardService.save(boardDTO);

    }
}
