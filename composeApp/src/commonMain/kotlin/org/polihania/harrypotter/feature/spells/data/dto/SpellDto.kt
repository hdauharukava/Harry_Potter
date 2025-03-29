package org.polihania.harrypotter.feature.spells.data.dto

import kotlinx.serialization.Serializable
import org.polihania.harrypotter.core.utils.orZero
import org.polihania.harrypotter.feature.spells.domain.model.SpellModel

@Serializable
class SpellDto(
    val index: Int? = null,
    val spell: String? = null,
    val use: String? = null
)

fun SpellDto.toModel() = SpellModel(
    index = index.orZero(),
    spell = spell.orEmpty(),
    description = use.orEmpty()
)

fun List<SpellDto>.toModelList() = map { it.toModel() }