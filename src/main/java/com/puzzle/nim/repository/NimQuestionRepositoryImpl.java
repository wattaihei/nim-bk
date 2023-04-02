package com.puzzle.nim.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.puzzle.nim.domain.NimQuestion;
import com.puzzle.nim.repository.mapper.NimQuestionMapper;

@Repository
public class NimQuestionRepositoryImpl implements NimQuestionRepository {
    private final NimQuestionMapper nimQuestionMapper;

    public NimQuestionRepositoryImpl(NimQuestionMapper mapper) {
        this.nimQuestionMapper = mapper;
    }

    @Override
    public NimQuestion get(Long questionId) {
        List<Long> piles = nimQuestionMapper.get(questionId);
        NimQuestion nimQuestion = new NimQuestion();
        nimQuestion.setQuestionId(questionId);
        nimQuestion.setPiles(piles);
        return nimQuestion;
    }

    @Override
    public Long getNextQuestionId() {
        return this.nimQuestionMapper.getNextQuestionId();
    }

    @Override
    public int insert(NimQuestion nimQuestion) {
        return this.nimQuestionMapper.insert(nimQuestion.getQuestionId(), nimQuestion.getPiles());
    }

    @Override
    public int update(Long questionId, NimQuestion nimQuestion) {
        return 1;
    }
}
