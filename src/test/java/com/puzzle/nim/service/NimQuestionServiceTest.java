package com.puzzle.nim.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.puzzle.nim.domain.NimQuestion;
import com.puzzle.nim.repository.NimQuestionRepository;

public class NimQuestionServiceTest {
    @Mock
    private NimQuestionRepository nimQuestionRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerate() {
        Long questionId = 1L;
        Long pilenum = 3L;
        Long pilemax = 100L;
        when(this.nimQuestionRepository.getNextQuestionId()).thenReturn(questionId);
        when(this.nimQuestionRepository.insert(any(NimQuestion.class))).thenReturn(1);

        NimQuestionService service = new NimQuestionServiceImpl(this.nimQuestionRepository);
        NimQuestion actual = service.generate(pilenum, pilemax);

        verify(this.nimQuestionRepository, times(1)).getNextQuestionId();
        verify(this.nimQuestionRepository, times(1)).insert(any(NimQuestion.class));
        assertEquals(actual.getPiles().size(), pilenum.longValue());
        assert(Collections.max(actual.getPiles()) <= pilemax.longValue());
    }
}
