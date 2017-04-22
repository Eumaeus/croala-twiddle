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

### Corpus Twiddling

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

- **Exercise**: Create a corpus of *Iliad* 1.5-1.15. Then create a corpus that has *Iliad* 1.1-1.4 and 1.16-1.20, in the fewest possible steps.

## N-Grams
