package springboot.web_board.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.web_board.dto.BoardDTO;
import springboot.web_board.repository.BoardRepository;

@Service // 서비스 클래스 빈 등록
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);

    }
}
