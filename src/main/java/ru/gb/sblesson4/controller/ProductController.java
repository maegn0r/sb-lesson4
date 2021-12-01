package ru.gb.sblesson4.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.sblesson4.entity.Product;
import ru.gb.sblesson4.service.ProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/create")
    public String showSimpleForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "create-product";
    }

    @PostMapping("/create")
    public String processForm(Product product) {
        if (product.getId() == null) {
            productService.addProduct(product);
        } else {
            productService.editProduct(product);
        }
        return "redirect:/product";
    }

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @GetMapping("/{id}")
    public String printProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product";
    }

}
