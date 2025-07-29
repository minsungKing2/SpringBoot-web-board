package springboot.web_board.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import springboot.web_board.dto.BoardDTO;
import springboot.web_board.service.BoardService;

import java.util.List;

@Controller // 컨트롤러 클래스라는 것을 스프링이 알 수 있게 함.
@RequiredArgsConstructor // 초기화 되지 않은 final 필드를 자동으로 생성자 주입해줌.
@Slf4j
public class BoardController {

    private final BoardService boardService; // final - 상수 선언

    @GetMapping("/save") // save.html 화면을 가져옴
    public String save() {
        return "save";
    }

    @PostMapping("/save") // post 요청을 받아서 해당 메서드로 매핑해줌. -> /save 에서 입력한 글을 DB 에 저장해줌.
    public String save(BoardDTO boardDTO) {
        boardService.save(boardDTO);
        return "redirect:/list";
        // 글을 작성하면 리다이렉션이 되도록 반환타입을 String 으로 변경하고, /list url 로 리다이렉션 해줌.
        // 글 작성이 성공하면, localhost:8080/list 로 페이지가 넘어간다.
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }

    @GetMapping("/{id}") // @PathVariable: 자동으로 url 요청을 변수에 담는 기능 -> localhost:8080/id 형태로 id 라는 변수를 담아줌.
    public String findById(@PathVariable("id") Long id, Model model) {
        // 조회수 처리
        boardService.updateHits(id);
        // 상세내용 가져오기
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "detail";
    }

    // 수정 버튼 클릭시 수정화면으로 넘어가도록 하는 메서드(GET 방식)
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "update";
    }

    // DB에 실질적으로 수정내용을 요청하는 메서드(POST 방식)
    @PostMapping("/update/{id}")
    public String update(BoardDTO boardDTO, Model model) {
        // update 요청
        boardService.update(boardDTO);
        // findById로 수정된 내용을 다시 조회
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board", dto);
        return "detail";
    }

    // 삭제 기능
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        boardService.delete(id);
        return "redirect:/list";
    }
}
