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
	// Tensor support in scala
	"be.botkop" %% "numsca" % "0.1.5",
	//Neural net support:  inspired by PyTorch
	"be.botkop" %% "scorch" % "0.1.1"

	//"org.typelevel" %% "discipline-scalatest" % "1.0.0-RC1" % Test
	//"org.scalatest" %% "scalatest" % "3.0.3"
	//"com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
	//ScalaCheck
	// %% "scalacheck" % "1.14.3" % Test

//Specs2
	//"org.specs2" %% "specs2-core" % "4.0.2" % Test,
	//"org.specs2" %% "specs2-scalacheck" % "4.0.2" % Test
)
