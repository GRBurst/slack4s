// build
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.24")
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "0.6.0")
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.13.1")

// workflow
addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")

// deployment
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.2.6")

addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.2")
