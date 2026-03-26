package com.saydullin.domain.mapper

interface Mapper<F, T> {

    fun map(from: F): T

}