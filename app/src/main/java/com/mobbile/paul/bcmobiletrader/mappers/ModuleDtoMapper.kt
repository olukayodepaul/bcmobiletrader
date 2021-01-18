package com.mobbile.paul.bcmobiletrader.mappers

import com.mobbile.paul.bcmobiletrader.domain.DomainDataDto
import com.mobbile.paul.bcmobiletrader.model.NetworkMapperModelData
import com.mobbile.paul.bcmobiletrader.util.DomainMapper

class ModuleDtoMapper: DomainMapper<DomainDataDto, NetworkMapperModelData>{

    override fun mapToDomainModel(entity: DomainDataDto): NetworkMapperModelData {
        return NetworkMapperModelData (
            id = entity.pk,
            title = entity.title,
            featuredImage = entity.featuredImage,
            rating = entity.rating,
            publisher = entity.publisher,
            sourceUrl = entity.sourceUrl,
            description = entity.description,
            cookingInstructions = entity.cookingInstructions,
            ingredients = entity.ingredients?: listOf(),
            dateAdded = entity.dateAdded,
            dateUpdated = entity.dateUpdated
        )
    }

    override fun mapFromDomainModel(domainModel: NetworkMapperModelData): DomainDataDto {
        return DomainDataDto(
            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients,
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated
        )
    }


    fun toDomainList(initial: List<DomainDataDto>): List<NetworkMapperModelData>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<NetworkMapperModelData>): List<DomainDataDto>{
        return initial.map { mapFromDomainModel(it) }
    }
}