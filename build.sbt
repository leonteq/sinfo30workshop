organization := "tangeek"name := "Copilot Workshop"version := "1.0-SNAPSHOT"javacOptions in (Compile, compile) ++= Seq("-source", "1.8", "-target", "1.8", "-g:lines")libraryDependencies += "org.slf4j" % "slf4j-api" % "2.0.6"crossPaths := falseautoScalaLibrary := false