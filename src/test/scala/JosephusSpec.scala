import josephus.JosephusSolver
import org.specs2._
import util.DummyLogger

class JosephusSpec extends Specification {
  def is =
    s2"""

      For invalid parameters:
        n = -1                                        $nInvalid
        k = -1                                        $kInvalid

      For edge cases:
        n = k                                         $n5k5
        n = 1                                         $n1
        very large n and k =2                         $nLarge
        k > n                                         $n3k999

      For some examples:
        n = 3 and k = 2                               $n3k2
        n = 7 and k = 3                               $n7k3
        n = 41 and k = 3                              $n41k3
    """

  implicit val logger = DummyLogger
  val solver = JosephusSolver.DefaultSolver

  def nInvalid = solver.survivorPlace(-1, 2) must throwA[java.lang.IllegalArgumentException]
  def kInvalid = solver.survivorPlace(2, -4) must throwA[java.lang.IllegalArgumentException]
  def n1 = solver.survivorPlace(1, 5) must_== 0
  def n5k5 = solver.survivorPlace(5, 5) must_== 1
  def n3k2 = solver.survivorPlace(3, 2) must_== 2
  def n3k999 = solver.survivorPlace(3, 999) must_== 1
  def nLarge = solver.survivorPlace(90000, 80) must_== 67551
  def n41k3 = solver.survivorPlace(41, 3) must_== 30
  def n7k3 = solver.survivorPlace(7, 3) must_== 3

}