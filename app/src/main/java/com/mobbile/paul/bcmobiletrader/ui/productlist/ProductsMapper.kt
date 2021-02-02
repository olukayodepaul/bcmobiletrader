package com.mobbile.paul.bcmobiletrader.ui.productlist



fun ProductListDto.toProductListEntity(): ProductListEntity {
    return ProductListEntity(
        auto,id, name, amount, code, qty, products, checked, sheffstock, backroomstock, qtypurchase
    )
}

