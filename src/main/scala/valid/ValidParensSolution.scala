package valid

import scala.collection.mutable.Stack

object ValidParensSolution {

  val mapping = Map[String, String](
    "(" -> ")",
    "[" -> "]",
    "{" -> "}"
  )

  val reverseMapping: Map[String, String] = mapping.map(_.swap)

  def isValid(s: String): Boolean = {
    var stack: Stack[String] = new Stack[String]()

    val split: List[String] = s.split("").toList
    val opening: List[String] = mapping.keys.toList
    val closing: List[String] = reverseMapping.keys.toList

    split.foreach { curr: String =>
      if (opening.contains(curr)) stack.push(curr)
      else {
        if (closing.contains(curr))
          if (
            stack.headOption
              .map(_.equals(reverseMapping(curr)))
              .contains(true)
          )
            stack.pop()
          else stack.push(curr)
      }
    }

    stack.isEmpty
  }
}
