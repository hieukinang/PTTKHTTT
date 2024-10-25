package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository; // Giả sử bạn có repository cho Item
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findAll(); // Lấy tất cả Item
    }

    public List<Item> searchByName(String name) {
        return itemRepository.findByNameContainingIgnoreCase(name); // Tìm kiếm theo tên
    }

    public Item findById(int id) {
        return itemRepository.findById(id).orElse(null); // Tìm Item theo ID
    }
    
}
