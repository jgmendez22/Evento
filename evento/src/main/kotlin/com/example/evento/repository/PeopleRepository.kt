package com.example.evento.repository

import com.example.evento.model.People
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PeopleRepository: JpaRepository<People, Long> {
    fun findById (id: Long?): People

}