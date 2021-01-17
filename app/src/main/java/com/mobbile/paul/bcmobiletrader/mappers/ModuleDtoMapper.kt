package com.mobbile.paul.bcmobiletrader.mappers

import com.mobbile.paul.bcmobiletrader.domain.ModulesDto
import com.mobbile.paul.bcmobiletrader.model.ModuleModel
import com.mobbile.paul.bcmobiletrader.util.DomainMapper

class ModuleDtoMapper: DomainMapper<ModulesDto, ModuleModel>{

    override fun mapToDomainModel(entity: ModulesDto): ModuleModel {
        return ModuleModel (
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

    override fun mapFromDomainModel(domainModel: ModuleModel): ModulesDto {
        return ModulesDto(
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


    fun toDomainList(initial: List<ModulesDto>): List<ModuleModel>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<ModuleModel>): List<ModulesDto>{
        return initial.map { mapFromDomainModel(it) }
    }
}