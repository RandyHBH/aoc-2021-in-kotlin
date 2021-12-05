fun main() {
    fun part1(input: List<Pair<String, Int>>): Int {
        var horizontal = 0
        var depth = 0

        for ((direction, amount) in input) {
            when (direction) {
                "forward" -> horizontal += amount
                "down" -> depth += amount
                "up" -> depth -= amount
            }
        }

        return horizontal * depth
    }


    fun part2(input: List<Pair<String, Int>>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0

        for ((direction, amount) in input) {
            when (direction) {
                "forward" -> {
                    horizontal += amount
                    depth += aim * amount
                }
                "down" -> {
                    aim += amount
                }
                "up" -> {
                    aim -= amount
                }
            }
        }
        return horizontal * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsPair("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInputAsPair("Day02")
    println(part1(input))
    println(part2(input))
}
