package com.mobbile.paul.bcmobiletrader.util

interface DomainMapper <T, E> {
    fun mapToDomainModel(entity: T): E
    fun mapFromDomainModel(domainModel: E): T
}