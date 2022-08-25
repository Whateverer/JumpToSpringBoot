package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
// 엔티티타입, 엔티티의 pk속성타입
	
	// findBy + 엔티티의 속성명 과 같은 Repository 메서드를 작성하면 해당 속성으로 데이터를 조회할 수 있다.
	Question findBySubject(String subject);
	// findBy + 속성명 + And + 속성명
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
	Page<Question> findAll(Pageable pageable);
}
