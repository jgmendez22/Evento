package com.example.evento.model

import javax.persistence.*


@Entity
@Table(name = "event")
class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var fullname: String? = null
    var description: String? = null
    var place: String? = null



}