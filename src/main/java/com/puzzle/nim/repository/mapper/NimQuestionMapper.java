package com.puzzle.nim.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.puzzle.nim.domain.NimQuestion;

@Mapper
public interface NimQuestionMapper {
    List<Long> get(Long questionId);

    Long getNextQuestionId();

    int insert(@Param("questionId") Long questionId, @Param("piles") List<Long> piles);

    int update(Long questionId, NimQuestion nimQuestion);
}
