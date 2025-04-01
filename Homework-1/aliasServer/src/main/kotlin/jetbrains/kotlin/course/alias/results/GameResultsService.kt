package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService

import org.springframework.stereotype.Service

typealias GameResult = List<Team>

@Service

class GameResultsService {
    companion object {
        val gameHistory: MutableList<GameResult> = mutableListOf()
    }

    fun saveGameResults(result: GameResult) {
        require(result.isNotEmpty()) { "Result must not be empty" }
        require(result.all { it.id in TeamService.teamsStorage }) {
            "All team IDs must exist in storage"
        }
        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> = gameHistory.asReversed()
}