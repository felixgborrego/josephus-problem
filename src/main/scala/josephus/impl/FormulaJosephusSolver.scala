package josephus.impl

import josephus.JosephusSolver
import util.Logger

/**
  * Josephus problem solver implemented using a direct mathematical formula.
  *
  * As the only expected output is the last place left, we can use this generic formula:
  * (N,K) = (f(N-1,K) + K) mod N
  *
  * See: https://en.wikipedia.org/wiki/Josephus_problem#The_general_case
  */
object FormulaJosephusSolver extends JosephusSolver {

  val name = "NonRecursiveFormula"

  override def survivorPlace(nPlaces: Int, kSteps: Int)(implicit log: Logger): Int = {
    require(nPlaces > 0 && kSteps > 0)
    val range = (2 to nPlaces)

    range.foldLeft(0) { (acc, n) =>
      log.debug(s"Acc: $acc, iteration: $n/$nPlaces")
      (acc + kSteps) % n
    }
  }
}
