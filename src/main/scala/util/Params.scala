package util

import josephus.JosephusSolver

case class Params(nPlaces: Int, kSteps: Int, verbose: Boolean, solver: Option[JosephusSolver])

object CliParser {

  private val parser = new scopt.OptionParser[Params]("run") {
    head("Josephus problem solver", "0.1")

    opt[Unit]("verbose")
      .action((_, c) => c.copy(verbose = true))
      .text("More verbose output")

    opt[String]("solver")
      .validate(name => if (JosephusSolver.lookUp(name).isDefined) success else failure(s"Invalid solver: $name"))
      .action((name, c) => c.copy(solver = JosephusSolver.lookUp(name)))
      .text(s"Select an alternative impl: $availableSolvers")

    help("help")
      .text("prints this usage text")

    arg[Int]("nPlaces")
      .required()
      .validate(n => if (n > 0) success else failure("n must be >0"))
      .action((n, c) => c.copy(nPlaces = n))
      .text("the number of places in the circle (n)")

    arg[Int]("kSteps")
      .required()
      .validate(k => if (k > 0) success else failure("k must be >0"))
      .action((k, c) => c.copy(kSteps = k))
      .text("the step rate (k)")

    override def showUsageOnError = true
  }

  def availableSolvers = JosephusSolver.all.map(_.name).mkString(" ")

  def parse(args: Array[String]): Option[Params] =
    parser.parse(args, Params(nPlaces = 0, kSteps = 0, verbose = false, solver = None))

}
