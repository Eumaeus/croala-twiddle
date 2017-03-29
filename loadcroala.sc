
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.orca._
import edu.holycross.shot.greek._
import edu.holycross.shot.gsphone._
import org.homermultitext.edmodel._

val corpus = CorpusSource.fromFile("data/croala.tsv")

def printNode(n:CitableNode):Unit = { println(s"${n.urn}\t ${n.text}") }

val ilurn = CtsUrn("urn:cts:croala:kunicr.ilias.croala_ohco2:")
val w1 = CtsUrn("urn:cts:croala:kunicr.epigr.croala_ohco2:")
val w2 = CtsUrn("urn:cts:croala:krcelic.ann.croala_ohco2:")
val w3 = CtsUrn("urn:cts:croala:flacius.clavis.croala_ohco2:")


val il = corpus ~~ ilurn
val c1 = corpus ~~ w1 
val c2 = corpus ~~ w2
val c3 = corpus ~~ w3

// create a new, subset Corpus with URN twiddling, e.g.,
//val flacius = corpus ~~ CtsUrn("urn:cts:croala:flacius.clavis2.croala_ohco2:")
//
// analyze a corpus and create a sequence of TokenAnalysis objects:
//val tokens = TeiReader.fromCorpus(corpus)
