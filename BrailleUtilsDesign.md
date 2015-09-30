# Design #
The software should be:
  * Small
  * Extensible
  * Platform independent
  * Independent from third party libraries
  * Informative enough to build user friendly user interfaces on
  * Runnable as a Jar-file

Code written for this project must work under Java 1.6.

## XSLT and XPath ##
Some operations are best handled using XSLT and XPath. Where these technologies have been used, only the versions directly supported by Java has been used, i.e.
  * XSLT 1.0
  * XPath 1.0

Note that care must be taken not to use XSLT 2.0, since it is readily available in the coding environment. Saxon 8 is used for the validation functionality, but should not be used elsewhere.

## Jar Libraries ##
The goal to avoid using additional libraries if possible has been successful, except in validation and testing. Therefore, in order to use the PEF validator, the following libraries must be included in the class path:
  * isorelax.jar
  * jing.jar
  * saxon8.jar
  * xercesImpl.jar
  * xml-apis.jar

To run unit tests using Ant, "junit-4.4.jar" must be in the class path.

_If validation is not needed, no jar-files have to be included in the distribution._

## Services API ##
Java Services API is used for discovering implementations at runtime. The reason for using this technology instead of, for example, OSGi, is because the Services API is part of the JRE.

All services that an implementation wants to provide as Java services must be published in the `META-INF/services` folder. That folder should contain one file for each interface having implementations that should be provided as Java services. The file name must equal the interface's canonical name. The contents of each file should be a list of canonical names of classes implementing the interface indicated by the file name.

### Services Implementations ###
The following interfaces have been constructed so that they can be discovered as Java services:

  * org.daisy.braille.embosser.EmbosserProvider
  * org.daisy.braille.embosser.EmbosserCatalog
  * org.daisy.braille.table.TableProvider
  * org.daisy.braille.table.TableCatalog
  * org.daisy.paper.PaperProvider
  * org.daisy.paper.PaperCatalog
  * org.daisy.validator.Validator

All of these _may_ be discovered by the Services API. However, in most cases, one of the following interfaces will provide a starting point for a developer who wishes to add functionality to the software:
  * org.daisy.braille.embosser.EmbosserProvider
  * org.daisy.braille.table.TableProvider
  * org.daisy.paper.PaperProvider

## Factory Classes ##
The classes in the org.daisy.factory package provides the foundation for the interfaces used elsewhere in the software to discover and create objects. At the top level is the `Provider` interface. Its sole purpose is to provide a collection of factories. The factories implement the `Factory` interface.

_Note that the objects created using a `Factory` implementation are not controlled by these interfaces._

Different factories creating the same type of objects can be combined in a `FactoryCatalog`. The catalog can then be used to extract a list of all factories that can be used to create a specific type of objects.