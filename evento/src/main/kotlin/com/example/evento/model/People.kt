package com.example.evento.model

import javax.persistence.*


@Entity
@Table(name = "people")
class People {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var fullname: String? = null
    var email: String? = null



}