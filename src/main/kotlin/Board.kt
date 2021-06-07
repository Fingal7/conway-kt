import java.lang.Integer.max
import java.lang.Integer.min
import java.util.*
data class Board(val rows: Int, val cols: Int) {

    val board = initBoard(rows, cols)

    fun setBoard(xlist: ArrayDeque<Int>, ylist: ArrayDeque<Int>) {
        while (!xlist.isEmpty()) {
            board[xlist.peek()][ylist.peek()].flipState()
            xlist.pop()
            ylist.pop()
        }
    }

    fun updateBoard() {
        val xtoFlip = ArrayDeque<Int>()
        val ytoFlip = ArrayDeque<Int>()
        // Could be made better without nested for loops.
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j].alive) when(countLiveNeighbors(i, j)) {
                    0, 1 -> {
                        xtoFlip.push(i)
                        ytoFlip.push(j)
                    }
                    2, 3 -> {}
                    else -> {
                        xtoFlip.push(i)
                        ytoFlip.push(j)
                    }
                } else when(countLiveNeighbors(i, j)) {
                    3 -> {
                        xtoFlip.push(i)
                        ytoFlip.push(j)
                    }
                    else -> {}
                }
            }
        }
        while (!xtoFlip.isEmpty() && !ytoFlip.isEmpty()) {
            board[xtoFlip.peek()][ytoFlip.peek()].flipState()
            xtoFlip.pop()
            ytoFlip.pop()
        }
    }

    private fun initBoard(rows: Int, cols: Int): Array<Array<Cell>> {
        return Array(rows){
                i -> Array(cols){ j -> Cell(i, j, false) }
        }
    }

    private fun countLiveNeighbors(row: Int, col: Int): Int {
        var count = 0;
        for (i in max(row - 1, 0)..min(board.size - 1, row + 1)) {
            for (j in max(col - 1, 0)..min(board.size - 1, col + 1)) {
                if (board[i][j].alive && !(i == row && j == col)) {
                    count++
                }
            }
        }
        return count
    }

    fun getAlive(): List<Cell> {
        val aliveList = arrayListOf<Cell>()
        for (row in board) {
            row.forEach { cell -> if (cell.alive) {
                    aliveList.add(cell)
                }
            }
        }
        return aliveList
    }
}