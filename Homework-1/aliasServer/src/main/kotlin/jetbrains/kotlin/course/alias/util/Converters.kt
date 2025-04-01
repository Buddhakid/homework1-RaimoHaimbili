package jetbrains.kotlin.course.alias.util

import alias.JsCard
import alias.JsTeam
import jetbrains.kotlin.course.alias.card.Card
import jetbrains.kotlin.course.alias.results.GameJsResult
import jetbrains.kotlin.course.alias.results.GameResult
import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService

fun Card.toJsCard(): JsCard = JsCard(this.id, this.words.map { it.word }.toTypedArray())

fun Team.toJsTeam(): JsTeam = JsTeam(this.id, this.points, this.name)

fun List<Team>.toArrayJsTeams() = this.map { it.toJsTeam() }.toTypedArray()

fun GameJsResult.toGameResult(): GameResult = this.map { jsTeam ->
    val team = TeamService.teamsStorage[jsTeam.id] ?: error("Internal error! Unknown team with id: ${jsTeam.id} was received!")
    team.copy(points = jsTeam.points)
}