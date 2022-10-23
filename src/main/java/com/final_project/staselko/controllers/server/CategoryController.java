package com.final_project.staselko.controllers.server;

import com.final_project.staselko.model.entiti.Category;
import com.final_project.staselko.servise.entiti.CategoryService;
import com.final_project.staselko.utils.param.ParamCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final ParamCreator creator;

    @GetMapping
    public Category getCategoryByName(@RequestParam(value = "category_name") String category_name){
        return categoryService.findByName(creator.getParamToDB(category_name));
    }
}
