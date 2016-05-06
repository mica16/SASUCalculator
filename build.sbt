name := "SASU"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq("org.scalactic" %% "scalactic" % "2.2.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.mockito" % "mockito-core" % "2.0.52-beta")

resolvers ++= Seq("Artima Maven Repository" at "http://repo.artima.com/releases",
"Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases")

    