package com.ims.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ims.inventory.model.Item;
import com.ims.inventory.service.ItemService;

@Controller
public class InventoryController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "index";
    }

    @PostMapping("/addItem")
    public String addItem(@RequestParam String name, @RequestParam int quantity, @RequestParam double price) {
        Item item = new Item();
        item.setName(name);
        item.setQuantity(quantity);
        item.setPrice(price);
        itemService.saveItem(item);
        return "redirect:/";
    }

    @PostMapping("/deleteItem")
    public String deleteItem(@RequestParam Long id) {
        itemService.deleteItem(id);
        return "redirect:/";
    }
}
