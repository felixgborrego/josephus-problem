import josephus.JosephusSolver
import util._

object Main {

  def main(args: Array[String]): Unit = CliParser.parse(args).map(run)

  def run(params: Params): Unit = {
    val solver = params.solver.getOrElse(JosephusSolver.DefaultSolver)
    implicit val logger = if (params.verbose) VerboseLogger else DummyLogger

    showInfo(params)
    showResult(solver.survivorPlace(params.nPlaces, params.kSteps))
  }

  def showInfo(params: Params): Unit = println(
    s"""Resolving Josephus problem for:
        |  Number of places: ${params.nPlaces} [labeled from 0 to ${params.nPlaces - 1}]
        |  Steps rate k: ${params.kSteps} [skipping ${params.kSteps - 1} before killing next one]
     """.stripMargin
  )

  def showResult[A](result: A): Unit = println(s"Survivor place: $result")

}