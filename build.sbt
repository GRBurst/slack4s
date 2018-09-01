organization := "com.github.grburst"
name := "slack4s"

scalaVersion := "2.12.6"
scalacOptions ++=
    "-encoding" :: "UTF-8" ::
    "-unchecked" :: // Enable additional warnings where generated code depends on assumptions
    "-deprecation" ::
    "-explaintypes" :: // Explain type errors in more detail
    "-feature" ::
    "-language:_" ::
    "-Xfuture" ::
    "-Yno-adapted-args" ::
    "-Ywarn-infer-any" ::
    "-Ywarn-nullary-override" ::
    "-Ywarn-nullary-unit" ::
    Nil

libraryDependencies ++= Seq(
  "org.scalatest"   %% "scalatest"    % "3.0.5"   % "test",
)
