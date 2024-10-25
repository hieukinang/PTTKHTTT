package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.model.Item;
import com.example.demo.service.CommentService;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/home")
    public String home(Model model) {
        // Lấy danh sách các item
        List<Item> itemList = itemService.findAll();

        // Truyền danh sách item tới view
        model.addAttribute("items", itemList);

        // Trả về tên file Thymeleaf (home.html)
        return "home";
    }


    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<Item> items = itemService.searchByName(query); // Tìm kiếm theo tên
        model.addAttribute("items", items);
        return "home"; // Trả về template home.html với danh sách tìm kiếm
    }

    @GetMapping("/item/{id}")
    public String getItemDetails(@PathVariable("id") int id, Model model) {
        Item item = itemService.findById(id); // Tìm kiếm Item theo ID
        List<Comment> comments = commentService.getCommentsByItem(item);

        System.out.println("ok");
        System.out.println(comments);
        System.out.println(item);
        
        model.addAttribute("item", item);
        model.addAttribute("comments", comments);
        return "itemDetails"; // Trả về template itemDetails.html
    }

}
