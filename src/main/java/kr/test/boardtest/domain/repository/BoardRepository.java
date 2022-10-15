package kr.test.boardtest.domain.repository;

import kr.test.boardtest.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
