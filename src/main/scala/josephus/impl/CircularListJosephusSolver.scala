package josephus.impl

import josephus.JosephusSolver
import util.Logger

/**
  * Josephus problem solver implemented using a non recursive algorithm and an immutable circular list as a data structure.
  */
object CircularListJosephusSolver extends JosephusSolver {

  val name = "CircularList"

  override def survivorPlace(nPlaces: Int, kSteps: Int)(implicit log: Logger): Int = {
    require(nPlaces > 0 && kSteps > 0)

    val killsRange = (0 to nPlaces - 2)
    val initialPlaces = CircularList.build(nPlaces)

    val survivor = killsRange.foldLeft(initialPlaces) {
      case (places, step) =>
        val nextIndexToDrop = places.nextToKill(kSteps)
        log.debug(s"[step: $step] kill: ${places.list(nextIndexToDrop)}, places: $places")
        places.kill(nextIndexToDrop)
    }
    survivor.currentPlace
  }
}

private object CircularList {

  def build(nPeople: Int) =
    CircularList(
      list = (0 to nPeople - 1).toList,
      currentIndex = 0
    )

}

private case class CircularList[A](list: List[A], currentIndex: Int) {

  def nextToKill(kSteps: Int): Int = (currentIndex + kSteps - 1) % list.size

  def kill(indexToKill: Int): CircularList[A] =
    CircularList(
      list = list.patch(indexToKill, Nil, 1),
      currentIndex = indexToKill)

  def currentPlace: A = list.head

  override def toString: String = s"""[${list.mkString(" ")}]"""
}



