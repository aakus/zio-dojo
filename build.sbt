ThisBuild / scalaVersion := "3.2.0"

val Versions = new {
  val zio = "2.0.4"
  val logging = "2.1.4"
}

val commonSettings = Seq(
  scalacOptions ++= Seq(
    "-source:future"
  ),
  resolvers ++= Seq(
    DefaultMavenRepository,
    JavaNet2Repository,
    "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  ),
  resolvers ++= Resolver.sonatypeOssRepos("public"),
  libraryDependencies ++= Seq(
    "net.objecthunter" % "exp4j" % "0.4.8",
    "dev.zio" %% "zio" % Versions.zio,
    "dev.zio" %% "zio-streams" % Versions.zio,
    "dev.zio" %% "zio-logging" % Versions.logging,
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
