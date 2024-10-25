package com.example.demo.controller;

// Import các thư viện cần thiết
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Comment;
import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.service.CommentService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ItemService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService; // Dịch vụ xử lý Item
    @Autowired
    private CommentService commentService; // Dịch vụ xử lý Comment
    @Autowired
    private CustomerService customerService; // Dịch vụ xử lý Customer

    // Route để thêm bình luận mới
    @PostMapping("/item/{itemId}/addComment")
    public String addComment(@PathVariable("itemId") int itemId, 
                             @RequestParam("content") String content, 
                             HttpSession session,
                             Model model) {
        Item item = itemService.findById(itemId);
        // Lấy thông tin customer từ session
        String customerName = (String) session.getAttribute("customerName");

        if (customerName == null) {
            // Nếu người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
            return "redirect:/login";
        }

        // Lấy customer từ service
        Customer customer = customerService.findByUsername(customerName);

        // Tạo mới bình luận
        Comment newComment = new Comment();
        newComment.setItem(item);
        newComment.setCustomer(customer);
        newComment.setContent(content);

        // Lưu bình luận
        commentService.saveComment(newComment);

        // Redirect lại trang chi tiết sản phẩm
        return "redirect:/item/" + itemId;
    }
}
