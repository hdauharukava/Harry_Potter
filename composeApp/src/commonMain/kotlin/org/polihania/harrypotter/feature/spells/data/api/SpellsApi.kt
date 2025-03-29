package org.polihania.harrypotter.feature.spells.data.api

import kotlinx.coroutines.flow.Flow
import org.polihania.harrypotter.core.data.HttpClientProvider
import org.polihania.harrypotter.core.data.fetchDataWithQuery
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.spells.data.dto.SpellDto

class SpellsApi(
    clientProvider: HttpClientProvider
) {
    private val client = clientProvider.getClient()

    fun getSpells(
        index: Int? = null,
        max: Int? = null,
        page: Int? = null,
        search: String? = null
    ): Flow<Data<List<SpellDto>>> {
        return fetchDataWithQuery(
            client = client,
            endpoint = "spells",
            index = index,
            max = max,
            page = page,
            search = search
        )
    }
}