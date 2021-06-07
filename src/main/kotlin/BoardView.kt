import java.awt.*
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JPanel

class BView: JPanel() {
    var b = Board(20, 20)
    private val resetButton = Button("Reset")
    private val updateButton = Button("Next generation")
    init {
        addMouseListener(FlipListener(this))
        resetButton.addActionListener {
            b = Board(20, 20)
            repaint()
        }
        updateButton.addActionListener {
            b.updateBoard()
            repaint()
        }
        add(resetButton)
        add(updateButton)
        isFocusable = true
        preferredSize = Dimension(20*20, 20*20)
    }



    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        val g2d = g as? Graphics2D ?: return
        g2d.scale(20.0, 20.0)

        for (row in b.board) {
            row.forEach {
                if (it.alive) {
                    g2d.color = Color.YELLOW
                    g2d.fill(Rectangle(it.x, it.y, 1, 1))
                } else {
                    g2d.color = Color.GRAY
                    g2d.fill(Rectangle(it.x, it.y, 1, 1))
                }
            }
        }
    }
}


class GUI: JFrame(){
    init {
        title = "Game of life"
        isVisible = true
        isResizable = false
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        add(BView())
        pack()
    }
}

fun main() {
    EventQueue.invokeLater {
        GUI()
    }
}
