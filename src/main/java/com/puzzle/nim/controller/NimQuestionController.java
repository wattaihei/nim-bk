package com.puzzle.nim.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puzzle.nim.config.InvalidOperationException;
import com.puzzle.nim.domain.NimQuestion;
import com.puzzle.nim.service.NimQuestionService;

@RestController
@RequestMapping("v1/api/nim")
public class NimQuestionController {
    private final NimQuestionService nimQuestionService;

    public NimQuestionController(NimQuestionService service) {
        this.nimQuestionService = service;
    }

    @PostMapping(path = "/question")
    public NimQuestion generate(
        @RequestParam("pilenum") Long pilenum,
        @RequestParam("pilemax") Long pilemax
    ) {
        return this.nimQuestionService.generate(pilenum, pilemax);
    }

    @GetMapping(path = "/question/{questionId}")
    public NimQuestion get(@PathVariable Long questionId) {
        return this.nimQuestionService.get(questionId);
    }

    @PostMapping(path = "/op/{questionId}")
    public ResponseEntity<NimQuestion> operate(
        @PathVariable Long questionId,
        @RequestParam(value = "pileId", required = true) Long pileId,
        @RequestParam(value = "removeNum", required = true) Long removeNum
    ) {
        try {
            NimQuestion nimQuestion = this.nimQuestionService.operate(questionId, pileId, removeNum);
            return new ResponseEntity<>(nimQuestion, HttpStatus.OK);
        } catch (InvalidOperationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
