import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

fun readInputAsInt(name: String) = readInput(name).map { it.toInt() }

fun readInputAsPair(name: String) =
    readInput(name).map { it.split(' ') }.map { (a, b) -> Pair(a, b.toInt()) }

fun readInputAsIntArray(name: String) =
    readInput(name).map { it.toCharArray().toList() }.map { it.map(Character::getNumericValue) }


/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
