package springboot.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.dto.BoardDTO;
import springboot.repository.BoardRepository;

@Service // 서비스 클래스 빈 등록
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);

    }
}
