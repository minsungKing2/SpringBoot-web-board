package springboot.web_board.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springboot.web_board.dto.BoardDTO;
import springboot.web_board.service.BoardService;

@Controller // 컨트롤러 클래스라는 것을 스프링이 알 수 있게 함.
@RequiredArgsConstructor // 초기화 되지 않은 final 필드를 자동으로 생성자 주입해줌.
@Slf4j
public class BoardController {

    private final BoardService boardService; // final - 상수 선언

    @GetMapping("/save") // save.html 화면을 가져옴
    public String save(){
        return "save";
    }

    @PostMapping("/save") // post 요청을 받아서 해당 메서드로 매핑해줌. -> /save 에서 입력한 글을 DB 에 저장해줌.
    public void save(BoardDTO boardDTO) {
        boardService.save(boardDTO);

    }
}
