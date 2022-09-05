package com.example.numbercomposition.data

import com.example.numbercomposition.domain.entity.GameSettings
import com.example.numbercomposition.domain.entity.Level
import com.example.numbercomposition.domain.entity.Question
import com.example.numbercomposition.domain.repository.GameRepository
import java.lang.Integer.min

import kotlin.math.max
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(2, maxSumValue)
        val visibleNumber = Random.nextInt(1, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, 1)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }

        return Question(
            sum,
            visibleNumber,
            options.toList()
        )
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> GameSettings(
                10,
                3,
                50,
                8
            )

            Level.EASY -> GameSettings(
                10,
                10,
                70,
                60
            )

            Level.NORMAL -> GameSettings(
                20,
                20,
                80,
                40
            )

            Level.HARD -> GameSettings(
                30,
                30,
                90,
                40
            )
        }
    }
}