package valid

import scala.collection.mutable.Stack

object ValidParensSolution {

  val mapping = Map[String, String](
    "(" -> ")",
    "[" -> "]",
    "{" -> "}"
  )

  val reverseMapping = mapping.map(_.swap)

  def isValid(s: String): Boolean = {
    var stack = new Stack[String]()

    val split: List[String] = s.split("").toList
    val opening = mapping.keys.toList
    val closing = reverseMapping.keys.toList

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
