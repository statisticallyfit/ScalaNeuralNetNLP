name := "ScalaNeuralNetNLP"

version := "0.1"

scalaVersion := "2.12.4" //"2.13.1"


resolvers +=
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

//resolvers += Resolver.sonatypeRepo("releases")


// disable printing a message indicating the success or failure of running a task
showSuccess := false


libraryDependencies ++= Seq(
	//"org.scala-lang" % "scala-library" % "2.12.0", //scala language
	//"org.scala-lang" % "scala-reflect" % "2.12.0", // scala compiler
	//Dependencies of Numsca:
	"org.nd4j" % "nd4j-native-platform" % "0.9.1",
	"com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
	"ch.qos.logback" % "logback-classic" % "1.2.3",
	"org.scalatest" %% "scalatest" % "3.0.3",

	// Actual Important Libraries Here:
	// Tensor support in scala
	"be.botkop" %% "numsca" % "0.1.5",
	//Neural net support:  inspired by PyTorch
	"be.botkop" %% "scorch" % "0.1.1",

	// Testing
	//Scala Reflections
	"org.scala-lang" % "scala-reflect" % "2.11.11",
	//ScalaCheck
	"org.scalacheck" %% "scalacheck" % "1.13.5" % Test,
	//Specs2
	"org.specs2" %% "specs2-core" % "4.0.2" % Test,
	"org.specs2" %% "specs2-scalacheck" % "4.0.2" % Test,
	//Discipline
	"org.typelevel" %% "discipline" % "0.8" //todo was 0.8 - evictions

	//"org.typelevel" %% "discipline-scalatest" % "1.0.0-RC1" % Test
	//"org.scalatest" %% "scalatest" % "3.0.3"
	//"com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
	//ScalaCheck
	// %% "scalacheck" % "1.14.3" % Test

//Specs2
	//"org.specs2" %% "specs2-core" % "4.0.2" % Test,
	//"org.specs2" %% "specs2-scalacheck" % "4.0.2" % Test
)
