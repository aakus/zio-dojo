ThisBuild / scalaVersion := "3.2.0"

val Versions = new {
  val zio = "2.0.2"
}

val commonSettings = Seq(
  scalacOptions -= "-Xfatal-warnings",
  libraryDependencies ++= Seq(
    "dev.zio" %% "zio" % Versions.zio,
    "dev.zio" %% "zio-streams" % Versions.zio,
    "dev.zio" %% "zio-test" % Versions.zio % Test,
    "dev.zio" %% "zio-test-sbt" % Versions.zio % Test,
    "dev.zio" %% "zio-test-magnolia" % Versions.zio % Test
  ),
  testFrameworks +=
    new TestFramework("zio.test.sbt.ZTestFramework")
)

lazy val rockthejvm = (project in file("rockthejvm"))
  .settings(
    commonSettings
  )

lazy val experiments = (project in file("experiments"))
  .settings(
    commonSettings
  )
