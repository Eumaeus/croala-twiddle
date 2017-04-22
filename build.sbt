
// must be at least 2.11 to use hmt_textmodel
scalaVersion := "2.11.8"

resolvers += Resolver.jcenterRepo
resolvers += "beta" at "http://beta.hpcc.uh.edu/nexus/content/repositories/releases"
resolvers += Resolver.bintrayRepo("neelsmith", "maven")
libraryDependencies ++=   Seq(
  "edu.holycross.shot.cite" %% "xcite" % "2.2.3",
	"edu.holycross.shot" %% "ohco2" % "8.0.1",
  "edu.holycross.shot" %% "scm" % "2.1.2"
)
