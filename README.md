# croala-twiddle

Analyzing CroALa Texts using [utwiddle](https://github.com/neelsmith/utwiddle).

## Data sets

- `data/croala.tsv` : a selection of CroALa texts in 2-column format.
- `data/croala.cex` : a selection of CroALa texts in a `.cex` repository.


## Quick start

    sbt console

From with the sbt console,

    > :load loadcroala.sc

This creates:

1. `corpus` : the complete CroALa corpus


For an introduction to working with these objects, see [this introductory guide](intro.md).


## A few sample scripts
