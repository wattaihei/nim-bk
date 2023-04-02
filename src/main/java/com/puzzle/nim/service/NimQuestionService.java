package com.puzzle.nim.service;

import com.puzzle.nim.domain.NimQuestion;

public interface NimQuestionService {
    public NimQuestion generate(Long pilenum, Long pilemax);

    public NimQuestion get(Long questionId);

    public NimQuestion operate(Long questionId, Long pileId, Long removeNum);
}
