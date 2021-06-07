data class Cell(val x: Int, val y: Int, var alive: Boolean) {

    fun flipState() {
        this.alive = !this.alive;
    }
}