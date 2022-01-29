name := "jackson-scala3-reflection-sample"
organization := "com.github.pjfanning"

ThisBuild / scalaVersion := "3.1.1"

val jacksonVersion = "2.13.1"
val scalaReflectionVersion = "1.1.4"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonVersion,
  "com.github.pjfanning" %% "jackson-scala3-reflection-extensions" % "2.13.1+9-b4ac6b2d-SNAPSHOT",
  "co.blocke" %% "scala-reflection" % scalaReflectionVersion
)

addCompilerPlugin("co.blocke" %% "scala-reflection" % scalaReflectionVersion)

homepage := Some(url("https://github.com/pjfanning/jackson-scala3-reflection-sample"))

licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

