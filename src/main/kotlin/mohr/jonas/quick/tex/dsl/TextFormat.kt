package mohr.jonas.quick.tex.dsl

enum class TextFormat {
    STRIKETHROUGH, UNDERLINE, BOLD, ITALIC;

    companion object {
        fun formatString(string: String, format: TextFormat): String {
            return when (format) {
                STRIKETHROUGH -> "\\sout{$string}"
                UNDERLINE -> "\\underline{$string}"
                BOLD -> "\\textbf{$string}"
                ITALIC -> "\\textit{$string}"
            }
        }
    }
}