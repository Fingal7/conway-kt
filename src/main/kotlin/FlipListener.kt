import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

class FlipListener(bView: BView): MouseAdapter() {
    private val panel = bView
    override fun mouseClicked(e : MouseEvent) {
        panel.b.board[e.x/20][e.y/20].flipState()
        panel.repaint()
    }
}