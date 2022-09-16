package mohr.jonas.quick.tex.dsl.elements.tikz

import mohr.jonas.quick.tex.dsl.elements.tikz.commands.TikzCommand

class Translation(val reference: TikzCommand) {

    var translationX = 0f
    var translationY = 0f

    fun left(amount: Number = 1): Translation {
        translationX -= amount.toFloat()
        return this
    }

    fun right(amount: Number = 1): Translation {
        translationX += amount.toFloat()
        return this
    }

    fun up(amount: Number = 1): Translation {
        translationY += amount.toFloat()
        return this
    }

    fun down(amount: Number = 1): Translation {
        translationY -= amount.toFloat()
        return this
    }
}