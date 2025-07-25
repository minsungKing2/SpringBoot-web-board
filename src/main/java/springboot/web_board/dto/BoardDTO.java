package springboot.web_board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// DTO 란? Data Transfer Object - 데이터를 주고받기 위한 객체
@Getter // getter 메서드 자동 생성
@Setter // setter 메서드 자동 생성
@ToString // ToString 메서드를 통해 DTO 내부 정보를 printout 할 수 있게 해줌.

public class BoardDTO {

    private long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private String createAt;

}
