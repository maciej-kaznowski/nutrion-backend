package com.innercirclesoftware.nutrionbackend.products

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductController(@Autowired val repo: ProductRepository) {

    @GetMapping("/{id}")
    fun `find product by id`(@PathVariable("id") id: String): Product {
        return repo.findById(id.toLong()).get()
    }
}