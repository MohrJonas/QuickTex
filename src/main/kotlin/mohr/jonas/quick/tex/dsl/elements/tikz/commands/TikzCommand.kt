package mohr.jonas.quick.tex.dsl.elements.tikz.commands

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.tikz.Translation
import java.awt.geom.Rectangle2D

abstract class TikzCommand(parent: DslElement?) : ChildElement(parent) {

    abstract fun getBounds(): Rectangle2D.Float

    fun left(amount: Number = 1) = Translation(this).left(amount)
    fun right(amount: Number = 1) = Translation(this).right(amount)
    fun up(amount: Number = 1) = Translation(this).up(amount)
    fun down(amount: Number = 1) = Translation(this).down(amount)
    fun center() = Translation(this)
}