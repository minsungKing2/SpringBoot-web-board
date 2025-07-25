package springboot.web_board.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import springboot.web_board.dto.BoardDTO;

@Repository // 레포지토리 클래스 등록
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql; // mybatis 를 사용하기 위한 SqlSessionTemplate 객체 사용

    public void save(BoardDTO boardDTO) {
        sql.insert("Board.save", boardDTO);
        // insert 메서드의 파라미터로 mapper 의 namespace 인 Board 로 접근하여 sql 문 수행
        // board-mapper.xml 에서 해당 mapper 의 namespace 를 Board 로 지정해놓았음.
    }
}
