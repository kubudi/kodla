resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
"org.specs2" %% "specs2-core" % "3.5" % "test",
"com.pusher" % "pusher-rest-java" % "0.9.0",
"com.typesafe" % "config" % "1.2.1")
