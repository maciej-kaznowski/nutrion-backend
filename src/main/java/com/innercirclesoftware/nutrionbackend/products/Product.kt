package com.innercirclesoftware.nutrionbackend.products

import com.innercirclesoftware.nutrionbackend.persistence.AuditModel
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "products")
data class Product(

        @Id
        @GeneratedValue
        var id: Long = 0L,

        @NotBlank
        @Size(min = 3)
        @Column(columnDefinition = "name")
        var name: String


) : AuditModel()