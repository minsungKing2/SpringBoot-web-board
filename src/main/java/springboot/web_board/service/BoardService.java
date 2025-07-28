package springboot.web_board.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.web_board.dto.BoardDTO;
import springboot.web_board.repository.BoardRepository;

import java.util.List;

@Service // 서비스 클래스 빈 등록
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);
    }

    public List<BoardDTO> findAll(){
        return boardRepository.findAll();
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }
}