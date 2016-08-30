package josephus
import util.Logger

/** A base trait for the implementation of the Josephus problem.
  * Places labeled from 0 to n-1.
  * See: https://en.wikipedia.org/wiki/Josephus_problem
  */
trait JosephusSolver {

  def name: String

  /**
    * @param nPlaces the number of places in the circle (n)
    * @param kSteps  the step rate (k). (kSteps-1) steps to skip before removing the next one.
    * @return the place you need to stand in the circle to be the last one left.
    */
  def survivorPlace(nPlaces: Int, kSteps: Int)(implicit log: Logger): Int
}

object JosephusSolver {

  import josephus.impl._

  val all = Seq(FormulaJosephusSolver, CircularListJosephusSolver)

  def lookUp(name: String): Option[JosephusSolver] = all.find(_.name == name)

  val DefaultSolver = FormulaJosephusSolver
}

