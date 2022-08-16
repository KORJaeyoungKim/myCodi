package com.one.mycodi.controller;

import com.one.mycodi.dto.request.CommentRequestDto;
import com.one.mycodi.dto.response.ResponseDto;
import com.one.mycodi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/api/comments")
    public ResponseDto<?> createComment(@RequestBody CommentRequestDto commentRequestDto, HttpServletRequest httpServletRequest) {
        return commentService.createComment(commentRequestDto, httpServletRequest);
    }

    @PutMapping("/api/comments/{id}")
    public ResponseDto<?> updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest httpServletRequest) {
        return commentService.updateComment(id, commentRequestDto, httpServletRequest);
    }

    @DeleteMapping("/api/comments/{id}")
    public ResponseDto<?> deleteComment(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        return commentService.deleteComment(id, httpServletRequest);
    }

    //해당 게시글에 있는 전체 댓글 가져오기
    @GetMapping("/api/comments")
    public ResponseDto<?> getComment(@RequestBody CommentRequestDto commentRequestDto){
        return commentService.getComment(commentRequestDto);
    }
}