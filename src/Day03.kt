fun main() {
    fun part1(input: List<List<Int>>): Int {
        val gamma = input.transpose().map { it.findMostRepeatedValue() }
        val epsilon = gamma.map { it xor 1 }

        return gamma.toDecimal() * epsilon.toDecimal()
    }

    fun part2(input: List<List<Int>>): Int {

        fun findRating(
            candidates: List<List<Int>>, pos: Int, criteria: (List<List<Int>>, Int) -> List<List<Int>>
        ): Int = when (candidates.size) {
            1 -> candidates.single().toDecimal()
            else -> findRating(criteria(candidates, pos), pos + 1, criteria)
        }

        val oxygenRating = findRating(input, 0, ::oxygenCriteria)
        val co2Rating = findRating(input, 0, ::co2Criteria)

        return oxygenRating * co2Rating
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsIntArray("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInputAsIntArray("Day03")
    println(part1(input))
    println(part2(input))
}

fun oxygenCriteria(candidates: List<List<Int>>, pos: Int) =
    candidates.filter { candidate -> candidate[pos] == candidates.transpose()[pos].findMostRepeatedValue() }

fun co2Criteria(candidates: List<List<Int>>, pos: Int) =
    candidates.filter { candidate -> candidate[pos] != candidates.transpose()[pos].findMostRepeatedValue() }

/**
 * Converts a Binary Number represented by a List<Int> to a Decimal number
 */
private fun List<Int>.toDecimal() = joinToString("").toInt(2)

private fun List<Int>.findMostRepeatedValue(): Int = if (count { it == 0 } > count { it == 1 }) 0 else 1

private fun <T> List<List<T>>.transpose(): List<List<T>> {
    val target: MutableList<List<T>> = emptyList<List<T>>().toMutableList()
    (0..first().lastIndex).forEach { index ->
        target.add(map { it[index] })
    }
    return target
}
