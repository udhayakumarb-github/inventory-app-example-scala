ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.4"

lazy val root = (project in file("."))
  .settings(
    name := "inventory-app-example",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % "2.8.8",
      "com.typesafe.akka" %% "akka-stream" % "2.8.8",
      "com.typesafe.akka" %% "akka-http" % "10.5.3",
      "org.postgresql" % "postgresql" % "42.7.4",
      "com.typesafe.slick" %% "slick" % "3.5.2",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.5.2",
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.5.3"
    ),
    resolvers ++= Seq(
      "Akka Repository" at "https://repo.akka.io/releases",
      "Maven Central" at "https://repo1.maven.org/maven2",
      "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
    )
  )
