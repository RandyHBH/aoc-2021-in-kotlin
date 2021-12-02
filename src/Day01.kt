fun main() {
    fun part1(input: List<Int>): Int {
        return input.windowed(2).count { (a, b) -> a < b }
    }

    // A + B + C = B + C + D
    fun part2(input: List<Int>): Int {
        return input
            .windowed(size = 3) { it.sum() }
            .windowed(2).count { (a, b) -> a < b }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsInt("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputAsInt("Day01")
    println(part1(input))
    println(part2(input))
}
