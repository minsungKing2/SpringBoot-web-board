package springboot.web_board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// DTO 란? Data Transfer Object - 데이터를 주고받기 위한 객체
@Getter // getter 메서드 자동 생성
@Setter // setter 메서드 자동 생성
@ToString // ToString 메서드를 통해 DTO 내부 정보를 printout 할 수 있게 해줌.
public class BoardDTO {

    private long id; // 번호
    private String boardWriter; // 작성자
    private String boardPass; // 비밀번호
    private String boardTitle; // 제목
    private String boardContents; // 내용
    private String createdAt; // 작성시간
    private int boardHits; // 조회수
    private int fileAttached; // 파일첨부 유무 확인
    private List<MultipartFile> boardFile; // 클라이언트로 부터 넘어올 파일을 담게 될 필드
}
