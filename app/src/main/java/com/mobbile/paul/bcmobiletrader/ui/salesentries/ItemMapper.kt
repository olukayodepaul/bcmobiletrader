package com.mobbile.paul.bcmobiletrader.ui.salesentries


fun ItemsListDto.toItemsEntity(): ItemsListCache {
    return ItemsListCache(
        auto ,id, unit, itemno, price, company, custpricegroup
    )
}
