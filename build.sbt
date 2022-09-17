ThisBuild / scalaVersion := "3.2.0"

val Versions = new {
  val zio = "2.0.2"
}

val commonSettings: Seq[Setting[_]] = Seq(
  scalacOptions -= "-Xfatal-warnings",
  libraryDependencies ++= Seq(
    "dev.zio" %% "zio" % Versions.zio,
    "dev.zio" %% "zio-streams" % Versions.zio
  )
)

lazy val rockthejvm = (project in file("rockthejvm"))
  .settings(
    commonSettings
  )
