package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service

class TeamService(
    private val identifierFactory: IdentifierFactory = IdentifierFactory()
) {
    companion object {
        val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }

    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        require(teamsNumber > 0) { "Number of teams must be positive" }
        return List(teamsNumber) {
            Team(identifierFactory.uniqueIdentifier()).also { team ->
                teamsStorage[team.id] = team
            }
        }
    }
}