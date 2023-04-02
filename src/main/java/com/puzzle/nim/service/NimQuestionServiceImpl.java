package com.puzzle.nim.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.puzzle.nim.config.InvalidOperationException;
import com.puzzle.nim.domain.NimQuestion;
import com.puzzle.nim.repository.NimQuestionRepository;

@Service
public class NimQuestionServiceImpl implements NimQuestionService {
    private final NimQuestionRepository nimQuestionRepository;

    public NimQuestionServiceImpl(NimQuestionRepository repository) {
        this.nimQuestionRepository = repository;
    }

    @Override
    public NimQuestion generate(Long pilenum, Long pilemax) {
        Random rand = new Random();

        List<Long> piles = Stream.generate(() -> rand.nextLong(pilemax-1)+1)
                                    .limit(pilenum)
                                    .collect(Collectors.toList());

        NimQuestion nimQuestion = new NimQuestion();
        Long questionId = this.nimQuestionRepository.getNextQuestionId();
        nimQuestion.setQuestionId(questionId);
        nimQuestion.setPiles(piles);

        this.nimQuestionRepository.insert(nimQuestion);

        return nimQuestion;
    }

    @Override
    public NimQuestion get(Long questionId) {
        return this.nimQuestionRepository.get(questionId);
    }

    @Override
    public NimQuestion operate(Long questionId, Long pileId, Long removeNum) throws Exception {
        // get current stats
        NimQuestion nimQuestion = this.nimQuestionRepository.get(questionId);
        List<Long> piles = nimQuestion.getPiles();
        Long currentNum = piles.get(pileId.intValue());
        if (currentNum < removeNum) {
            InvalidOperationException e = new InvalidOperationException(String.format("removing num is larger than current num. [questionId: %d pileId: %d removeNum: %d currentNum: %d]", questionId, pileId, removeNum, currentNum));
            throw e;
        }
        piles.set(pileId.intValue(), currentNum-removeNum);
        // nimQuestion.setPiles(piles);
        this.nimQuestionRepository.update(questionId, pileId, currentNum-removeNum);

        return nimQuestion;
    }
}
