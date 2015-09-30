# PEF to Text #
Convert a PEF-file document into a text braille file.

Two arguments are required _path to input file_ and _path to output file_.

Optional arguments include:
  * range
  * table
  * breaks
  * fallback
  * replacement

## Range ##
Output a range of pages.

## Table ##
Set the table (character mapping) to use.

## Breaks ##
Set the line break style. Most braille applications use DOS line breaks.

## Fallback ##
Set the action to use if an eight dot pattern is encountered and the current table does not support eight dot:
  * mask
  * replace
  * remove

## Replacement ##
Set the replacement character to use if an eight dot pattern is encountered and fallback is set to "replace".