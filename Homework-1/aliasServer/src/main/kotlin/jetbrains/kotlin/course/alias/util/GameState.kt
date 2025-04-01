// jetbrains.kotlin.course.alias.util.GameState.kt
package jetbrains.kotlin.course.alias.util

import jetbrains.kotlin.course.alias.card.Card
import jetbrains.kotlin.course.alias.results.GameResult
import jetbrains.kotlin.course.alias.team.Team
import java.io.File

data class GameState(
    val gameHistory: List<GameResult>,
    val teamsStorage: Map<Identifier, Team>,
    val teamIdentifierCounter: Int,
    val cardIdentifierCounter: Int,
    val usedWords: List<String>
)