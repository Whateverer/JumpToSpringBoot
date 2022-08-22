package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
// questionRepository 속성을 포함하는 생성자 생성
@RequiredArgsConstructor
@Controller
public class QuestionController {

	private final QuestionService questionService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Question> questionList = questionService.getList();
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
	
	@RequestMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
	/**
	 * 질문등록 폼
	 * @return
	 */
	@GetMapping("/create")
	public String questionCreate() {
		return "question_form";
	}
	
	/**
	 * 질문등록
	 * @param subject
	 * @param content
	 * @return
	 */
	@PostMapping("/create")
	public String questionCreate(@RequestParam String subject, @RequestParam String content) {
		// TODO 질문을 저장한다.
		return "redirect:/question/list"; // 질문 저장 후 질문목록으로 이동
	}
}
