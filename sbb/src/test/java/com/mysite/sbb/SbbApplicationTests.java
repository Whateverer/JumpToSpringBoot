package com.mysite.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionService questionService;
// 1. 테이블에 데이터 저장
//	@Test
//	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?");
//		q1.setContent("sbb에 대해서 알고싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);	// 첫번째 질문 저장
//		
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
//	}
	
// 2. 전체 조회 테스트
//	@Test
//	void testJpa() {
//		// findAll은 데이터를 조회할 때 사용하는 메서드이다.
//		// question 테이블에 저장된 모든 데이터를 조회하기 위해 findAll을 썼다.
//		List<Question> all = this.questionRepository.findAll();
//		// assertEquals는 assertEquals(기대값, 실제값)와 같이 사용하고 기대값과 실제값이 동일한지를 조사한다. 
//		assertEquals(2, all.size());
//		
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가요?" , q.getSubject());
//	}
	
//	3. ID 값으로 조회
//	@Test
//	void testJpa() {
//		// findById 메서드로 id로 객체를 조회할 수 있다. - return 타입이 Optional임
//		// Optional은 null 처리를 유연하게 하기 위해 사용하는 class
//		Optional<Question> oq = this.questionRepository.findById(1);
//		// null인지 검증
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}
//	}
	
//	4. subject 값으로 조회
//	@Test
//	void testJpa() {
//		// findBySubject라는 메서드를 만들어서 조회할 수 있다.
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1, q.getId());
//	}
	
//	5. subject와 content 값으로 조회
//	@Test
//	void testJpa() {
//		Question q = this.questionRepository.findBySubjectAndContent(
//				"sbb가 무엇인가요?", "sbb에 대해서 알고싶습니다.");
//		assertEquals(1, q.getId());
//	}
	
//	6. subject의 Like값으로 조회
//	@Test
//	void testJpa() {
//		// Like의 %값%으로 조회할 수 있다.
//		Question q = this.questionRepository.findBySubjectLike("sbb%");
//		assertEquals(1, q.getId());
//	}
	
//	7. 데이터 수정하기
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//		// assertTrue(값)은 값이 true인지를 테스트한다.
//		assertTrue(oq.isPresent()); 
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);
//	}
	
//	8. 데이터 삭제하기
//	@Test
//	void testJpa() {
//		// Repository의 count() 메서드는 해당 Respository의 총 데이터 건 수를 리턴한다.
//		assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());
//	}
	
//	9. 답변데이터 생성 후 저장
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q);	// 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
//	}
	
//	10. 답변데이터 조회
//	@Test
//	void testJpa() {
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());
//	}
	
//	11. 질문에서 답변조회
	// test 코드에서만 발생되는 오류 (DB 세션끊김)를 방지하기 위해 Transactional을 사용하면 
	// 메서드가 끝날 때 까지 DB 세션이 유지된다.
//	@Transactional
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		List<Answer> answerList = q.getAnswerList();
//		
//		assertEquals(1, answerList.size());
//		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	
	@Test
	void testJpa() {
		for(int i=1; i<=300; i++) {
			String subject = String.format("테스트데이터입니다:[%03d]", i);
			String content = "내용 무";
			this.questionService.create(subject, content);
		}
	}
	
}




