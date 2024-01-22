name := "jackson-scala3-reflection-sample"
organization := "com.github.pjfanning"

ThisBuild / scalaVersion := "3.3.1"

val jacksonVersion = "2.16.1"
val scalaReflectionVersion = "1.2.0"

libraryDependencies ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonVersion,
  "com.github.pjfanning" %% "jackson-scala3-reflection-extensions" % "2.16.0",
  "com.github.pjfanning" %% "scala3-reflection" % scalaReflectionVersion
)

addCompilerPlugin("com.github.pjfanning" %% "scala3-reflection" % scalaReflectionVersion)

homepage := Some(url("https://github.com/pjfanning/jackson-scala3-reflection-sample"))

licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

