package com.mobbile.paul.bcmobiletrader.mappers

import com.mobbile.paul.bcmobiletrader.domain.DomainDataDto
import com.mobbile.paul.bcmobiletrader.model.ModuleModelData
import com.mobbile.paul.bcmobiletrader.util.DomainMapper

class ModuleDtoMapper: DomainMapper<DomainDataDto, ModuleModelData>{

    override fun mapToDomainModel(entity: DomainDataDto): ModuleModelData {
        return ModuleModelData (
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

    override fun mapFromDomainModel(domainModel: ModuleModelData): DomainDataDto {
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


    fun toDomainList(initial: List<DomainDataDto>): List<ModuleModelData>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<ModuleModelData>): List<DomainDataDto>{
        return initial.map { mapFromDomainModel(it) }
    }
}