package com.innercirclesoftware.nutrionbackend.persistence

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.innercirclesoftware.nutrionbackend.utils.Dates
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.util.*
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
@JsonIgnoreProperties(
        value = ["createdAt", "updatedAt"],
        allowGetters = true
)
abstract class AuditModel(

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "created_at", nullable = false, updatable = false)
        @CreatedDate
        private var cretedAt: Date = Dates.now(),

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "updated_at", nullable = false, updatable = true)
        @LastModifiedDate
        private var updatedAt: Date = Dates.now()

) : Serializable
