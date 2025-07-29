package springboot.web_board.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springboot.web_board.dto.BoardDTO;
import springboot.web_board.dto.BoardFileDTO;
import springboot.web_board.repository.BoardRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service // 서비스 클래스 빈 등록
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) throws IOException {
        if (boardDTO.getBoardFile().get(0).isEmpty()) {
            // 파일 없음
            boardDTO.setFileAttached(0);
            boardRepository.save(boardDTO);
        } else {
            // 파일이 존재
            boardDTO.setFileAttached(1);
            // board 를 먼저 insert 함
            BoardDTO saveBoard = boardRepository.save(boardDTO);
            // 파일 처리 후 boardFile insert
            for (MultipartFile boardFile : boardDTO.getBoardFile()) {
                String originalFilename = boardFile.getOriginalFilename();
                String storedFileName = System.currentTimeMillis() + "_" + originalFilename;

                BoardFileDTO boardFileDTO = new BoardFileDTO();
                boardFileDTO.setOriginalFileName(originalFilename);
                boardFileDTO.setStoredFileName(storedFileName);
                boardFileDTO.setBoardId(saveBoard.getId());

                String savePath = "C:/Users/minpr/OneDrive/바탕 화면/취업/Back-End/Project/web-board/web-board/src/main/resources/upload_files/" + storedFileName;
                // 실질적으로 파일이 저장되는 코드
                boardFile.transferTo(new File(savePath));
                boardRepository.saveFile(boardFileDTO);
            }
        }
    }

    public List<BoardFileDTO> findFile(Long id) {
        return boardRepository.findFile(id);
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

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }
}