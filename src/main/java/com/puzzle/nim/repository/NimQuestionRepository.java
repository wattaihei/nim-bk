package com.puzzle.nim.repository;

import com.puzzle.nim.domain.NimQuestion;

public interface NimQuestionRepository {
    public NimQuestion get(Long questionId);

    public Long getNextQuestionId();

    public int insert(NimQuestion nimQuestion);

    public int update(Long questionId, Long pileId, Long pileNum);
}
