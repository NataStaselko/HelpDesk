package com.final_project.staselko.controllers.server;

import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.entiti.Comment;
import com.final_project.staselko.servise.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentsController {

    private final CommentService commentService;

    @PostMapping
    public Comment save(@Valid @RequestBody Comment comment) {
        return commentService.saveCat(comment);
    }

    @GetMapping("{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "id") long id){
        CommentDto commentDto = commentService.getCommentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(commentDto);
    }
}
