package com.final_project.staselko.controllers.server;

import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.entiti.Comment;
import com.final_project.staselko.servise.entiti.CommentService;
import com.final_project.staselko.utils.entiti.ObjectList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentsController {

    private final CommentService commentService;

    @PostMapping
    public void save(@Valid @RequestBody Comment comment) {
       commentService.saveCat(comment);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable(value = "id") long id,
                              @RequestBody Comment comment){
        commentService.updateComment(id, comment);
    }

    @GetMapping
    public ObjectList<CommentDto> getCommentByTicket(Long ticket_id){
        ObjectList<CommentDto> objectList = new ObjectList<>();
        objectList.setTicketsDto(commentService.getCommentsByTicket(ticket_id));
        return objectList;
    }

}
