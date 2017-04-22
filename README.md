# croala-twiddle

Analyzing CroALa Texts using [utwiddle](https://github.com/neelsmith/utwiddle).

## Getting Started

You need to have [SBT](http://www.scala-sbt.org) installed.

In a terminal, navigate to the `croala-twiddle` directory and type

> `sbt console`

From with the sbt console,

> `:load loadcroala.sc` (type the initial colon!)

This loads the file `data/croala_big.cex` and creates:

1. `library` : an OHCO2 library of texts
1. `corpus` : the complete CroALa corpus

## API Guides

To see the documentation for the OHCO2 and CITE code libraries, follow these links:

- [CITE API (CTS and CITE URNs)](apis/cite/index.html)
- [OHCO2 API (Respository and Corpus objects)](apis/ohco2/index.html)

## Things to do

### URN Twiddling

- Create a URN-object identifying Herodotus' *Histories* at the work-level.

> `val hdtWorkUrn = CtsUrn("urn:cts:greekLit:tlg0016.tlg001:")`

- Create a URN-object identifying a version of Herodotus' *Histories*.

> `val hdtGreekUrn = CtsUrn("urn:cts:greekLit:tlg0016.tlg001.grc:")`

- Create a URN-object identifying another version of Herodotus' *Histories*.

>	`val hdtEnglishUrn = CtsUrn("urn:cts:greekLit:tlg0016.tlg001.eng:")``

- Does a citation to Herodotus’ *Histories* as a notional work include citations to Herodotus’ *Hisotories* in Greek?

> `hdtWorkUrn ~~ hdtGreekUrn` (see if the result is `true`)

- Is a citation to Herodotus in English also a citation to Herodotus?

> `hdtEnglishUrn ~~ hdtWorkUrn`

- Is a citation to Herodotus in Greek also a citation to Herodotus in English?

> `hdtGreekUrn ~~ hdtEnglishUrn`

### Corpus Twiddling & Corpus Arithmetic

- Pull the first ten lines of the *Iliad* out of `corpus`, and make a new Corpus object of them

> `val iliadFirstTen = corpus ~~ CtsUrn("urn:cts:greekLit:tlg0012.tlg001:1.1-1.10")`

- Look at your new corpus

> `printCorpus(iliadFirstTen)`

- Make another corpus with the next 10 lines

> `val iliadNextTen = corpus ~~ CtsUrn("urn:cts:greekLit:tlg0012.tlg001:1.11-1.20")`

- See them

> `printCorpus(iliadNextTen)`

- Do some “Corpus Arithmetic”

> `val iliadTwenty = iliadFirstTen ++ iliadNextTen`.

- See what you have

> `printCorpus(iliadTwenty)`

- Make another corpus, this time specifying *Iliad* 1.1-1.20 in a particular version

> `val iliadNewTwenty = corpus ~~ CtsUrn("urn:cts:greekLit:tlg0012.tlg001.allen:1.1-1.20")`

- Confirm that the two corpora are identical

> `iliadTwenty == iliadNewTwenty`

- **Exercise**: Create a corpus of *Iliad* 1.5-1.15. Then create a corpus that has *Iliad* 1.1-1.4 and 1.16-1.20, in the fewest possible steps.

## Exploring Corpora

- Make a corpus of Kuniç’ *Iliad*

> `val ilias = corpus ~~ iliadLatinUrn` (*n.b.* the `val` `iliadLatinUrn` was defined when you loaded `loadcroala.sc`. You can see its value by typing `iliadLatinUrn` in the console.)

- See it

> `printCorpus(ilias)`

- Get 2-grams in Kuniç’s *Ilias*, that occur at least 5 times, ignoring punctuation

> `ilias.ngramHisto(2,5,true)` (Note that you don’t actually have to do the `val X =` bit every time, in `sbt console`. You can simply make a Scala statement, and `sbt` will create a new `val` for it, names `resN`, where `N` is a number. You can use that as a `val` henceforth.)

- Confirm that the result is something you can consider scholarship by grabbing the *citations* for one of those ngrams

> `val ships = ilias.urnsForNGram("ad naves")`

- See what you got

> `for (u <- ships) println(u)`

- Use the up-arrow key to go back in your command-history, and play around with the N-Gram values.

- Let's find some bishops! Search the entire corpus for "episco"

> `val bishop = corpus.find("episco")`

- See what you got

> `printCorpus(bishop)`

- See just the URNs

> `for (u <- bishop.nodes) println(u.urn)`
