/** Returns a new read-only list of given elements. */
fun <T> listOf(vararg elements: T): List<T> {
    if (elements.size > 0) {
        elements.asList() 
    } else {
        emptyList()
    }
}
