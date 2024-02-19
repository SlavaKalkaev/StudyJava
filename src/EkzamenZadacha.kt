import java.io.File;
import java.util.regex.Matcher
import java.util.regex.Pattern

fun sortLetter(list: MutableList<String>) {

    if (list.isEmpty()) return

    var swap = true
    while (swap) {
        swap = false
        for (i in 1 until list.size) {
            if (list[i].compareTo(list[i - 1]) < 0) {
                val temp = list[i - 1]
                list[i - 1] = list[i]
                list[i] = temp
                swap = true
            }

        }
    }
}

fun s(list: MutableList<String>) {
    println()
    println("Отсортированные почты и проверенные через регулярные выражения: ")
    println()
    for (el in list) {
        println(el)
        println()
    }

}

fun ss(map: MutableMap<Char, Int>) {
    println("кол-во  встретившихся почт на буквы")
    for (el in map) {
        println(el)
        println()
    }

}


fun main() {
    val file = File("/Users/slavakalkaev/Downloads/mails.txt")
    val map = mutableMapOf<Char, Int>()
    var list = mutableListOf<String>()
    val lines = file.readLines()
    val regex = "^([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)"
    val pattern: Pattern = Pattern.compile(regex)
    val matcher: Matcher
    for (line in lines) {
        val match = pattern.matcher(line)
        if (match.matches()) {
            list.add(line)
        }
    }

    for (el in list) {
        if (map.get(el[0]) == null) {
            map.put(el[0], 1)
        } else {
            map.put(el[0], map.get(el[0])!! + 1)
        }
    }

    sortLetter(list)
    s(list)
    ss(map)

}

