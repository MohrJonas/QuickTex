package mohr.jonas.quick.tex.dsl.elements

/**
 * Parent-elements are elements that can have sub-elements, like tables
 * */
abstract class ParentElement() : DslElement {

    private val children = mutableListOf<DslElement>()

    fun addChild(child: DslElement) = children.add(child)

    fun addChildren(vararg children: DslElement) = this.children.addAll(children)

    fun getChildren() = children
}