package com.puzzle.nim.domain;

import java.util.List;

public class NimQuestion {
    private Long questionId;

    private List<Long> piles;

    public Long getQuestionId() {
        return questionId;
    }

    public List<Long> getPiles() {
        return piles;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setPiles(List<Long> piles) {
        this.piles = piles;
    }
}
