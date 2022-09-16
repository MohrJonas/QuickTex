package mohr.jonas.quick.tex.dsl.elements

/**
 * Parent-elements are elements that can have sub-elements, like tables
 * */
abstract class ParentElement(parent: DslElement?) : DslElement(parent) {

    private val children = mutableListOf<DslElement>()

    fun addChild(child: DslElement) = children.add(child)

    fun getChildren() = children
}