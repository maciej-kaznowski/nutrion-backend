package com.innercirclesoftware.nutrionbackend.food

import com.innercirclesoftware.nutrionbackend.persistence.AuditModel
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "food")
data class Food(

        @Id
        @Column(name = "fdc_id")
        var id: Long,

        @NotBlank
        @Column(name = "data_type")
        var dataType: String,

        @NotBlank
        @Column(name = "description")
        var description: String,

        @NotBlank
        @Column(name = "food_category_id")
        var foodCategoryId: Long,


        @NotBlank
        @Column(name = "publication_date")
        var publicationDate: Date


) : AuditModel()