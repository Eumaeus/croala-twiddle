import scala.io.Source
import edu.holycross.shot.scm._
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._

val cexData = Source.fromFile("data/croala_big.cex").getLines.mkString("\n")
val library = CiteLibrary(cexData,"#")

val corpus = library.textRepository.get.corpus

println("")
println("=============================================")
println("Texts in Library")
println("")
for (t <- library.textRepository.get.catalog.texts) {
   println(t)
	 println(t.urn)
	 println("")
 }
println("=============================================")
println("")

def printNode(n:CitableNode):Unit = { println(s"${n.urn}\t ${n.text}") }
def printCorpus(c:Corpus) = for (cn <- c.nodes) println(s"${cn.urn}\t ${cn.text}")

val iliadLatinUrn = CtsUrn("urn:cts:croala:kunicr.ilias.croala_ohco2:")
val iliadGreekUrn = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.allen:")
val kunicUrn = CtsUrn("urn:cts:croala:kunicr.epigr.croala_ohco2:")
val krcelicUrn = CtsUrn("urn:cts:croala:krcelic.ann.croala_ohco2:")
val flaciusUrn = CtsUrn("urn:cts:croala:flacius.clavis.croala_ohco2:")


val il = corpus ~~ iliadGreekUrn

// create a new, subset Corpus with URN twiddling, e.g.,
//val flacius = corpus ~~ CtsUrn("urn:cts:croala:flacius.clavis2.croala_ohco2:")
