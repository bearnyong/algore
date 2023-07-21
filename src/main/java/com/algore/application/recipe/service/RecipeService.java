package com.algore.application.recipe.service;

import com.algore.application.recipe.dao.RecipeViewMapper;
import com.algore.application.recipe.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecipeService {
    public final RecipeViewMapper mapper;

    public RecipeService(RecipeViewMapper mapper) {
        this.mapper = mapper;
    }

    public RecipeviewDTO DetailView(int recipeNum) {
        RecipeviewDTO recipeviewDTO = mapper.DetailView(recipeNum);
        List<RecipeOrderDTO> recipeOrderDTOList = mapper.recipeOrder(recipeNum);
        List<RecipePhotoDTO> recipePhotoDTOList = mapper.recipPhoto(recipeNum);
        List<RecipeIngredientDTO> recipeIngredientDTOS = mapper.recipeIngredient(recipeNum);
        List<IngredientDTO> ingredientDTOList = mapper.ingredienList();
        int allPrice =0;
        for (RecipeIngredientDTO recipeIngredientDTO:recipeIngredientDTOS) {
            allPrice += recipeIngredientDTO.getPrice();
        }
        System.out.println();
        recipeviewDTO.setIngredientDTOList(ingredientDTOList);
        recipeviewDTO.setAllPrice(allPrice);
        recipeviewDTO.setRecipeIngredientDTOS(recipeIngredientDTOS);
        recipeviewDTO.setRecipeOrderList(recipeOrderDTOList);
        recipeviewDTO.setRecipePhotoDTOList(recipePhotoDTOList);
        return recipeviewDTO;
    }


    public List<CommentReadDTO> commentRead(int recipeNum) {
        List<CommentReadDTO> commentReadDTOList = mapper.commentRead(recipeNum);
        return commentReadDTOList;
    }

    public int viewCount(int recipeNum) {
        int result = mapper.viewCount(recipeNum);
        return result;
    }

    public String getUserName(int recipeNum) {
        String name = mapper.getUserName(recipeNum);
        return name;
    }

    public int recipeDelete(int recipe) {
        int result = mapper.recipeDelete(recipe);
        return result;
    }


    public int writeRecipe(RecipeWriteDTO recipeWriteDTO) {

        int result = 0;
        try {
            result = mapper.writeRecipe(recipeWriteDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int modifyRecipe(RecipeviewDTO recipeviewDTO) {
        System.out.println("여기");
        int result = 0;

        int IngDelete =  mapper.recipeIngDelete(recipeviewDTO.getRecipeNum());
        int orderDelete = mapper.orderDelete(recipeviewDTO.getRecipeNum());

        int photoDelete = mapper.photoDelete(recipeviewDTO.getRecipeNum());
        System.out.println("여기");
        int orderResult = mapper.modifyOrder(recipeviewDTO.getModifyRecipeOrders());
        System.out.println("여기");
        int IngResult = mapper.modifyIng(recipeviewDTO.getRecipeIngredientDTOS());
        System.out.println("여기");

        int recipeResult = mapper.modifyRecipe(recipeviewDTO);
        int photoResult = mapper.modifyPhoto(recipeviewDTO.getRecipePhotoDTOList());

        if (recipeResult > 0) {
            System.out.println("성공");
            result = 1;
        }


        return result;
    }

    public List<RecipeCategoryDTO> readcategory() {

        List<RecipeCategoryDTO> recipecategory = mapper.readCategory();
        return recipecategory;
    }
}

