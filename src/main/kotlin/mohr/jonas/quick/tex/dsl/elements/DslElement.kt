package mohr.jonas.quick.tex.dsl.elements

/**
 * Root for all DSL-Elements
 * */
interface DslElement {

    /**
     * Express the element as a Latex-equivalent String
     * */
    fun toLatexString(): String

}