# Introduction #
This document contains information needed to run the command line user interface contained in the package. Note that this software doesn't target end users directly, but rather developers of user interfaces or braille systems. The functionality in the user interface does not demonstrate the full capability of the package.

# First Run #
To run the user interface, download and extract the latest release. If you do not have Java installed on your machine, you have to download and install that as well.

On the command line, navigate to the extracted folder and type:
`java -jar brailleUtils-ui.jar`. Press enter.

This will bring up a list of applications (or features):
  * [emboss](Emboss.md)
  * [text2pef](TextToPef.md)
  * [pef2text](PefToText.md)
  * [validate](ValidatePef.md)
  * [split](SplitPef.md)
  * [merge](MergePef.md)
  * [generate](GeneratePef.md)

These are explained in detail in separate sections.
To start one of them, append their name as the first argument, for example:
`java -jar brailleUtils-ui.jar emboss`