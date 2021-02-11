package com.mobbile.paul.bcmobiletrader.ui.productlist



fun ProductListDto.toProductListEntity(): ProductListEntity {
    return ProductListEntity(
        auto ,id, groupname, item, name, unit, groupid, amount, checkitem, qty, shelf, backroom
    )
}

