package com.innercirclesoftware.nutrionbackend.food.nutrients

import com.innercirclesoftware.nutrionbackend.persistence.AuditModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "food_nutrients")
data class FoodNutrient(

        @Id
        @Column(name = "id")
        val id: Long,

        @Column(name = "fdc_id")
        val foodId: Long,

        @Column(name = "nutrient_id")
        val nutrientId: Long,

        @Column(name = "amount")
        val amount: Double,

        @Column(name = "data_points")
        val dataPoints: String?,

        @Column(name = "derivation_id")
        val derivationId: Long?,

        @Column(name = "min")
        val min: Double?,

        @Column(name = "max")
        val max: Double?,

        @Column(name = "median")
        val median: Double?,

        @Column(name = "footnote")
        val footnote: String?,

        @Column(name = "min_year_acquired")
        val minYearAcquired: String?

) : AuditModel()