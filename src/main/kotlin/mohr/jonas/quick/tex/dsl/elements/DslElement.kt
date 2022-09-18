package mohr.jonas.quick.tex.dsl.elements

/**
 * Root for all DSL-Elements
 * */
abstract class DslElement(val parent: DslElement?) {

    /**
     * Express the element as a Latex-equivalent String
     * */
    abstract override fun toString(): String

}